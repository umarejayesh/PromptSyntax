// Generated from org/promptsyntax/PromptSyntax.g4 by ANTLR 4.13.1
package org.promptsyntax;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PromptSyntaxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TARGET=1, PACKAGE=2, IMPORTS=3, ENTITY=4, CONSTRAINTS=5, GENERATE=6, VERIFY=7, 
		IMMUTABLE=8, DOCUMENTED=9, SERIALIZABLE=10, CLEAN_CODE=11, LOW_COMPLEXITY=12, 
		CLASS=13, CONSTRUCTOR=14, GETTERS=15, SETTERS=16, BUILDER=17, TESTS=18, 
		DOCUMENTATION=19, EQUALS=20, HASHCODE=21, TOSTRING=22, COMPILE=23, RUN_TESTS=24, 
		LINT=25, STAR=26, DOT=27, LBRACE=28, RBRACE=29, COLON=30, SEMI=31, IDENTIFIER=32, 
		LINE_COMMENT=33, BLOCK_COMMENT=34, WS=35;
	public static final int
		RULE_program = 0, RULE_targetDecl = 1, RULE_packageDecl = 2, RULE_importBlock = 3, 
		RULE_importItem = 4, RULE_qualifiedName = 5, RULE_entityDecl = 6, RULE_fieldDecl = 7, 
		RULE_typeName = 8, RULE_constraintBlock = 9, RULE_constraintItem = 10, 
		RULE_generateBlock = 11, RULE_generateItem = 12, RULE_verifyBlock = 13, 
		RULE_verifyItem = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "targetDecl", "packageDecl", "importBlock", "importItem", 
			"qualifiedName", "entityDecl", "fieldDecl", "typeName", "constraintBlock", 
			"constraintItem", "generateBlock", "generateItem", "verifyBlock", "verifyItem"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'target'", "'package'", "'imports'", "'entity'", "'constraints'", 
			"'generate'", "'verify'", "'immutable'", "'documented'", "'serializable'", 
			"'clean_code'", "'low_complexity'", "'class'", "'constructor'", "'getters'", 
			"'setters'", "'builder'", "'tests'", "'documentation'", "'equals'", "'hashcode'", 
			"'tostring'", "'compile'", "'run_tests'", "'lint'", "'*'", "'.'", "'{'", 
			"'}'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TARGET", "PACKAGE", "IMPORTS", "ENTITY", "CONSTRAINTS", "GENERATE", 
			"VERIFY", "IMMUTABLE", "DOCUMENTED", "SERIALIZABLE", "CLEAN_CODE", "LOW_COMPLEXITY", 
			"CLASS", "CONSTRUCTOR", "GETTERS", "SETTERS", "BUILDER", "TESTS", "DOCUMENTATION", 
			"EQUALS", "HASHCODE", "TOSTRING", "COMPILE", "RUN_TESTS", "LINT", "STAR", 
			"DOT", "LBRACE", "RBRACE", "COLON", "SEMI", "IDENTIFIER", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS"
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

	@Override
	public String getGrammarFileName() { return "PromptSyntax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PromptSyntaxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TargetDeclContext targetDecl() {
			return getRuleContext(TargetDeclContext.class,0);
		}
		public GenerateBlockContext generateBlock() {
			return getRuleContext(GenerateBlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PromptSyntaxParser.EOF, 0); }
		public PackageDeclContext packageDecl() {
			return getRuleContext(PackageDeclContext.class,0);
		}
		public ImportBlockContext importBlock() {
			return getRuleContext(ImportBlockContext.class,0);
		}
		public List<EntityDeclContext> entityDecl() {
			return getRuleContexts(EntityDeclContext.class);
		}
		public EntityDeclContext entityDecl(int i) {
			return getRuleContext(EntityDeclContext.class,i);
		}
		public ConstraintBlockContext constraintBlock() {
			return getRuleContext(ConstraintBlockContext.class,0);
		}
		public VerifyBlockContext verifyBlock() {
			return getRuleContext(VerifyBlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			targetDecl();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(31);
				packageDecl();
				}
			}

			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(34);
				importBlock();
				}
			}

			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				entityDecl();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ENTITY );
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINTS) {
				{
				setState(42);
				constraintBlock();
				}
			}

			setState(45);
			generateBlock();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VERIFY) {
				{
				setState(46);
				verifyBlock();
				}
			}

			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TargetDeclContext extends ParserRuleContext {
		public TerminalNode TARGET() { return getToken(PromptSyntaxParser.TARGET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PromptSyntaxParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public TargetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterTargetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitTargetDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitTargetDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetDeclContext targetDecl() throws RecognitionException {
		TargetDeclContext _localctx = new TargetDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_targetDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(TARGET);
			setState(52);
			match(IDENTIFIER);
			setState(53);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageDeclContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(PromptSyntaxParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public PackageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterPackageDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitPackageDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitPackageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclContext packageDecl() throws RecognitionException {
		PackageDeclContext _localctx = new PackageDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_packageDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(PACKAGE);
			setState(56);
			qualifiedName();
			setState(57);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportBlockContext extends ParserRuleContext {
		public TerminalNode IMPORTS() { return getToken(PromptSyntaxParser.IMPORTS, 0); }
		public TerminalNode LBRACE() { return getToken(PromptSyntaxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PromptSyntaxParser.RBRACE, 0); }
		public List<ImportItemContext> importItem() {
			return getRuleContexts(ImportItemContext.class);
		}
		public ImportItemContext importItem(int i) {
			return getRuleContext(ImportItemContext.class,i);
		}
		public ImportBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterImportBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitImportBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitImportBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportBlockContext importBlock() throws RecognitionException {
		ImportBlockContext _localctx = new ImportBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IMPORTS);
			setState(60);
			match(LBRACE);
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				importItem();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(66);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportItemContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public TerminalNode STAR() { return getToken(PromptSyntaxParser.STAR, 0); }
		public ImportItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterImportItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitImportItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitImportItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportItemContext importItem() throws RecognitionException {
		ImportItemContext _localctx = new ImportItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			qualifiedName();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(69);
				match(STAR);
				}
			}

			setState(72);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PromptSyntaxParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PromptSyntaxParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PromptSyntaxParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PromptSyntaxParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(IDENTIFIER);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(75);
				match(DOT);
				setState(76);
				match(IDENTIFIER);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntityDeclContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(PromptSyntaxParser.ENTITY, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PromptSyntaxParser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(PromptSyntaxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PromptSyntaxParser.RBRACE, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public EntityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterEntityDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitEntityDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitEntityDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityDeclContext entityDecl() throws RecognitionException {
		EntityDeclContext _localctx = new EntityDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_entityDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ENTITY);
			setState(83);
			match(IDENTIFIER);
			setState(84);
			match(LBRACE);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				fieldDecl();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(90);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PromptSyntaxParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(PromptSyntaxParser.COLON, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFIER);
			setState(93);
			match(COLON);
			setState(94);
			typeName();
			setState(95);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PromptSyntaxParser.IDENTIFIER, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstraintBlockContext extends ParserRuleContext {
		public TerminalNode CONSTRAINTS() { return getToken(PromptSyntaxParser.CONSTRAINTS, 0); }
		public TerminalNode LBRACE() { return getToken(PromptSyntaxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PromptSyntaxParser.RBRACE, 0); }
		public List<ConstraintItemContext> constraintItem() {
			return getRuleContexts(ConstraintItemContext.class);
		}
		public ConstraintItemContext constraintItem(int i) {
			return getRuleContext(ConstraintItemContext.class,i);
		}
		public ConstraintBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterConstraintBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitConstraintBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitConstraintBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintBlockContext constraintBlock() throws RecognitionException {
		ConstraintBlockContext _localctx = new ConstraintBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constraintBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(CONSTRAINTS);
			setState(100);
			match(LBRACE);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				constraintItem();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7936L) != 0) );
			setState(106);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstraintItemContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public TerminalNode IMMUTABLE() { return getToken(PromptSyntaxParser.IMMUTABLE, 0); }
		public TerminalNode DOCUMENTED() { return getToken(PromptSyntaxParser.DOCUMENTED, 0); }
		public TerminalNode SERIALIZABLE() { return getToken(PromptSyntaxParser.SERIALIZABLE, 0); }
		public TerminalNode CLEAN_CODE() { return getToken(PromptSyntaxParser.CLEAN_CODE, 0); }
		public TerminalNode LOW_COMPLEXITY() { return getToken(PromptSyntaxParser.LOW_COMPLEXITY, 0); }
		public ConstraintItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterConstraintItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitConstraintItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitConstraintItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintItemContext constraintItem() throws RecognitionException {
		ConstraintItemContext _localctx = new ConstraintItemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constraintItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7936L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(109);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenerateBlockContext extends ParserRuleContext {
		public TerminalNode GENERATE() { return getToken(PromptSyntaxParser.GENERATE, 0); }
		public TerminalNode LBRACE() { return getToken(PromptSyntaxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PromptSyntaxParser.RBRACE, 0); }
		public List<GenerateItemContext> generateItem() {
			return getRuleContexts(GenerateItemContext.class);
		}
		public GenerateItemContext generateItem(int i) {
			return getRuleContext(GenerateItemContext.class,i);
		}
		public GenerateBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generateBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterGenerateBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitGenerateBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitGenerateBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerateBlockContext generateBlock() throws RecognitionException {
		GenerateBlockContext _localctx = new GenerateBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_generateBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(GENERATE);
			setState(112);
			match(LBRACE);
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113);
				generateItem();
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8380416L) != 0) );
			setState(118);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenerateItemContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public TerminalNode CLASS() { return getToken(PromptSyntaxParser.CLASS, 0); }
		public TerminalNode CONSTRUCTOR() { return getToken(PromptSyntaxParser.CONSTRUCTOR, 0); }
		public TerminalNode GETTERS() { return getToken(PromptSyntaxParser.GETTERS, 0); }
		public TerminalNode SETTERS() { return getToken(PromptSyntaxParser.SETTERS, 0); }
		public TerminalNode BUILDER() { return getToken(PromptSyntaxParser.BUILDER, 0); }
		public TerminalNode TESTS() { return getToken(PromptSyntaxParser.TESTS, 0); }
		public TerminalNode DOCUMENTATION() { return getToken(PromptSyntaxParser.DOCUMENTATION, 0); }
		public TerminalNode EQUALS() { return getToken(PromptSyntaxParser.EQUALS, 0); }
		public TerminalNode HASHCODE() { return getToken(PromptSyntaxParser.HASHCODE, 0); }
		public TerminalNode TOSTRING() { return getToken(PromptSyntaxParser.TOSTRING, 0); }
		public GenerateItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generateItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterGenerateItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitGenerateItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitGenerateItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerateItemContext generateItem() throws RecognitionException {
		GenerateItemContext _localctx = new GenerateItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_generateItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380416L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(121);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerifyBlockContext extends ParserRuleContext {
		public TerminalNode VERIFY() { return getToken(PromptSyntaxParser.VERIFY, 0); }
		public TerminalNode LBRACE() { return getToken(PromptSyntaxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PromptSyntaxParser.RBRACE, 0); }
		public List<VerifyItemContext> verifyItem() {
			return getRuleContexts(VerifyItemContext.class);
		}
		public VerifyItemContext verifyItem(int i) {
			return getRuleContext(VerifyItemContext.class,i);
		}
		public VerifyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verifyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterVerifyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitVerifyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitVerifyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerifyBlockContext verifyBlock() throws RecognitionException {
		VerifyBlockContext _localctx = new VerifyBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_verifyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(VERIFY);
			setState(124);
			match(LBRACE);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				verifyItem();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0) );
			setState(130);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerifyItemContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(PromptSyntaxParser.SEMI, 0); }
		public TerminalNode COMPILE() { return getToken(PromptSyntaxParser.COMPILE, 0); }
		public TerminalNode RUN_TESTS() { return getToken(PromptSyntaxParser.RUN_TESTS, 0); }
		public TerminalNode LINT() { return getToken(PromptSyntaxParser.LINT, 0); }
		public VerifyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verifyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).enterVerifyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PromptSyntaxListener ) ((PromptSyntaxListener)listener).exitVerifyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PromptSyntaxVisitor ) return ((PromptSyntaxVisitor<? extends T>)visitor).visitVerifyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerifyItemContext verifyItem() throws RecognitionException {
		VerifyItemContext _localctx = new VerifyItemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_verifyItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(133);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u0088\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0003\u0000!\b\u0000\u0001\u0000\u0003\u0000$\b\u0000\u0001\u0000\u0004"+
		"\u0000\'\b\u0000\u000b\u0000\f\u0000(\u0001\u0000\u0003\u0000,\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u00000\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"?\b\u0003\u000b\u0003\f\u0003@\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004G\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006W\b\u0006\u000b"+
		"\u0006\f\u0006X\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0004\tg\b\t\u000b\t\f\th\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0004\u000bs\b\u000b\u000b\u000b\f\u000b"+
		"t\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0004\r\u007f\b\r\u000b\r\f\r\u0080\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0003\u0001"+
		"\u0000\b\f\u0001\u0000\r\u0016\u0001\u0000\u0017\u0019\u0084\u0000\u001e"+
		"\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00047\u0001\u0000"+
		"\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000"+
		"\nJ\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000"+
		"\u0000\u0000\u0010a\u0001\u0000\u0000\u0000\u0012c\u0001\u0000\u0000\u0000"+
		"\u0014l\u0001\u0000\u0000\u0000\u0016o\u0001\u0000\u0000\u0000\u0018x"+
		"\u0001\u0000\u0000\u0000\u001a{\u0001\u0000\u0000\u0000\u001c\u0084\u0001"+
		"\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f!\u0003\u0004\u0002"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!#\u0001"+
		"\u0000\u0000\u0000\"$\u0003\u0006\u0003\u0000#\"\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%\'\u0003\f\u0006"+
		"\u0000&%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*,\u0003"+
		"\u0012\t\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-/\u0003\u0016\u000b\u0000.0\u0003\u001a\r\u0000/.\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"12\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u000034\u0005\u0001"+
		"\u0000\u000045\u0005 \u0000\u000056\u0005\u001f\u0000\u00006\u0003\u0001"+
		"\u0000\u0000\u000078\u0005\u0002\u0000\u000089\u0003\n\u0005\u00009:\u0005"+
		"\u001f\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0005\u0003\u0000"+
		"\u0000<>\u0005\u001c\u0000\u0000=?\u0003\b\u0004\u0000>=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0005\u001d\u0000\u0000C\u0007"+
		"\u0001\u0000\u0000\u0000DF\u0003\n\u0005\u0000EG\u0005\u001a\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HI\u0005\u001f\u0000\u0000I\t\u0001\u0000\u0000\u0000JO\u0005 \u0000"+
		"\u0000KL\u0005\u001b\u0000\u0000LN\u0005 \u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000P\u000b\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0004\u0000\u0000ST\u0005 \u0000\u0000TV\u0005\u001c\u0000\u0000"+
		"UW\u0003\u000e\u0007\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0005\u001d\u0000\u0000[\r\u0001\u0000\u0000\u0000\\]\u0005"+
		" \u0000\u0000]^\u0005\u001e\u0000\u0000^_\u0003\u0010\b\u0000_`\u0005"+
		"\u001f\u0000\u0000`\u000f\u0001\u0000\u0000\u0000ab\u0005 \u0000\u0000"+
		"b\u0011\u0001\u0000\u0000\u0000cd\u0005\u0005\u0000\u0000df\u0005\u001c"+
		"\u0000\u0000eg\u0003\u0014\n\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0005\u001d\u0000\u0000k\u0013\u0001\u0000\u0000"+
		"\u0000lm\u0007\u0000\u0000\u0000mn\u0005\u001f\u0000\u0000n\u0015\u0001"+
		"\u0000\u0000\u0000op\u0005\u0006\u0000\u0000pr\u0005\u001c\u0000\u0000"+
		"qs\u0003\u0018\f\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u0005\u001d\u0000\u0000w\u0017\u0001\u0000\u0000\u0000xy\u0007"+
		"\u0001\u0000\u0000yz\u0005\u001f\u0000\u0000z\u0019\u0001\u0000\u0000"+
		"\u0000{|\u0005\u0007\u0000\u0000|~\u0005\u001c\u0000\u0000}\u007f\u0003"+
		"\u001c\u000e\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u001d\u0000\u0000"+
		"\u0083\u001b\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0002\u0000\u0000"+
		"\u0085\u0086\u0005\u001f\u0000\u0000\u0086\u001d\u0001\u0000\u0000\u0000"+
		"\f #(+/@FOXht\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}