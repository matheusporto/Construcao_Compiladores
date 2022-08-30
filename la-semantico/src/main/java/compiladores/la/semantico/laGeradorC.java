
package compiladores.la.semantico;
import compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import java.util.ArrayList;
import java.util.List;

public class laGeradorC extends laBaseVisitor<Void>{
    StringBuilder saida;
    TabelaDeSimbolos tabela;
   
    List<String> struct = new ArrayList<String>();
    List<TipoLA> structTipo = new ArrayList<TipoLA>();
    
    //Flags auxiliares
    Boolean decRegistro = false;
    Boolean isRegistro = false;
    String nomeRegistro;
    
    public laGeradorC() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
    }
    
    @Override
    public Void visitPrograma(laParser.ProgramaContext ctx) {
        
        //includes
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        
        //declaracoes globais
        ctx.declaracoes().decl_local_global().forEach(dec -> visitDecl_local_global(dec));
        saida.append("\n");
        
        //int main + declaracoes locais + corpo
        saida.append("int main() {\n");
        ctx.corpo().declaracao_local().forEach(dec -> visitDeclaracao_local(dec));
        ctx.corpo().cmd().forEach(cmd -> visitCmd(cmd));
        
        //return
        saida.append("\treturn 0;\n");
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitDeclaracao_local(laParser.Declaracao_localContext ctx) {

         if(ctx.variavel() != null){
            visitVariavel(ctx.variavel());
        }
        else if(ctx.valor_constante() != null){ //#define
            saida.append("#define " + ctx.IDENT().getText() + " " + ctx.valor_constante().getText() + "\n\n");
        }
        else if(ctx.IDENT() != null){ //structs
            saida.append("typedef struct{\n");
            visitTipo(ctx.tipo());
            saida.append("}\n");
            saida.append(ctx.IDENT().getText());
            saida.append(";\n");
        }
        
        return null;
    }

    @Override
    public Void visitVariavel(laParser.VariavelContext ctx) {
        
        TipoLA tipoLA = TipoLA.INVALIDO;
        String tipoVar = ctx.tipo().getText();
        String nomeVar;
        
        if(ctx.tipo().registro() == null){ //nao é registro
            switch(tipoVar){
                case "inteiro":
                case "^inteiro":
                    tipoVar = "int";
                    tipoLA = TipoLA.INTEIRO;
                    break;
                case "real":
                case "^real":
                    tipoVar = "float";
                    tipoLA = TipoLA.REAL;
                    break;
                case "literal":
                case "^literal":
                    tipoVar = "char";
                    tipoLA = TipoLA.LITERAL;
                    break;
                case "logico":
                case "^logico":
                    tipoLA = TipoLA.LOGICO;
                    break;
                default:
                    decRegistro = true;
                    break;
            }
            // se chega aqui é registro
            if(decRegistro){
                for(Integer i = 0; i < struct.size(); i++){
                    tabela.adicionar(struct.get(i), structTipo.get(i)); //salva as infos da struct
                }
            }

            if(ctx.tipo().tipo_estendido() != null){
                if(ctx.tipo().tipo_estendido().ponteiro != null){ //caso seja ponteiro
                    saida.append("\t" + tipoVar + "* ");
                }
                else{ // caso não seja ponteiro
                    saida.append("\t" + tipoVar + " ");
                }
            }
            else{
                saida.append("\t" + tipoVar + " ");
            }

            for (Integer i = 0; i < ctx.identificador().size(); i++){
                nomeVar = ctx.identificador(i).IDENT(0).getText();
                if(isRegistro == false){
                    tabela.adicionar(nomeVar, tipoLA);
                }
                else{
                    tabela.adicionar(nomeRegistro + "." + nomeVar, tipoLA);
                }
                
                saida.append(nomeVar);
                
                if(tipoLA == TipoLA.LITERAL){ //literal

                    saida.append("[80]");
                }
                
                if(ctx.identificador(0).dimensao() != null){ //vetor
                    saida.append(ctx.identificador(0).dimensao().getText());
                }
                
                if(i == ctx.identificador().size() - 1){ //ponto e virgula no ultimo
                    saida.append(";\n");
                }
                else{ //virgula para separa todos que não sejam os ultimos
                    saida.append(", ");
                }
            }
        }
        else{
            // é registro, então appenda todas suas variaveis
            isRegistro = true;           
            saida.append("\tstruct {\n");
        
            nomeVar = ctx.identificador(0).IDENT(0).getText();
            nomeRegistro = nomeVar;  
            Integer qtdVar = ctx.tipo().registro().variavel().size();
            for(Integer i = 0; i < qtdVar; i++){
                saida.append("\t");
                visitVariavel(ctx.tipo().registro().variavel(i));
            } 
            isRegistro = false;            
            saida.append("\t} "+ nomeVar + ";\n");      
        }
        
        return null;
    }

    @Override
    public Void visitCmdatribuicao(laParser.CmdatribuicaoContext ctx) {

        if (ctx.ponteiro != null) { //ponteiro
            saida.append("*");
        }
        if (ctx.identificador().IDENT().size() > 1) {
            if (tabela.verificar(ctx.identificador().getText()) == TipoLA.LITERAL) {
                saida.append("strcpy(" + ctx.identificador().getText() + "," + ctx.expressao().getText() + ");\n");
            } else {
                saida.append(ctx.identificador().getText() + " = ");
                saida.append(ctx.expressao().getText() + ";\n");
            }
        } else {
            saida.append(ctx.identificador().getText() + " = ");
            saida.append(ctx.expressao().getText() + ";\n");
        }
        return null;
    }

    @Override
    public Void visitCmdse(laParser.CmdseContext ctx) {
        
        saida.append("\tif(");
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        saida.append("){\n\t");
        visitCmd(ctx.cmd(0));
        saida.append("\t}\n");
        if (ctx.cmd().size() > 1) { 
            saida.append("\telse {\n\t");
            visitCmd(ctx.cmd(1));
            saida.append("\t}\n");
        }
        return null;
    }

    @Override
    public Void visitCmdleia(laParser.CmdleiaContext ctx) {
        
        String nomeVar = ctx.identificador(0).IDENT(0).getText();
        TipoLA tipoVariavel = tabela.verificar(nomeVar);
        String aux = "";
        switch (tipoVariavel) {
            case INTEIRO:
                aux = "%d";
                break;
            case REAL:
                aux = "%f";
                break;
            default:
                break;
        }
        if (aux.isEmpty()) // não é inteiro nem real, ai usa gets
           saida.append("\tgets(" + nomeVar + ");\n");
        else
            saida.append("\tscanf(\"" + aux + "\", &" + nomeVar + ");\n");
        return null;
    }

    @Override
    public Void visitCmdenquanto(laParser.CmdenquantoContext ctx) {
        
        saida.append("\twhile(");
        visitExp_relacional(ctx.expressao().termo_logico(0).fator_logico(0).parcela_logica().exp_relacional());
        saida.append(") {\n");
        
        for (laParser.CmdContext cmd : ctx.cmd()) {
            saida.append("\t");
            visitCmd(cmd);
        }
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitCmdfaca(laParser.CmdfacaContext ctx) {
        //do while
        saida.append("\tdo{\n");
        
        ctx.cmd().forEach(dec -> visitCmd(dec));
        saida.append("\t}\n");
        saida.append("\twhile(");
        
        visitExpressao(ctx.expressao());
        
        return null;
    }

    @Override
    public Void visitCmdescreva(laParser.CmdescrevaContext ctx) {
        
        ctx.expressao().forEach(exp -> { 
            if (exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0) != null) {
            
                TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, exp);
                String aux = "";
                switch (tipoExpressao) {
                    case INTEIRO:
                        aux = "%d";
                        break;
                    case REAL:
                        aux = "%f";
                        break;
                    case LITERAL:
                        aux = "%s";
                        break;
                    default:
                        break;
                }
                saida.append("\tprintf(");
                if (!exp.getText().startsWith("\"")){
                    saida.append("\"" + aux + "\", ");
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                else{
                    visitExp_aritmetica(exp.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0));
                }
                saida.append(");\n");
            }
        });
        return null;
    }

    @Override
    public Void visitCmdcaso(laParser.CmdcasoContext ctx) {
        
        saida.append("\tswitch ( ");
        visitExp_aritmetica(ctx.exp_aritmetica());
        saida.append(" ) {\n");
        for (laParser.Item_selecaoContext item : ctx.selecao().item_selecao()) {
            visitItem_selecao(item);
        }
        saida.append("\tdefault:\n\t\tbreak;\n");
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitCmdpara(laParser.CmdparaContext ctx) {
        
        saida.append("\tfor ( ");
        saida.append(ctx.IDENT() + "=");
        visitExp_aritmetica(ctx.exp_aritmetica(0));
        
        saida.append(";" + ctx.IDENT() + "<=");
        visitExp_aritmetica(ctx.exp_aritmetica(1));
        
        saida.append(";" + ctx.IDENT() + "++) {\n");
        for (laParser.CmdContext item : ctx.cmd()) {
            visitCmd(item);
        }
        saida.append("\t}\n");
        return null;
    }

    @Override
    public Void visitItem_selecao(laParser.Item_selecaoContext ctx) {

        Integer inicio = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
        if (ctx.constantes().numero_intervalo(0).NUM_INT(1) != null){
            Integer fim = Integer.parseInt(ctx.constantes().numero_intervalo(0).NUM_INT(1).getText());
            for (int i = inicio; i <= fim; i++){
                saida.append("\tcase ");
                saida.append(i);
                saida.append(":\n");
                for (laParser.CmdContext cmd : ctx.cmd()) {
                    saida.append("\t");
                    visitCmd(cmd);
                    saida.append("\t\tbreak;\n");
                }
            }
        }
        else {
            saida.append("\tcase ");
            saida.append(ctx.constantes().numero_intervalo(0).NUM_INT(0).getText());
            saida.append(":\n");
            for (laParser.CmdContext cmd : ctx.cmd()) {
                saida.append("\t");
                visitCmd(cmd);
                saida.append("\t\tbreak;\n");
            }
        }
        return null;
    }

    @Override
    public Void visitExp_aritmetica(laParser.Exp_aritmeticaContext ctx) {
         visitTermo(ctx.termo(0));
        for (int i = 0; i < ctx.op1().size(); i++) {
            saida.append(" " + ctx.op1(i).getText() + " ");
            visitTermo(ctx.termo(i + 1));
        }
        return null;
    }
    
    @Override
    public Void visitTermo(laParser.TermoContext ctx) {
        visitFator(ctx.fator(0));
        for (int i = 0; i < ctx.op2().size(); i++) {
            saida.append(" " + ctx.op2(i).getText() + " ");
            visitFator(ctx.fator(i + 1));
        }
        return null;
    }
    
    @Override
    public Void visitFator(laParser.FatorContext ctx) {
        visitParcela(ctx.parcela(0));
        for (int i = 0; i < ctx.op3().size(); i++) {
            saida.append(" " + ctx.op3(i).getText() + " ");
            visitParcela(ctx.parcela(i + 1));
        }
        return null;
    }
    
    @Override
    public Void visitParcela(laParser.ParcelaContext ctx) {
        if (ctx.parcela_nao_unario() != null){
            String aux = ctx.parcela_nao_unario().CADEIA().getText();
            saida.append(aux);
        }
        if (ctx.parcela_unario() != null){
            if (ctx.parcela_unario().NUM_INT() != null) {
                saida.append(ctx.parcela_unario().NUM_INT().getText());
            } else if (ctx.parcela_unario().NUM_REAL() != null) {
                saida.append(ctx.parcela_unario().NUM_REAL().getText());
            } else if (ctx.parcela_unario().identificador().IDENT(0) != null) {
                saida.append(ctx.parcela_unario().identificador().IDENT(0).getText());
            } else {
                saida.append("(");
                saida.append(")");
            }
        }
        return null;
    }
    
    @Override
    public Void visitFator_logico(laParser.Fator_logicoContext ctx)
    {
        if(ctx.neg != null){ //negativa 
            saida.append("!");
        }
        visitParcela_logica(ctx.parcela_logica());
        
        return null;
    }

    @Override
    public Void visitExp_relacional(laParser.Exp_relacionalContext ctx) {
        
        if(ctx.op_relacional(0) != null){
            saida.append(ctx.exp_aritmetica(0).getText() + " ");
            if(ctx.op_relacional(0).getText().equals("=")){
                saida.append("==");
            }
            else if(ctx.op_relacional(0).getText().equals("<>")){

                saida.append("!=");
            }
            else{
                saida.append(ctx.op_relacional(0).getText());
            }
            saida.append(" " + ctx.exp_aritmetica(1).getText());
        }
        else{ // entra aqui se não tiver operadores relacionais
            for (Integer i = 0; i < ctx.exp_aritmetica().size(); i++){
                visitExp_aritmetica(ctx.exp_aritmetica(i));
            }
        }
        return null;
    }

    @Override
    public Void visitOp_relacional(laParser.Op_relacionalContext ctx) {
        String aux = "";
        switch (ctx.getText()) {
            case "=":
                aux = "==";
                break;
            case "<>":
                aux = "!=";
                break;
            case ">=":
                aux = ">=";
                break;
            case "<=":
                aux = "<=";
                break;
            case ">":
                aux = ">";
                break;
            case "<":
                aux = "<";
                break;
            default:
                break;
        }
        saida.append(" " + aux + " ");
        return null;
    }
    
}
