
package compiladores.la.semantico;

import compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import java.util.ArrayList;
import java.util.HashMap;


public class laSemantico extends laBaseVisitor<TipoLA>{
    
    static Escopos escoposAninhados = new Escopos();
    // Listas auxiliares
    static HashMap<String, ArrayList<TipoLA>> hashFuncsProcs = new HashMap<>();
    HashMap<String, ArrayList<String>> hashRegistros = new HashMap<>();
    HashMap<String, String> hashUnarios = new HashMap<>();
    
    
  
    public String verificaDimensao(laParser.IdentificadorContext ident) {
        
        String nomeVar;
        
        if (ident.dimensao().exp_aritmetica().size() > 0) {
            nomeVar = ident.primeiroIdent.getText();
        }
        else{
            nomeVar = ident.getText();
        }
    return nomeVar;
    }
 
    
    @Override
    public TipoLA visitCorpo(laParser.CorpoContext ctx) {

        escoposAninhados.criarNovoEscopo();
        for (laParser.CmdContext cmd : ctx.cmd())
        if (cmd.cmdretorne() != null) {
            laSemanticoUtils.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
        }
    return super.visitCorpo(ctx);
    }
    
       
    @Override 
    public TipoLA visitDeclaracao_global(laParser.Declaracao_globalContext ctx) { 
        
        
        escoposAninhados.criarNovoEscopo();
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        ArrayList<TipoLA> parametros = new ArrayList<TipoLA>();

        if (ctx.abreFunc != null) {
            for (laParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // Tipo Básico
                    for (laParser.IdentificadorContext ident : parametro.identificador()) {
                        laSemanticoUtils.adicionaVarTabela(ident.getText(), parametro.tipo_estendido().getText(), ident.getStart(), parametro.tipo_estendido().getStart(), hashRegistros);
                        parametros.add(laSemanticoUtils.verificaTipoVar(parametro.tipo_estendido().getText(), hashRegistros));
                    }
                }
                else { // Registro
                    if (hashRegistros.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                        ArrayList<String> variaveis_registro = hashRegistros.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());
                        for (laParser.IdentificadorContext ident : parametro.identificador()) {
                            parametros.add(laSemanticoUtils.verificaTipoVar(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText(), hashRegistros));
                            for (int i = 0; i < variaveis_registro.size(); i = i + 2) {
                                laSemanticoUtils.adicionaVarTabela(ident.getText() + '.' + variaveis_registro.get(i), variaveis_registro.get(i+1), ident.getStart(), ident.getStart(), hashRegistros);
                            }
                        }
                    }
                    else { // Não declarado
                        laSemanticoUtils.adicionarErroSemantico(parametro.getStart(), "tipo não declarado");
                    }
                }
            }
            
            parametros.add(laSemanticoUtils.verificaTipoVar(ctx.tipo_estendido().getText(), hashRegistros));
            hashFuncsProcs.put(ctx.IDENT().getText(), parametros);

        } 
        else {
            // Procedimento
            for (laParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // Tipo Básico
                    for (laParser.IdentificadorContext ident : parametro.identificador()) {
                        laSemanticoUtils.adicionaVarTabela(ident.getText(), parametro.tipo_estendido().getText(), ident.getStart(), parametro.tipo_estendido().getStart(), hashRegistros);
                        parametros.add(laSemanticoUtils.verificaTipoVar(parametro.tipo_estendido().getText(), hashRegistros));
                    }
                }
                else { // Registro
                    if (hashRegistros.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                        ArrayList<String> variaveis_registro = hashRegistros.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());
                        for (laParser.IdentificadorContext ident : parametro.identificador()) {
                            parametros.add(laSemanticoUtils.verificaTipoVar(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText(), hashRegistros));
                            for (int i = 0; i < variaveis_registro.size(); i = i + 2) {
                                laSemanticoUtils.adicionaVarTabela(ident.getText() + '.' + variaveis_registro.get(i), variaveis_registro.get(i+1), ident.getStart(), ident.getStart(), hashRegistros);
                            }
                        }
                    }
                    else {// Não declarado
                        laSemanticoUtils.adicionarErroSemantico(parametro.getStart(), "tipo não declarado");
                    }
                }
            }
            for (laParser.CmdContext comando : ctx.cmd()) {
                if (comando.cmdretorne() != null) {
                    laSemanticoUtils.adicionarErroSemantico(comando.getStart(), "comando retorne nao permitido nesse escopo");
                }
            }
            hashFuncsProcs.put(ctx.IDENT().getText(), parametros);
        }
        
        return super.visitDeclaracao_global(ctx);
    }
     
    @Override 
    public TipoLA visitDeclaracao_local(laParser.Declaracao_localContext ctx) {
        
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        String strTipoVar = null;
        
        if (ctx.variavel() != null) {
            if (ctx.variavel().tipo().registro() != null) { // Registro
                for (laParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                    laSemanticoUtils.adicionaVarTabela(ident.getText(), "registro", ident.getStart(), null, hashRegistros);
                    for (laParser.VariavelContext vars : ctx.variavel().tipo().registro().variavel()) {
                        strTipoVar = vars.tipo().getText();
                        for (laParser.IdentificadorContext ident_reg : vars.identificador()) {
                            laSemanticoUtils.adicionaVarTabela(ident.getText() + '.' + ident_reg.getText(), strTipoVar, ident_reg.getStart(), vars.tipo().getStart(), hashRegistros);
                        }
                    }
                }
            }
            else {
                strTipoVar = ctx.variavel().tipo().getText();
                String nomeVar;
                if (hashRegistros.containsKey(strTipoVar)) {
                    ArrayList<String> variaveis_registro = hashRegistros.get(strTipoVar);
                    for (laParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        nomeVar = verificaDimensao(ident);
                        if (tabela.existe(nomeVar) || hashRegistros.containsKey(nomeVar)) {
                            laSemanticoUtils.adicionarErroSemantico(ident.getStart(), "identificador " + nomeVar + " ja declarado anteriormente");
                        } else {
                            laSemanticoUtils.adicionaVarTabela(nomeVar, "registro", ident.getStart(), ctx.variavel().tipo().getStart(), hashRegistros);
                            for (int i = 0; i < variaveis_registro.size(); i = i + 2) {
                                laSemanticoUtils.adicionaVarTabela(nomeVar + '.' + variaveis_registro.get(i), variaveis_registro.get(i+1), ident.getStart(), ctx.variavel().tipo().getStart(), hashRegistros);
                            }
                        }
                    }
                } else if (hashUnarios.containsKey(strTipoVar)) { //Tipo Unário
                    strTipoVar = hashUnarios.get(strTipoVar);
                    for (laParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        laSemanticoUtils.adicionaVarTabela(ident.getText(), strTipoVar, ident.getStart(), ctx.variavel().tipo().getStart(), hashRegistros);
                    }
                }
                else{
                    for (laParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        String nomeVar2 = verificaDimensao(ident);
                        if (hashFuncsProcs.containsKey(nomeVar2)) {
                            laSemanticoUtils.adicionarErroSemantico(ident.getStart(), "identificador " + nomeVar2 + " ja declarado anteriormente");
                        } else {
                            laSemanticoUtils.adicionaVarTabela(nomeVar2, strTipoVar, ident.getStart(), ctx.variavel().tipo().getStart(), hashRegistros);
                        }
                    }
                }
            }
        } else if (ctx.tipo_basico() != null) {
            strTipoVar = ctx.tipo_basico().getText();
            laSemanticoUtils.adicionaVarTabela(ctx.IDENT().getText(), strTipoVar, ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), hashRegistros);
        } 
        else {
            if (ctx.tipo().registro() != null) {
                ArrayList<String> variaveisRegistro = new ArrayList<String>();
                for (laParser.VariavelContext var : ctx.tipo().registro().variavel()) {
                    strTipoVar = var.tipo().getText();
                    for (laParser.IdentificadorContext ident_registro : var.identificador()) {
                        variaveisRegistro.add(ident_registro.getText());
                        variaveisRegistro.add(var.tipo().getText());
                    }
                }
                hashRegistros.put(ctx.IDENT().getText(), variaveisRegistro);
            }         
            else {
                strTipoVar = ctx.tipo().getText();
                hashUnarios.put(ctx.IDENT().getText(), strTipoVar);
            }
        }   
        
    return super.visitDeclaracao_local(ctx);
    }
          
     
    @Override 
    public TipoLA visitCmdleia(laParser.CmdleiaContext ctx) {
        //cmdleia: 'leia' '(' ('^')? identificador (',' ('^')? identificador)* ')';
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao;
        String nomeVar;
        
        for (laParser.IdentificadorContext ident : ctx.identificador()) {
            nomeVar = verificaDimensao(ident);
            if (!tabela.existe(nomeVar)) {
                laSemanticoUtils.adicionarErroSemantico(ident.getStart(), "identificador " + ident.getText() + " nao declarado");
            }
        }

    return super.visitCmdleia(ctx);
    }
    
    @Override 
    public TipoLA visitCmdescreva(laParser.CmdescrevaContext ctx) {
        //cmdescreva: 'escreva' '(' expressao (',' expressao)* ')';
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao;

        for (laParser.ExpressaoContext expressao : ctx.expressao()) {
            tipoExpressao = laSemanticoUtils.verificarTipo(tabela, expressao);
        }
        
    return super.visitCmdescreva(ctx);
    }
    
    
    @Override 
    public TipoLA visitCmdatribuicao(laParser.CmdatribuicaoContext ctx) {
        //cmdatribuicao: ('^')? identificador '<-' expressao;
        
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, ctx.expressao());
        String varAtribuicao = verificaDimensao(ctx.identificador());


        if (tipoExpressao != TipoLA.INVALIDO) {
            if (!tabela.existe(varAtribuicao)) { // Verifica pre existencia
                laSemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            } else { // pega o tipo
                  TipoLA tipoVarAtribuicao = laSemanticoUtils.verificarTipo(tabela, varAtribuicao);
                if (tipoVarAtribuicao != tipoExpressao) {
                    if ( !(((tipoVarAtribuicao == TipoLA.REAL) || (tipoVarAtribuicao == TipoLA.INTEIRO)) & ((tipoExpressao == TipoLA.INTEIRO) || (tipoExpressao == TipoLA.REAL))) ) {
                        if (ctx.ponteiro != null) { //ponteiro
                            laSemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + ctx.identificador().getText());
                        } else {
                            laSemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                }
            }
        }
        else {
            laSemanticoUtils.adicionarErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
        }
        
    return super.visitCmdatribuicao(ctx);
    }
    
    @Override 
    public TipoLA visitCmdenquanto(laParser.CmdenquantoContext ctx) { 
        //cmdenquanto: 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto';
        //basta verificar a expressao pq o identificador não precisa pre existir
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, ctx.expressao());
        
    return super.visitCmdenquanto(ctx); 
    }
    
     @Override 
     public TipoLA visitCmdpara(laParser.CmdparaContext ctx) {
       TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
       //cmdpara: 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para';
       // So testa pre existencia, verificaTipo se encarrega das outras verificacoes
        if (!tabela.existe(ctx.IDENT().getText())) {
            laSemanticoUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(), "identificador " + ctx.IDENT().getText() + " nao declarado");
        }
        ctx.exp_aritmetica().forEach(expr_arit -> laSemanticoUtils.verificarTipo(tabela, expr_arit));
        ctx.cmd().forEach(cmd -> visitCmd(cmd));
        
    return super.visitCmdpara(ctx); 
    }
     
    @Override
    public TipoLA visitCmdse(laParser.CmdseContext ctx) {
        //cmdse: 'se' expressao 'entao' (cmd)* ('senao' (cmd)*)? 'fim_se';
        //verificaTipo se encarrega das verificacoes
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, ctx.expressao());

    return super.visitCmdse(ctx); 
    }
     
    @Override 
    public TipoLA visitCmdcaso(laParser.CmdcasoContext ctx) {
        //cmdcaso: 'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso';
        //verificaTipo se encarrega das verificacoes
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipoExpressao = laSemanticoUtils.verificarTipo(tabela, ctx.exp_aritmetica());

        ctx.cmd().forEach(cmd -> visitCmd(cmd));

    return super.visitCmdcaso(ctx); 
    }
     
}
