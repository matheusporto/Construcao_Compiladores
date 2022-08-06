
package compiladores.la.semantico;

import compiladores.la.semantico.TabelaDeSimbolos.TipoLA;

public class laSemantico extends laBaseVisitor<TipoLA>{
    public TabelaDeSimbolos tabela;
  
    @Override
    public TipoLA visitPrograma(laParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }
       
    @Override 
    public TipoLA visitDeclaracao_global(laParser.Declaracao_globalContext ctx) { 
        // por enquanto mantém o comportamento padrao: visita o filho  
        return super.visitDeclaracao_global(ctx);
    }
     
    @Override 
    public TipoLA visitDeclaracao_local(laParser.Declaracao_localContext ctx) {
    // por enquanto mantém o comportamento padrao: visita o filho
        return super.visitDeclaracao_local(ctx);
    
    }
     
    @Override
    public TipoLA visitVariavel(laParser.VariavelContext ctx) {

        // por enquanto ignora as possibilidades da variavel ser registro ou ponteiro
        //como a arvore ja ta montada, da pra ir ate o tipo_basico_ident
        String tipoVar = ctx.tipo().tipo_estendido().tipo_basico_ident().getText();
        
        ctx.identificador().forEach((identificador) -> { 
            String nomeVar = identificador.getText();
            
            //Verificacao de tipo
            TipoLA tipoVarLa = laSemanticoUtils.verificaTipoVar(tabela, tipoVar); 
            
            if(tipoVarLa == TabelaDeSimbolos.TipoLA.INVALIDO){
                laSemanticoUtils.adicionarErroSemantico(identificador.getStart(), "tipo " + tipoVar  + " nao declarado");
            }
            
            //Verifica pre existencia da variavel declarada 
            if(tabela.existe(nomeVar) == true){
                laSemanticoUtils.adicionarErroSemantico(identificador.getStart(), "identificador " + nomeVar  + " ja declarado anteriormente");
            }
            
            else
                tabela.adicionar(nomeVar, tipoVarLa);
        });
         
        return super.visitVariavel(ctx);  
    }
     
     
    @Override 
    public TipoLA visitCmdleia(laParser.CmdleiaContext ctx) {
        //cmdleia: 'leia' '(' (pont='^')? identificador (',' (pont='^')? identificador)* ')';
        // para cada identificador roda o existe()
        ctx.identificador().forEach((identificador) -> {
            String nomeVar = identificador.getText();
            if ((tabela.existe(nomeVar)) == false) {
                laSemanticoUtils.adicionarErroSemantico(identificador.start, "identificador " + identificador.getText()  + " nao declarado");
            }
        });
        
        return super.visitCmdleia(ctx);
    }
    
    @Override 
    public TipoLA visitCmdescreva(laParser.CmdescrevaContext ctx) {
        //cmdescreva: 'escreva' '(' expressao (',' expressao)* ')';
        // erro no ct1 - CORRIGIDO(depois que mudei a ordem das verificacoes no visitVariavel)
        ctx.expressao().forEach((expressao) -> {
            laSemanticoUtils.verificarTipo(tabela, expressao);
        });
        return super.visitCmdescreva(ctx);
    }
    
    
    @Override 
    public TipoLA visitCmdatribuicao(laParser.CmdatribuicaoContext ctx) {
        //cmdatribuicao: (pont='^')? identificador '<-' expressao;
        
        var identificador = ctx.identificador();
        var expressao = ctx.expressao();
        
        //Verifica se o identificador pre existe
        if(tabela.existe(identificador.getText())==false){
            laSemanticoUtils.adicionarErroSemantico(identificador.start, "identificador " + identificador.getText()+ " nao declarado" );
            return super.visitCmdatribuicao(ctx);// ja para aqui mesmo
        }
        
        //Verifica consistencia dos tipos
        TipoLA tipoIdentificador=tabela.verificar(identificador.getText());
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, expressao);
        
        // ct9 - atribuir expressao inteiro a identificador que armazena real
        if(tipoExpressao==TabelaDeSimbolos.TipoLA.INTEIRO){
            if(tipoIdentificador==TabelaDeSimbolos.TipoLA.REAL){
                tipoExpressao=tipoIdentificador;
            }
        }
        
        if(tipoIdentificador!=tipoExpressao || tipoExpressao==TabelaDeSimbolos.TipoLA.INVALIDO  ){
            laSemanticoUtils.adicionarErroSemantico(identificador.start, "atribuicao nao compativel para " + identificador.getText());  
        }
        
        return super.visitCmdatribuicao(ctx);
    }
    
    @Override 
    public TipoLA visitCmdenquanto(laParser.CmdenquantoContext ctx) { 
        //cmdenquanto: 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto';
        //basta verificar a expressao pq o identificador não precisa pre existir
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdenquanto(ctx); 
    }
    
     
}
