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
		COMENTARIO=1, COMENTARIO_ERRADO=2, TABULACAO=3, PALAVRAS_CHAVE=4, NUM_INT=5, 
		NUM_REAL=6, SIMBOLOS_E_OPERADORES=7, IDENT=8, CADEIA=9, CADEIA_ERRADA=10, 
		SIMBOLO_NAO_IDENTIFICADO=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMENTARIO", "COMENTARIO_ERRADO", "TABULACAO", "PALAVRAS_CHAVE", "NUM_INT", 
			"NUM_REAL", "SIMBOLOS_E_OPERADORES", "IDENT", "CADEIA", "CADEIA_ERRADA", 
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
			null, "COMENTARIO", "COMENTARIO_ERRADO", "TABULACAO", "PALAVRAS_CHAVE", 
			"NUM_INT", "NUM_REAL", "SIMBOLOS_E_OPERADORES", "IDENT", "CADEIA", "CADEIA_ERRADA", 
			"SIMBOLO_NAO_IDENTIFICADO"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u0161\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0126\n\5\3\6\6"+
		"\6\u0129\n\6\r\6\16\6\u012a\3\7\6\7\u012e\n\7\r\7\16\7\u012f\3\7\3\7\6"+
		"\7\u0134\n\7\r\7\16\7\u0135\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u0145\n\b\3\t\3\t\7\t\u0149\n\t\f\t\16\t\u014c\13\t\3\n"+
		"\3\n\7\n\u0150\n\n\f\n\16\n\u0153\13\n\3\n\3\n\3\13\3\13\7\13\u0159\n"+
		"\13\f\13\16\13\u015c\13\13\3\13\3\13\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\n\5\2\f\f\17\17\177\177\5\2\13\f"+
		"\17\17\"\"\7\2\'\',-//\61\61gg\t\2((*+..<<>@]]_`\5\2C\\aac|\6\2\62;C\\"+
		"aac|\4\2\f\f$$\b\2##&\'==AB\177\u0080\u00aa\u00aa\2\u0192\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2"+
		"\5$\3\2\2\2\7-\3\2\2\2\t\u0125\3\2\2\2\13\u0128\3\2\2\2\r\u012d\3\2\2"+
		"\2\17\u0144\3\2\2\2\21\u0146\3\2\2\2\23\u014d\3\2\2\2\25\u0156\3\2\2\2"+
		"\27\u015f\3\2\2\2\31\35\7}\2\2\32\34\n\2\2\2\33\32\3\2\2\2\34\37\3\2\2"+
		"\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\177\2\2!"+
		"\"\3\2\2\2\"#\b\2\2\2#\4\3\2\2\2$(\7}\2\2%\'\n\2\2\2&%\3\2\2\2\'*\3\2"+
		"\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\f\2\2,\6\3\2\2\2-.\t"+
		"\3\2\2./\3\2\2\2/\60\b\4\2\2\60\b\3\2\2\2\61\62\7c\2\2\62\63\7n\2\2\63"+
		"\64\7i\2\2\64\65\7q\2\2\65\66\7t\2\2\66\67\7k\2\2\678\7v\2\289\7o\2\2"+
		"9\u0126\7q\2\2:;\7h\2\2;<\7k\2\2<=\7o\2\2=>\7a\2\2>?\7c\2\2?@\7n\2\2@"+
		"A\7i\2\2AB\7q\2\2BC\7t\2\2CD\7k\2\2DE\7v\2\2EF\7o\2\2F\u0126\7q\2\2GH"+
		"\7f\2\2HI\7g\2\2IJ\7e\2\2JK\7n\2\2KL\7c\2\2LM\7t\2\2M\u0126\7g\2\2NO\7"+
		"e\2\2OP\7q\2\2PQ\7p\2\2QR\7u\2\2RS\7v\2\2ST\7c\2\2TU\7p\2\2UV\7v\2\2V"+
		"\u0126\7g\2\2WX\7v\2\2XY\7k\2\2YZ\7r\2\2Z\u0126\7q\2\2[\\\7n\2\2\\]\7"+
		"k\2\2]^\7v\2\2^_\7g\2\2_`\7t\2\2`a\7c\2\2a\u0126\7n\2\2bc\7k\2\2cd\7p"+
		"\2\2de\7v\2\2ef\7g\2\2fg\7k\2\2gh\7t\2\2h\u0126\7q\2\2ij\7t\2\2jk\7g\2"+
		"\2kl\7c\2\2l\u0126\7n\2\2mn\7n\2\2no\7q\2\2op\7i\2\2pq\7k\2\2qr\7e\2\2"+
		"r\u0126\7q\2\2st\7x\2\2tu\7g\2\2uv\7t\2\2vw\7f\2\2wx\7c\2\2xy\7f\2\2y"+
		"z\7g\2\2z{\7k\2\2{|\7t\2\2|\u0126\7q\2\2}~\7h\2\2~\177\7c\2\2\177\u0080"+
		"\7n\2\2\u0080\u0081\7u\2\2\u0081\u0126\7q\2\2\u0082\u0083\7t\2\2\u0083"+
		"\u0084\7g\2\2\u0084\u0085\7i\2\2\u0085\u0086\7k\2\2\u0086\u0087\7u\2\2"+
		"\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u0126\7q\2\2\u008a\u008b"+
		"\7h\2\2\u008b\u008c\7k\2\2\u008c\u008d\7o\2\2\u008d\u008e\7a\2\2\u008e"+
		"\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7i\2\2\u0091\u0092\7k\2\2"+
		"\u0092\u0093\7u\2\2\u0093\u0094\7v\2\2\u0094\u0095\7t\2\2\u0095\u0126"+
		"\7q\2\2\u0096\u0097\7r\2\2\u0097\u0098\7t\2\2\u0098\u0099\7q\2\2\u0099"+
		"\u009a\7e\2\2\u009a\u009b\7g\2\2\u009b\u009c\7f\2\2\u009c\u009d\7k\2\2"+
		"\u009d\u009e\7o\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1"+
		"\7v\2\2\u00a1\u0126\7q\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7k\2\2\u00a4"+
		"\u00a5\7o\2\2\u00a5\u00a6\7a\2\2\u00a6\u00a7\7r\2\2\u00a7\u00a8\7t\2\2"+
		"\u00a8\u00a9\7q\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7f\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7o\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\u0126\7q\2\2\u00b2\u00b3\7h\2\2"+
		"\u00b3\u00b4\7w\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u0126\7q\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7k\2\2\u00ba"+
		"\u00bb\7o\2\2\u00bb\u00bc\7a\2\2\u00bc\u00bd\7h\2\2\u00bd\u00be\7w\2\2"+
		"\u00be\u00bf\7p\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7c\2\2\u00c1\u0126"+
		"\7q\2\2\u00c2\u00c3\7x\2\2\u00c3\u00c4\7c\2\2\u00c4\u0126\7t\2\2\u00c5"+
		"\u00c6\7n\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7k\2\2\u00c8\u0126\7c\2\2"+
		"\u00c9\u00ca\7g\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd"+
		"\7t\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7x\2\2\u00cf\u0126\7c\2\2\u00d0"+
		"\u00d1\7u\2\2\u00d1\u0126\7g\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7p\2\2"+
		"\u00d4\u00d5\7v\2\2\u00d5\u00d6\7c\2\2\u00d6\u0126\7q\2\2\u00d7\u00d8"+
		"\7u\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7c\2\2\u00db"+
		"\u0126\7q\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7o\2\2"+
		"\u00df\u00e0\7a\2\2\u00e0\u00e1\7u\2\2\u00e1\u0126\7g\2\2\u00e2\u00e3"+
		"\7e\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7u\2\2\u00e5\u0126\7q\2\2\u00e6"+
		"\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7l\2\2\u00e9\u0126\7c\2\2"+
		"\u00ea\u00eb\7h\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7o\2\2\u00ed\u00ee"+
		"\7a\2\2\u00ee\u00ef\7e\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7u\2\2\u00f1"+
		"\u0126\7q\2\2\u00f2\u00f3\7r\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7t\2\2"+
		"\u00f5\u0126\7c\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7v\2\2\u00f8\u0126"+
		"\7g\2\2\u00f9\u00fa\7h\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7e\2\2\u00fc"+
		"\u0126\7c\2\2\u00fd\u00fe\7h\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7o\2\2"+
		"\u0100\u0101\7a\2\2\u0101\u0102\7r\2\2\u0102\u0103\7c\2\2\u0103\u0104"+
		"\7t\2\2\u0104\u0126\7c\2\2\u0105\u0106\7g\2\2\u0106\u0107\7p\2\2\u0107"+
		"\u0108\7s\2\2\u0108\u0109\7w\2\2\u0109\u010a\7c\2\2\u010a\u010b\7p\2\2"+
		"\u010b\u010c\7v\2\2\u010c\u0126\7q\2\2\u010d\u010e\7h\2\2\u010e\u010f"+
		"\7k\2\2\u010f\u0110\7o\2\2\u0110\u0111\7a\2\2\u0111\u0112\7g\2\2\u0112"+
		"\u0113\7p\2\2\u0113\u0114\7s\2\2\u0114\u0115\7w\2\2\u0115\u0116\7c\2\2"+
		"\u0116\u0117\7p\2\2\u0117\u0118\7v\2\2\u0118\u0126\7q\2\2\u0119\u011a"+
		"\7t\2\2\u011a\u011b\7g\2\2\u011b\u011c\7v\2\2\u011c\u011d\7q\2\2\u011d"+
		"\u011e\7t\2\2\u011e\u011f\7p\2\2\u011f\u0126\7g\2\2\u0120\u0121\7p\2\2"+
		"\u0121\u0122\7c\2\2\u0122\u0126\7q\2\2\u0123\u0124\7>\2\2\u0124\u0126"+
		"\7/\2\2\u0125\61\3\2\2\2\u0125:\3\2\2\2\u0125G\3\2\2\2\u0125N\3\2\2\2"+
		"\u0125W\3\2\2\2\u0125[\3\2\2\2\u0125b\3\2\2\2\u0125i\3\2\2\2\u0125m\3"+
		"\2\2\2\u0125s\3\2\2\2\u0125}\3\2\2\2\u0125\u0082\3\2\2\2\u0125\u008a\3"+
		"\2\2\2\u0125\u0096\3\2\2\2\u0125\u00a2\3\2\2\2\u0125\u00b2\3\2\2\2\u0125"+
		"\u00b8\3\2\2\2\u0125\u00c2\3\2\2\2\u0125\u00c5\3\2\2\2\u0125\u00c9\3\2"+
		"\2\2\u0125\u00d0\3\2\2\2\u0125\u00d2\3\2\2\2\u0125\u00d7\3\2\2\2\u0125"+
		"\u00dc\3\2\2\2\u0125\u00e2\3\2\2\2\u0125\u00e6\3\2\2\2\u0125\u00ea\3\2"+
		"\2\2\u0125\u00f2\3\2\2\2\u0125\u00f6\3\2\2\2\u0125\u00f9\3\2\2\2\u0125"+
		"\u00fd\3\2\2\2\u0125\u0105\3\2\2\2\u0125\u010d\3\2\2\2\u0125\u0119\3\2"+
		"\2\2\u0125\u0120\3\2\2\2\u0125\u0123\3\2\2\2\u0126\n\3\2\2\2\u0127\u0129"+
		"\4\62;\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\f\3\2\2\2\u012c\u012e\4\62;\2\u012d\u012c\3\2\2\2"+
		"\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131"+
		"\3\2\2\2\u0131\u0133\7\60\2\2\u0132\u0134\4\62;\2\u0133\u0132\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\16"+
		"\3\2\2\2\u0137\u0145\t\4\2\2\u0138\u0139\7q\2\2\u0139\u0145\7w\2\2\u013a"+
		"\u013b\7>\2\2\u013b\u0145\7@\2\2\u013c\u013d\7@\2\2\u013d\u0145\7?\2\2"+
		"\u013e\u013f\7>\2\2\u013f\u0145\7?\2\2\u0140\u0145\t\5\2\2\u0141\u0142"+
		"\7\60\2\2\u0142\u0145\7\60\2\2\u0143\u0145\7\60\2\2\u0144\u0137\3\2\2"+
		"\2\u0144\u0138\3\2\2\2\u0144\u013a\3\2\2\2\u0144\u013c\3\2\2\2\u0144\u013e"+
		"\3\2\2\2\u0144\u0140\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0143\3\2\2\2\u0145"+
		"\20\3\2\2\2\u0146\u014a\t\6\2\2\u0147\u0149\t\7\2\2\u0148\u0147\3\2\2"+
		"\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\22"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0151\7$\2\2\u014e\u0150\n\b\2\2\u014f"+
		"\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7$\2\2\u0155"+
		"\24\3\2\2\2\u0156\u015a\7$\2\2\u0157\u0159\n\b\2\2\u0158\u0157\3\2\2\2"+
		"\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\f\2\2\u015e\26\3\2\2\2\u015f"+
		"\u0160\t\t\2\2\u0160\30\3\2\2\2\r\2\35(\u0125\u012a\u012f\u0135\u0144"+
		"\u014a\u0151\u015a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}