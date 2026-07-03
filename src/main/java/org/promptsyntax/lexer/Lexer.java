package org.promptsyntax.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;
    private int column = 1;
    private int tokenColumn = 1;

    private static final Map<String, TokenType> KEYWORDS = new HashMap<>();

    static {
        KEYWORDS.put("target", TokenType.TARGET);
        KEYWORDS.put("entity", TokenType.ENTITY);
        KEYWORDS.put("field", TokenType.FIELD);
        KEYWORDS.put("constraint", TokenType.CONSTRAINT);
        KEYWORDS.put("generate", TokenType.GENERATE);
        KEYWORDS.put("verify", TokenType.VERIFY);
        KEYWORDS.put("backend", TokenType.BACKEND);
        KEYWORDS.put("using", TokenType.USING);
        KEYWORDS.put("import", TokenType.IMPORT);
        KEYWORDS.put("enum", TokenType.ENUM);
        KEYWORDS.put("type", TokenType.TYPE);
        KEYWORDS.put("true", TokenType.BOOLEAN_LITERAL);
        KEYWORDS.put("false", TokenType.BOOLEAN_LITERAL);
        KEYWORDS.put("if", TokenType.IF);
        KEYWORDS.put("else", TokenType.ELSE);
        KEYWORDS.put("return", TokenType.RETURN);

        KEYWORDS.put("String", TokenType.TYPE_NAME);
        KEYWORDS.put("Integer", TokenType.TYPE_NAME);
        KEYWORDS.put("Float", TokenType.TYPE_NAME);
        KEYWORDS.put("Boolean", TokenType.TYPE_NAME);
    }

    public Lexer(String source) {
        this.source = source == null ? "" : source;
    }

    public List<Token> tokenize() {
        while (!isAtEnd()) {
            start = current;
            tokenColumn = column;
            scanToken();
        }

        tokens.add(new Token(TokenType.EOF, "", line, column));
        return tokens;
    }

    private void scanToken() {
        char c = advance();

        switch (c) {
            case '(' -> addToken(TokenType.LPAREN);
            case ')' -> addToken(TokenType.RPAREN);
            case '{' -> addToken(TokenType.LBRACE);
            case '}' -> addToken(TokenType.RBRACE);
            case '[' -> addToken(TokenType.LBRACKET);
            case ']' -> addToken(TokenType.RBRACKET);
            case ':' -> addToken(TokenType.COLON);
            case ';' -> addToken(TokenType.SEMICOLON);
            case ',' -> addToken(TokenType.COMMA);
            case '.' -> addToken(TokenType.DOT);
            case '+' -> addToken(TokenType.PLUS);
            case '*' -> addToken(TokenType.STAR);

            case '-' -> {
                if (match('>')) addToken(TokenType.ARROW);
                else addToken(TokenType.MINUS);
            }

            case '=' -> {
                if (match('=')) addToken(TokenType.EQ);
                else addToken(TokenType.ASSIGN);
            }

            case '!' -> {
                if (match('=')) addToken(TokenType.NEQ);
                else error("Unexpected character '!'");
            }

            case '<' -> {
                if (match('=')) addToken(TokenType.LTE);
                else addToken(TokenType.LT);
            }

            case '>' -> {
                if (match('=')) addToken(TokenType.GTE);
                else addToken(TokenType.GT);
            }

            case '&' -> {
                if (match('&')) addToken(TokenType.AND);
                else error("Unexpected character '&'");
            }

            case '|' -> {
                if (match('|')) addToken(TokenType.OR);
                else error("Unexpected character '|'");
            }

            case '/' -> {
                if (match('/')) {
                    skipSingleLineComment();
                } else if (match('*')) {
                    skipMultiLineComment();
                } else {
                    addToken(TokenType.SLASH);
                }
            }

            case '"' -> stringLiteral();

            case ' ', '\r', '\t' -> {
                // ignore whitespace
            }

            case '\n' -> {
                line++;
                column = 1;
            }

            default -> {
                if (isDigit(c)) {
                    numberLiteral();
                } else if (isAlpha(c)) {
                    identifier();
                } else {
                    error("Unexpected character '" + c + "'");
                }
            }
        }
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) {
            advance();
        }

        String text = source.substring(start, current);
        TokenType type = KEYWORDS.getOrDefault(text, TokenType.IDENTIFIER);
        addToken(type, text);
    }

    private void numberLiteral() {
        while (isDigit(peek())) {
            advance();
        }

        boolean isFloat = false;

        if (peek() == '.' && isDigit(peekNext())) {
            isFloat = true;
            advance();

            while (isDigit(peek())) {
                advance();
            }
        }

        String text = source.substring(start, current);
        addToken(isFloat ? TokenType.FLOAT_LITERAL : TokenType.INTEGER_LITERAL, text);
    }

    private void stringLiteral() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') {
                line++;
                column = 1;
            }
            advance();
        }

        if (isAtEnd()) {
            error("Unterminated string literal");
        }

        advance();

        String value = source.substring(start + 1, current - 1);
        addToken(TokenType.STRING_LITERAL, value);
    }

    private void skipSingleLineComment() {
        while (peek() != '\n' && !isAtEnd()) {
            advance();
        }
    }

    private void skipMultiLineComment() {
        while (!isAtEnd()) {
            if (peek() == '*' && peekNext() == '/') {
                advance();
                advance();
                return;
            }

            if (peek() == '\n') {
                line++;
                column = 1;
            }

            advance();
        }

        error("Unterminated multi-line comment");
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;

        current++;
        column++;
        return true;
    }

    private char advance() {
        char c = source.charAt(current);
        current++;
        column++;
        return c;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private void addToken(TokenType type) {
        String text = source.substring(start, current);
        addToken(type, text);
    }

    private void addToken(TokenType type, String lexeme) {
        tokens.add(new Token(type, lexeme, line, tokenColumn));
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private void error(String message) {
        throw new LexerException(
                "Lexer Error: " + message + " at line " + line + ", column " + tokenColumn
        );
    }
}