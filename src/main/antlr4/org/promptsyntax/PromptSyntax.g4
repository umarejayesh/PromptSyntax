grammar PromptSyntax;

program
    : targetDecl packageDecl? importBlock? topLevelDecl+ constraintBlock? generateBlock verifyBlock? EOF
    ;

topLevelDecl
    : enumDecl
    | interfaceDecl
    | entityDecl
    ;

targetDecl : TARGET IDENTIFIER SEMI ;
packageDecl : PACKAGE qualifiedName SEMI ;
importBlock : IMPORTS LBRACE importItem+ RBRACE ;
importItem : qualifiedName STAR? SEMI ;
qualifiedName : IDENTIFIER (DOT IDENTIFIER)* ;

enumDecl : ENUM IDENTIFIER LBRACE enumItem+ RBRACE ;
enumItem : IDENTIFIER SEMI ;

interfaceDecl : INTERFACE IDENTIFIER LBRACE fieldDecl+ RBRACE ;

entityDecl : ENTITY IDENTIFIER extendsClause? implementsClause? LBRACE entityMember+ RBRACE ;

extendsClause : EXTENDS IDENTIFIER ;

entityMember
    : fieldDecl
    | methodDecl
    ;

methodDecl
    : METHOD IDENTIFIER LPAREN parameterList? RPAREN COLON typeName SEMI
    ;

parameterList
    : parameter (COMMA parameter)*
    ;

parameter
    : IDENTIFIER COLON typeName
    ;
implementsClause : IMPLEMENTS IDENTIFIER (COMMA IDENTIFIER)* ;

fieldDecl : IDENTIFIER COLON typeName SEMI ;

typeName
    : IDENTIFIER
    | IDENTIFIER LT typeName GT
    | IDENTIFIER LT typeName COMMA typeName GT
    ;

constraintBlock : CONSTRAINTS LBRACE constraintItem+ RBRACE ;
constraintItem : (IMMUTABLE | DOCUMENTED | SERIALIZABLE | CLEAN_CODE | LOW_COMPLEXITY) SEMI ;

generateBlock : GENERATE LBRACE generateItem+ RBRACE ;
generateItem
    : (CLASS | CONSTRUCTOR | GETTERS | SETTERS | BUILDER | TESTS | DOCUMENTATION | EQUALS | HASHCODE | TOSTRING) SEMI
    ;

verifyBlock : VERIFY LBRACE verifyItem+ RBRACE ;
verifyItem : (COMPILE | RUN_TESTS | LINT) SEMI ;

TARGET : 'target';
PACKAGE : 'package';
IMPORTS : 'imports';
ENTITY : 'entity';
ENUM : 'enum';
INTERFACE : 'interface';
IMPLEMENTS : 'implements';
CONSTRAINTS : 'constraints';
GENERATE : 'generate';
VERIFY : 'verify';


IMMUTABLE : 'immutable';
DOCUMENTED : 'documented';
SERIALIZABLE : 'serializable';
CLEAN_CODE : 'clean_code';
LOW_COMPLEXITY : 'low_complexity';

CLASS : 'class';
CONSTRUCTOR : 'constructor';
GETTERS : 'getters';
SETTERS : 'setters';
BUILDER : 'builder';
TESTS : 'tests';
DOCUMENTATION : 'documentation';
EQUALS : 'equals';
HASHCODE : 'hashcode';
TOSTRING : 'tostring';

COMPILE : 'compile';
RUN_TESTS : 'run_tests';
LINT : 'lint';
METHOD : 'method';
EXTENDS : 'extends';


COMMA : ',';
LT : '<';
GT : '>';
STAR : '*';
DOT : '.';
LBRACE : '{';
RBRACE : '}';
COLON : ':';
SEMI : ';';
LPAREN : '(';
RPAREN : ')';

IDENTIFIER : [A-Za-z] [A-Za-z0-9_]* ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS : [ \t\r\n]+ -> skip ;