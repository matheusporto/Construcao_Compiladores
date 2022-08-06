/*
 T3 - Construção de Compiladores
 Analisador Semantico - Linguagem LA
 Autor: Matheus Porto
 RA: 744348
 */

package compiladores.la.semantico;

import compiladores.la.semantico.laParser.ProgramaContext;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]) throws IOException {
        
        CharStream cs = CharStreams.fromFileName(args[0]);
        FileOutputStream saida = new FileOutputStream(args[1]);
        laLexer lexer = new laLexer(cs);
        Boolean erroLexico = false; //Flag para detectar erro léxico e pular a parte da análise sintática

        // Descomentar para depurar o Léxico
        //Token t = null;
        //while( (t = lexer.nextToken()).getType() != Token.EOF) {
        //    System.out.println("<" + laLexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
        //}

        // Testar erro léxico - T1
        
        Token t = null;
            while ((t = lexer.nextToken()).getType() != Token.EOF) {
                
                // String que será impressa do lado direito do token
                String token = "'" + t.getText() + "'"; //String inicializada com o próprio lexema, 
                                                        //pois é ele que será caso o tipo não seja IDENT , CADEIA, NUM_INT ou NUM_REAL 
                
                // Testa os casos em que o tipo do token não é o próximo lexema
                switch (laLexer.VOCABULARY.getDisplayName(t.getType())) {
                case "IDENT":
                    token = laLexer.VOCABULARY.getDisplayName(t.getType());       
                    break;
                case "CADEIA":
                    token = laLexer.VOCABULARY.getDisplayName(t.getType());       
                    break;
                case "NUM_INT":
                    token = laLexer.VOCABULARY.getDisplayName(t.getType());      
                    break;
                case "NUM_REAL":
                    token = laLexer.VOCABULARY.getDisplayName(t.getType());    
                    break;
                
                // Testa os casos de erro
                case "SIMBOLO_NAO_IDENTIFICADO":
                    saida.write(("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n").getBytes());
                    erroLexico = true;
                    break;
                case "COMENTARIO_ERRADO":
                    saida.write(("Linha " + t.getLine() + ": comentario nao fechado\n").getBytes());
                    erroLexico = true;
                    break;
                case "CADEIA_ERRADA":
                    saida.write(("Linha " + t.getLine() + ": cadeia literal nao fechada\n").getBytes());
                    erroLexico = true;
                    break;
                }
            }
        
        if(erroLexico == false){
            // Apontando o ponteiro para o inicio do arquivo e iniciando outro lexer para a Análise Sintática    
            cs.seek(0);
            laLexer lexer2 = new laLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer2);
            
            // Criação do parser e de um listener para o ocorrência de erros sintáticos
            laParser parser = new laParser(tokens);
            laErrorListener lael = new laErrorListener(saida);
            
            // Remoção do listener padrão e associação do novo listener criado e implementado em laErrorListener.java
            parser.removeErrorListeners();
            parser.addErrorListener(lael);
                
            // Analisador Semantico
            ProgramaContext arvore = parser.programa();
            laSemantico las = new laSemantico();
            las.visitPrograma(arvore);
            List<String> listaErrosSemanticos = laSemanticoUtils.errosSemanticos;
                for (var erroSemantico : listaErrosSemanticos) {
                    saida.write((erroSemantico + "\n").getBytes());
                }   
        }
        
        saida.write(("Fim da compilacao\n").getBytes());
        saida.close(); 
          
    }
    
}
