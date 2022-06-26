/*
 T1 - Construção de Compiladores
 Analisador Léxico - Linguagem LA
 Autor: Matheus Porto
 RA: 744348
 */
package compiladores.la.lexico;

/**
 *
 * @author porto
 */

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.FileOutputStream;

public class Principal {

    public static void main(String[] args) {
        try (FileOutputStream saida = new FileOutputStream(args[1])){
            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lex = new laLexer(cs);
            Token t = null;
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                
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
                    saida.close();
                    return;
                case "COMENTARIO_ERRADO":
                    saida.write(("Linha " + t.getLine() + ": comentario nao fechado\n").getBytes());
                    saida.close();
                    return;
                case "CADEIA_ERRADA":
                    saida.write(("Linha " + t.getLine() + ": cadeia literal nao fechada\n").getBytes());
                    saida.close();
                    return;
            }
                // Escreve o token no arquivo de saida
                saida.write(("<" + "'" + t.getText() + "'" + "," + token + ">\n").getBytes());
            }
        } catch (IOException ex) {
        }
    }
}