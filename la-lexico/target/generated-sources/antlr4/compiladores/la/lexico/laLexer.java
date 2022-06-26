// Generated from compiladores\la\lexico\laLexer.g4 by ANTLR 4.7.2
package compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class laLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO=1, TABULACAO=2, PALAVRAS_CHAVE=3, IDENT=4, CADEIA=5, CADEIA_ERRADA=6, 
		SIMBOLO_NAO_IDENTIFICADO=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMENTARIO", "TABULACAO", "PALAVRAS_CHAVE", "IDENT", "CADEIA", "CADEIA_ERRADA", 
			"SIMBOLO_NAO_IDENTIFICADO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO", "TABULACAO", "PALAVRAS_CHAVE", "IDENT", "CADEIA", 
			"CADEIA_ERRADA", "SIMBOLO_NAO_IDENTIFICADO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public laLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "laLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u012f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0115\n\4\3\5\3\5\7"+
		"\5\u0119\n\5\f\5\16\5\u011c\13\5\3\6\3\6\7\6\u0120\n\6\f\6\16\6\u0123"+
		"\13\6\3\6\3\6\3\7\3\7\7\7\u0129\n\7\f\7\16\7\u012c\13\7\3\b\3\b\2\2\t"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\b\5\2\f\f\17\17\177\177\5\2\13\f\17"+
		"\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f$$\b\2##&\'==AB\177\u0080\u00aa"+
		"\u00aa\2\u0155\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\34\3\2\2\2\7\u0114\3\2"+
		"\2\2\t\u0116\3\2\2\2\13\u011d\3\2\2\2\r\u0126\3\2\2\2\17\u012d\3\2\2\2"+
		"\21\25\7}\2\2\22\24\n\2\2\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2"+
		"\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\177\2\2\31\32\3\2\2"+
		"\2\32\33\b\2\2\2\33\4\3\2\2\2\34\35\t\3\2\2\35\36\3\2\2\2\36\37\b\3\2"+
		"\2\37\6\3\2\2\2 !\7c\2\2!\"\7n\2\2\"#\7i\2\2#$\7q\2\2$%\7t\2\2%&\7k\2"+
		"\2&\'\7v\2\2\'(\7o\2\2(\u0115\7q\2\2)*\7h\2\2*+\7k\2\2+,\7o\2\2,-\7a\2"+
		"\2-.\7c\2\2./\7n\2\2/\60\7i\2\2\60\61\7q\2\2\61\62\7t\2\2\62\63\7k\2\2"+
		"\63\64\7v\2\2\64\65\7o\2\2\65\u0115\7q\2\2\66\67\7f\2\2\678\7g\2\289\7"+
		"e\2\29:\7n\2\2:;\7c\2\2;<\7t\2\2<\u0115\7g\2\2=>\7e\2\2>?\7q\2\2?@\7p"+
		"\2\2@A\7u\2\2AB\7v\2\2BC\7c\2\2CD\7p\2\2DE\7v\2\2E\u0115\7g\2\2FG\7v\2"+
		"\2GH\7k\2\2HI\7r\2\2I\u0115\7q\2\2JK\7n\2\2KL\7k\2\2LM\7v\2\2MN\7g\2\2"+
		"NO\7t\2\2OP\7c\2\2P\u0115\7n\2\2QR\7k\2\2RS\7p\2\2ST\7v\2\2TU\7g\2\2U"+
		"V\7k\2\2VW\7t\2\2W\u0115\7q\2\2XY\7t\2\2YZ\7g\2\2Z[\7c\2\2[\u0115\7n\2"+
		"\2\\]\7n\2\2]^\7q\2\2^_\7i\2\2_`\7k\2\2`a\7e\2\2a\u0115\7q\2\2bc\7x\2"+
		"\2cd\7g\2\2de\7t\2\2ef\7f\2\2fg\7c\2\2gh\7f\2\2hi\7g\2\2ij\7k\2\2jk\7"+
		"t\2\2k\u0115\7q\2\2lm\7h\2\2mn\7c\2\2no\7n\2\2op\7u\2\2p\u0115\7q\2\2"+
		"qr\7t\2\2rs\7g\2\2st\7i\2\2tu\7k\2\2uv\7u\2\2vw\7v\2\2wx\7t\2\2x\u0115"+
		"\7q\2\2yz\7h\2\2z{\7k\2\2{|\7o\2\2|}\7a\2\2}~\7t\2\2~\177\7g\2\2\177\u0080"+
		"\7i\2\2\u0080\u0081\7k\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0115\7q\2\2\u0085\u0086\7r\2\2\u0086\u0087\7t\2\2"+
		"\u0087\u0088\7q\2\2\u0088\u0089\7e\2\2\u0089\u008a\7g\2\2\u008a\u008b"+
		"\7f\2\2\u008b\u008c\7k\2\2\u008c\u008d\7o\2\2\u008d\u008e\7g\2\2\u008e"+
		"\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\u0115\7q\2\2\u0091\u0092\7h\2\2"+
		"\u0092\u0093\7k\2\2\u0093\u0094\7o\2\2\u0094\u0095\7a\2\2\u0095\u0096"+
		"\7r\2\2\u0096\u0097\7t\2\2\u0097\u0098\7q\2\2\u0098\u0099\7e\2\2\u0099"+
		"\u009a\7g\2\2\u009a\u009b\7f\2\2\u009b\u009c\7k\2\2\u009c\u009d\7o\2\2"+
		"\u009d\u009e\7g\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0\u0115"+
		"\7q\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7e\2\2\u00a5\u00a6\7c\2\2\u00a6\u0115\7q\2\2\u00a7\u00a8\7h\2\2"+
		"\u00a8\u00a9\7k\2\2\u00a9\u00aa\7o\2\2\u00aa\u00ab\7a\2\2\u00ab\u00ac"+
		"\7h\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7e\2\2\u00af"+
		"\u00b0\7c\2\2\u00b0\u0115\7q\2\2\u00b1\u00b2\7x\2\2\u00b2\u00b3\7c\2\2"+
		"\u00b3\u0115\7t\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u0115\7c\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7u\2\2\u00ba"+
		"\u00bb\7e\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7x\2\2"+
		"\u00be\u0115\7c\2\2\u00bf\u00c0\7u\2\2\u00c0\u0115\7g\2\2\u00c1\u00c2"+
		"\7g\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7c\2\2\u00c5"+
		"\u0115\7q\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7p\2\2"+
		"\u00c9\u00ca\7c\2\2\u00ca\u0115\7q\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd"+
		"\7k\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf\7a\2\2\u00cf\u00d0\7u\2\2\u00d0"+
		"\u0115\7g\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7u\2\2"+
		"\u00d4\u0115\7q\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7l\2\2\u00d8\u0115\7c\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7k\2\2\u00db"+
		"\u00dc\7o\2\2\u00dc\u00dd\7a\2\2\u00dd\u00de\7e\2\2\u00de\u00df\7c\2\2"+
		"\u00df\u00e0\7u\2\2\u00e0\u0115\7q\2\2\u00e1\u00e2\7r\2\2\u00e2\u00e3"+
		"\7c\2\2\u00e3\u00e4\7t\2\2\u00e4\u0115\7c\2\2\u00e5\u00e6\7c\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7\u0115\7g\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7c\2\2"+
		"\u00ea\u00eb\7e\2\2\u00eb\u0115\7c\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee"+
		"\7k\2\2\u00ee\u00ef\7o\2\2\u00ef\u00f0\7a\2\2\u00f0\u00f1\7r\2\2\u00f1"+
		"\u00f2\7c\2\2\u00f2\u00f3\7t\2\2\u00f3\u0115\7c\2\2\u00f4\u00f5\7g\2\2"+
		"\u00f5\u00f6\7p\2\2\u00f6\u00f7\7s\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9"+
		"\7c\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7v\2\2\u00fb\u0115\7q\2\2\u00fc"+
		"\u00fd\7h\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7o\2\2\u00ff\u0100\7a\2\2"+
		"\u0100\u0101\7g\2\2\u0101\u0102\7p\2\2\u0102\u0103\7s\2\2\u0103\u0104"+
		"\7w\2\2\u0104\u0105\7c\2\2\u0105\u0106\7p\2\2\u0106\u0107\7v\2\2\u0107"+
		"\u0115\7q\2\2\u0108\u0109\7t\2\2\u0109\u010a\7g\2\2\u010a\u010b\7v\2\2"+
		"\u010b\u010c\7q\2\2\u010c\u010d\7t\2\2\u010d\u010e\7p\2\2\u010e\u0115"+
		"\7g\2\2\u010f\u0110\7p\2\2\u0110\u0111\7c\2\2\u0111\u0115\7q\2\2\u0112"+
		"\u0113\7>\2\2\u0113\u0115\7/\2\2\u0114 \3\2\2\2\u0114)\3\2\2\2\u0114\66"+
		"\3\2\2\2\u0114=\3\2\2\2\u0114F\3\2\2\2\u0114J\3\2\2\2\u0114Q\3\2\2\2\u0114"+
		"X\3\2\2\2\u0114\\\3\2\2\2\u0114b\3\2\2\2\u0114l\3\2\2\2\u0114q\3\2\2\2"+
		"\u0114y\3\2\2\2\u0114\u0085\3\2\2\2\u0114\u0091\3\2\2\2\u0114\u00a1\3"+
		"\2\2\2\u0114\u00a7\3\2\2\2\u0114\u00b1\3\2\2\2\u0114\u00b4\3\2\2\2\u0114"+
		"\u00b8\3\2\2\2\u0114\u00bf\3\2\2\2\u0114\u00c1\3\2\2\2\u0114\u00c6\3\2"+
		"\2\2\u0114\u00cb\3\2\2\2\u0114\u00d1\3\2\2\2\u0114\u00d5\3\2\2\2\u0114"+
		"\u00d9\3\2\2\2\u0114\u00e1\3\2\2\2\u0114\u00e5\3\2\2\2\u0114\u00e8\3\2"+
		"\2\2\u0114\u00ec\3\2\2\2\u0114\u00f4\3\2\2\2\u0114\u00fc\3\2\2\2\u0114"+
		"\u0108\3\2\2\2\u0114\u010f\3\2\2\2\u0114\u0112\3\2\2\2\u0115\b\3\2\2\2"+
		"\u0116\u011a\t\4\2\2\u0117\u0119\t\5\2\2\u0118\u0117\3\2\2\2\u0119\u011c"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\n\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u0121\7$\2\2\u011e\u0120\n\6\2\2\u011f\u011e\3\2"+
		"\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7$\2\2\u0125\f\3\2\2\2"+
		"\u0126\u012a\7$\2\2\u0127\u0129\n\6\2\2\u0128\u0127\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\16\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u012e\t\7\2\2\u012e\20\3\2\2\2\b\2\25\u0114\u011a"+
		"\u0121\u012a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}