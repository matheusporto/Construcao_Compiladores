
package compiladores.la.semantico;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class laSemanticoUtils {
    
    public static List<String> errosSemanticos = new ArrayList<>();
   
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        //int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    public static TabelaDeSimbolos.TipoLA verificaTipoVar(TabelaDeSimbolos tabela, String tipoVar){
         
        TabelaDeSimbolos.TipoLA tipoVarLa;
        
        switch(tipoVar) {               
            case "literal":
                tipoVarLa = TabelaDeSimbolos.TipoLA.LITERAL;
                break;
            case "inteiro":
                tipoVarLa = TabelaDeSimbolos.TipoLA.INTEIRO;
                break;
            case "real":
                tipoVarLa = TabelaDeSimbolos.TipoLA.REAL;
                break;
            case "logico":
                tipoVarLa = TabelaDeSimbolos.TipoLA.LOGICO;
                break;
            default:
                tipoVarLa = TabelaDeSimbolos.TipoLA.INVALIDO;
                break;
                               
            }
        return tipoVarLa;
    }
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.ExpressaoContext ctx) {
        
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var termoLogico: ctx.termo_logico())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, termoLogico);
            if(ret == null)
            {
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
        
        for(var fatorLogico: termoLogico.fator_logico())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fatorLogico);
            if(ret == null)
            {
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
        
        for(var expressaoAritimetica: exp_relacional.exp_aritmetica())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, expressaoAritimetica);
            if(ret == null)
            {
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
        
        for(var termo: ctx.termo())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, termo);
            if(ret == null)
            {
                ret = aux;
            }
            else if (ret != aux && aux != TabelaDeSimbolos.TipoLA.INVALIDO){
                ret = TabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        
        return ret;
}
    
    public static TabelaDeSimbolos.TipoLA verificarTipo(TabelaDeSimbolos tabela, laParser.TermoContext termo) {
        TabelaDeSimbolos.TipoLA ret = null;
        
        for(var fator: termo.fator())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fator);
            if(ret == null)
            {
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
        
        for(var parcela: fator.parcela())
        {
            TabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, parcela);
            if(ret == null)
            {
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
        // Verifica tipos básicos e IDENT
        if (parcelaUnario.NUM_REAL() != null){
            return TabelaDeSimbolos.TipoLA.REAL;
        }
        else if (parcelaUnario.NUM_INT() != null){
            return TabelaDeSimbolos.TipoLA.INTEIRO;
        }
        else if (parcelaUnario.IDENT() != null){
            return tabela.verificar(parcelaUnario.IDENT().getText());
        }
        // Verifica identificadores e expressoes
        else if (parcelaUnario.identificador() != null){
        
            var identificador = parcelaUnario.identificador();
            
            if(tabela.existe(identificador.getText()) == false){
                adicionarErroSemantico(identificador.start, "identificador " + identificador.getText()  + " nao declarado");
                return TabelaDeSimbolos.TipoLA.INVALIDO;
            }
            else{
                TabelaDeSimbolos.TipoLA tipoIdentificador = tabela.verificar(identificador.getText());
                return tipoIdentificador;
            }
        }
        else if (parcelaUnario.expressao() != null){
            var expressao = parcelaUnario.expressao(0); //coloquei o zero pq se não passa uma lista, não sei se entendi o pq
            return laSemanticoUtils.verificarTipo(tabela, expressao);
        }
        
        else{
            //So para o java não reclamar que não tem return
            return TabelaDeSimbolos.TipoLA.LITERAL;
        }
       
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
    
    
}

