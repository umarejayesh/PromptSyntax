package org.promptsyntax.lexer;

public enum TokenType {
    TARGET, ENTITY, FIELD, CONSTRAINT, GENERATE, VERIFY,
    BACKEND, USING, IMPORT, ENUM, TYPE, TRUE, FALSE,
    IF, ELSE, RETURN,

    IDENTIFIER,
    TYPE_NAME,

    INTEGER_LITERAL,
    FLOAT_LITERAL,
    STRING_LITERAL,
    BOOLEAN_LITERAL,

    ASSIGN,
    EQ,
    NEQ,
    LT,
    LTE,
    GT,
    GTE,
    PLUS,
    MINUS,
    STAR,
    SLASH,
    COLON,
    SEMICOLON,
    COMMA,
    DOT,
    ARROW,
    AND,
    OR,

    LPAREN,
    RPAREN,
    LBRACE,
    RBRACE,
    LBRACKET,
    RBRACKET,

    EOF
}