/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar Interpretador;

@header{
    package interpretador.parser;
}
program : (stmt EOL)+
        ;

stmt    : print
        | read
        | attr
        | expr
        ;

print   : PRINT STR
        | PRINT expr
        ;

read    : READ VAR
        ;

attr    : VAR '=' expr
        ;

expr    returns[Double value]
        : expr1 '+' expr
        | expr1 '-' expr
        | expr1
        ;

expr1   returns[Double value]
        : expr2 '*' expr
        | expr2 '/' expr
        | expr2
        ;

expr2   returns[Double value]
        : '(' expr ')'
        | NUM
        | VAR
        ;

//TOKENS
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
OPEN    : '(' ;
CLOSE   : ')' ;
EQ      : '=' ;
EOL     : ';' ;
PRINT   : 'print' ;
READ    : 'read' ;
NUM     : [0-9]+ ;
VAR     : [a-zA-Z][a-zA-Z0-9_]*;
STR     : '"'[a-zA-Z0-9 ]+'"';
WS      : [\n\r \t]+ -> skip;