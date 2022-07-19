
package compiladores.la.sintatico;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author porto
 */
public class laErrorListener extends BaseErrorListener {
    
    FileOutputStream saida;
    int auxCont = 0; //contador auxiliar para limitar o numero de erros printados
    
    public laErrorListener(FileOutputStream saida){
        this.saida=saida;
    }
    
    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
       
        Token t = (Token) offendingSymbol; //token que gerou erro
        String tokenErrado = t.getText();
        
        // Tratar token errado <EOF>
        if ("<EOF>".equals(tokenErrado)){
            tokenErrado = "EOF";
        }
        
        while (auxCont < 1){ //número máximo de erros sintáticos permitidos = 1
            try {
                saida.write(("Linha "+line+": erro sintatico proximo a "+tokenErrado+"\n").getBytes());
                auxCont = auxCont + 1;
            } catch (IOException ex) {
                Logger.getLogger(laErrorListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
