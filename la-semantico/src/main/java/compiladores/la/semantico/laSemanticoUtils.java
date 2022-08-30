
package compiladores.la.semantico;

import compiladores.la.semantico.TabelaDeSimbolos.TipoLA;
import static compiladores.la.semantico.laSemantico.escoposAninhados;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class laSemanticoUtils {
    
    public static List<String> errosSemanticos = new ArrayList<>();
   
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        //int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    public static TabelaDeSimbolos.TipoLA verificaTipoVar(String tipo, HashMap registros) {
         
      if (registros.containsKey(tipo)) {
         return TabelaDeSimbolos.TipoLA.REGISTRO;
     }
        
     switch (tipo) {
         case "literal":
         case "^literal":
             return TabelaDeSimbolos.TipoLA.LITERAL;
         case "inteiro":
         case "^inteiro":
             return TabelaDeSimbolos.TipoLA.INTEIRO;
         case "real":
         case "^real":
             return TabelaDeSimbolos.TipoLA.REAL;
         case "logico":
         case "^logico":
             return TabelaDeSimbolos.TipoLA.LOGICO;
         case "registro":
             return TabelaDeSimbolos.TipoLA.REGISTRO;
         default:
             return TabelaDeSimbolos.TipoLA.INVALIDO;
     }
     
    }
    
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.ExpressaoContext ctx) {
        
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var termoLogico: ctx.termo_logico()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, termoLogico);
            if(ret == null){
                ret = aux;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                
                if(ctx.op_logico_1() != null){
                    System.out.println("TEM OPERADOR LOGICO ENTRE OS NUMEROS"); // so para evitar o erro de tipo incompatível 
                }
                else{
                    adicionarErroSemantico(ctx.start, "Expressão" + ctx.getText() + " contém tipos incompatíveis");
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        }
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Termo_logicoContext termoLogico) {
        
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var fatorLogico: termoLogico.fator_logico()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fatorLogico);
            if(ret == null){
                ret = aux;
            }
            else if(termoLogico.op_logico_2()!=null){
                ret = TabelaDeSimbolos.TipoLA.LOGICO;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Fator_logicoContext fatorLogico) {
        return verificarTipo(tabela, fatorLogico.parcela_logica());
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_logicaContext parcelaLogica) {
 
        if (parcelaLogica.exp_relacional() != null) {
            return verificarTipo(tabela, parcelaLogica.exp_relacional());
        } else {
            return TabelaDeSimbolos.TipoLA.LOGICO;
        }
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Exp_relacionalContext exp_relacional) {
        
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var expressaoAritimetica: exp_relacional.exp_aritmetica()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, expressaoAritimetica);
            if(ret == null){
                ret = aux;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Exp_aritmeticaContext ctx){
        TabelaDeSimbolos.TipoLA ret = null;
        
        for (laParser.TermoContext termo : ctx.termo()) {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, termo);
            if (ret == null) {
                ret = aux;
            } else if ((aux != TabelaDeSimbolos.TipoLA.INVALIDO)&&(ret != aux)) {
                if ((aux == TabelaDeSimbolos.TipoLA.REAL) || (aux == TabelaDeSimbolos.TipoLA.INTEIRO)) {
                    ret = TabelaDeSimbolos.TipoLA.REAL; // se os tipos forem diferentes retorna real
                } else {
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO; //entra aqui se a comparacao for com outro tipo
                }
            }
        }
        return ret;
}
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.TermoContext termo) {
        
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var fator: termo.fator()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fator);
            if(ret == null){
                ret = aux;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){                 
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;                                                                                                             
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.FatorContext fator) {
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var parcela: fator.parcela()){
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, parcela);
            if(ret == null) {
                ret = aux;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.ParcelaContext parcela) {
        TabelaDeSimbolos.TipoLA ret = null;
        
        if (parcela.parcela_unario() != null) {
            return verificarTipo(tabela, parcela.parcela_unario());
        } else if (parcela.parcela_nao_unario() != null) {
            return verificarTipo(tabela, parcela.parcela_nao_unario());
        }
        return ret;

    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_unarioContext parcelaUnario) {   
        
        TabelaDeSimbolos.TipoLA ret = null;
        // identificador
        if (parcelaUnario.identificador() != null) {
            String nomeVar;
            if (parcelaUnario.identificador().dimensao().exp_aritmetica().size() > 0) {
                nomeVar = parcelaUnario.identificador().primeiroIdent.getText();
            } else {
                nomeVar = parcelaUnario.identificador().getText();
            }
            if (tabela.existe(nomeVar)) {
                ret = tabela.verificar(nomeVar);
            } else { //verifica no escopo global (laSemantico.escoposAninhados.percorrerEscoposAninhados().size()-1)
                TabelaDeSimbolos tabelaEscopoGlobal = laSemantico.escoposAninhados.percorrerEscoposAninhados().get(laSemantico.escoposAninhados.percorrerEscoposAninhados().size()-1);
                if (tabelaEscopoGlobal.existe(nomeVar)) {
                    ret = tabelaEscopoGlobal.verificar(nomeVar);
                } else { //se chega aqui nao foi declarada
                    adicionarErroSemantico(parcelaUnario.identificador().getStart(), "identificador " + parcelaUnario.identificador().getText() + " nao declarado");
                    ret = TabelaDeSimbolos.TipoLA.INVALIDO;
                }
            }
        }
        // IDENT
        else if (parcelaUnario.IDENT() != null) {
            if (laSemantico.hashFuncsProcs.containsKey(parcelaUnario.IDENT().getText())) {
                List<TabelaDeSimbolos.TipoLA> aux = laSemantico.hashFuncsProcs.get(parcelaUnario.IDENT().getText());
                if (aux.size()-1 == parcelaUnario.expressao().size()) {
                    for (int i = 0; i < parcelaUnario.expressao().size(); i++) {
                        if (aux.get(i) != verificarTipo(tabela, parcelaUnario.expressao().get(i))) {
                            adicionarErroSemantico(parcelaUnario.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + parcelaUnario.IDENT().getText());
                        }
                    }
                    ret = aux.get(aux.size()-1);
                } else {
                    adicionarErroSemantico(parcelaUnario.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + parcelaUnario.IDENT().getText());
                }
            } else { //nao deve chegar aqui
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        // tipos básicos
        else if (parcelaUnario.NUM_INT() != null) {
            ret = TabelaDeSimbolos.TipoLA.INTEIRO;
        }
        else if (parcelaUnario.NUM_REAL() != null) {
            ret = TabelaDeSimbolos.TipoLA.REAL;
        // ()
        } else {
            ret = verificarTipo(tabela, parcelaUnario.expressao(0));
        }
        return ret;
       
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.Parcela_nao_unarioContext parcelaNaoUnario) {
     
        //parcela_nao_unario: '&' identificador | CADEIA;
        
        if (parcelaNaoUnario.CADEIA() != null){
            return TabelaDeSimbolos.TipoLA.LITERAL;
        }
        else{
            var identificador= parcelaNaoUnario.identificador();
            // Verifica pre-existencia
            if(tabela.existe(identificador.getText()) == false){
                adicionarErroSemantico(identificador.start, "identificador " + identificador.getText()  + " nao declarado");
                return TabelaDeSimbolos.TipoLA.INVALIDO;
            }
            else{
                TabelaDeSimbolos.TipoLA tipoIdentificador = tabela.verificar(identificador.getText());
                return tipoIdentificador;
            }
        }
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        if (tabela.existe(nomeVar)) {
            return tabela.verificar(nomeVar);
        } else {
            return TabelaDeSimbolos.TipoLA.INVALIDO;
        }
    }
    
       
    public static void adicionaVarTabela(String nome, String strTipo, Token tokenNome, Token tokenTipo, HashMap registros) {
        
        TabelaDeSimbolos tabelaEscopoGlobal = escoposAninhados.percorrerEscoposAninhados().get(escoposAninhados.percorrerEscoposAninhados().size()-1);//ultimo item = escopo global
        TabelaDeSimbolos tabela = escoposAninhados.obterEscopoAtual();
        TipoLA tipo = laSemanticoUtils.verificaTipoVar(strTipo,registros);
        
        if (tipo == TipoLA.INVALIDO) {
            laSemanticoUtils.adicionarErroSemantico(tokenTipo, "tipo " + strTipo + " nao declarado");
        }
        if ( !tabela.existe(nome) ) {
            if (!tabelaEscopoGlobal.existe(nome)) { // verifica se existe no escopo mais acima(global)
                tabela.adicionar(nome, tipo);
            } else {
                laSemanticoUtils.adicionarErroSemantico(tokenNome, "identificador " + nome + " ja declarado anteriormente");
            }
        }
        else {
            laSemanticoUtils.adicionarErroSemantico(tokenNome, "identificador " + nome + " ja declarado anteriormente");
        }
    }
    
}

