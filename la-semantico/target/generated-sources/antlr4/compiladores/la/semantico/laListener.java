// Generated from compiladores\la\semantico\la.g4 by ANTLR 4.7.2
package compiladores.la.semantico;
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
	 * Enter a parse tree produced by {@link laParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(laParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(laParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(laParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(laParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(laParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(laParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(laParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(laParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(laParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(laParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(laParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(laParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(laParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(laParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(laParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(laParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(laParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(laParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(laParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(laParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(laParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(laParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(laParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(laParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(laParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(laParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(laParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(laParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(laParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(laParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(laParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(laParser.CorpoContext ctx);
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
	 * Enter a parse tree produced by {@link laParser#cmdleia}.
	 * @param ctx the parse tree
	 */
	void enterCmdleia(laParser.CmdleiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdleia}.
	 * @param ctx the parse tree
	 */
	void exitCmdleia(laParser.CmdleiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdescreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdescreva(laParser.CmdescrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdescreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdescreva(laParser.CmdescrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdse}.
	 * @param ctx the parse tree
	 */
	void enterCmdse(laParser.CmdseContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdse}.
	 * @param ctx the parse tree
	 */
	void exitCmdse(laParser.CmdseContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdcaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdcaso(laParser.CmdcasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdcaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdcaso(laParser.CmdcasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void enterCmdpara(laParser.CmdparaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void exitCmdpara(laParser.CmdparaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(laParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(laParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdfaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdfaca(laParser.CmdfacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdfaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdfaca(laParser.CmdfacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdatribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdatribuicao(laParser.CmdatribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdatribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdatribuicao(laParser.CmdatribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdchamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdchamada(laParser.CmdchamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdchamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdchamada(laParser.CmdchamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#cmdretorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdretorne(laParser.CmdretorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#cmdretorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdretorne(laParser.CmdretorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(laParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(laParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(laParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(laParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(laParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(laParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(laParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(laParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(laParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(laParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(laParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(laParser.Exp_aritmeticaContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link laParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(laParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(laParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(laParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(laParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(laParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(laParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(laParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(laParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(laParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(laParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(laParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(laParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(laParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(laParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(laParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(laParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(laParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(laParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(laParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(laParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(laParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(laParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(laParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(laParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(laParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(laParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link laParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(laParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link laParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(laParser.Op_logico_2Context ctx);
}