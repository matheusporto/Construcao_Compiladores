// Generated from compiladores\la\sintatico\la.g4 by ANTLR 4.7.2
package compiladores.la.sintatico;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link laParser}.
 */
public interface laListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link laParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(laParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(laParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(laParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(laParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(laParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(laParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(laParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(laParser.TermoContext ctx);
}