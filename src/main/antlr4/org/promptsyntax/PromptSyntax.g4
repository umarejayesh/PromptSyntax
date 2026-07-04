grammar PromptSyntax;

program
    : targetDecl packageDecl? importBlock? topLevelDecl+ constraintBlock? generateBlock verifyBlock? EOF
    ;

topLevelDecl
    : enumDecl
    | entityDecl
    ;

targetDecl : TARGET IDENTIFIER SEMI ;
packageDecl : PACKAGE qualifiedName SEMI ;
importBlock : IMPORTS LBRACE importItem+ RBRACE ;
importItem : qualifiedName STAR? SEMI ;
qualifiedName : IDENTIFIER (DOT IDENTIFIER)* ;

enumDecl : ENUM IDENTIFIER LBRACE enumItem+ RBRACE ;
enumItem : IDENTIFIER SEMI ;

entityDecl : ENTITY IDENTIFIER LBRACE fieldDecl+ RBRACE ;
fieldDecl : IDENTIFIER COLON typeName SEMI ;
typeName : IDENTIFIER ;

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

STAR : '*';
DOT : '.';
LBRACE : '{';
RBRACE : '}';
COLON : ':';
SEMI : ';';

IDENTIFIER : [A-Za-z] [A-Za-z0-9_]* ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS : [ \t\r\n]+ -> skip ;