/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar Interpretador;

@header{
    package interpretador.parser;
    import java.util.*;
}
program : (stmt EOL)+
        ;

stmt    : print
        | read
        | attr
        | expr
        ;

print   : PRINT STR                 {System.out.println($STR.text.replace("\"",""));}
        | PRINT expr                {System.out.println($expr.value);}
        ;

read    : READ VAR                  {
            Scanner s = new Scanner(System.in);
            Double d = s.nextDouble();
            SymbolsTable.getInstance().addSymbol($VAR.text, d);
        }
        ;

attr    : a=VAR EQ e=expr          {SymbolsTable.getInstance().addSymbol($a.text, $e.value);}
        ;

expr    returns[Double value]
        : a=expr1 '+' b=expr        {$value = $a.value + $b.value;}
        | a=expr1 '-' b=expr        {$value = $a.value - $b.value;}
        | a=expr1                   {$value = $a.value;}
        ;

expr1   returns[Double value]
        : a=expr2 '*' b=expr        {$value = $a.value * $b.value;}
        | a=expr2 '/' b=expr        {$value = $a.value / $b.value;}
        | a=expr2                   {$value = $a.value;}
        ;

expr2   returns[Double value]
        : '(' a=expr ')'          {$value = $a.value;}
        | n=NUM                   {$value = Double.parseDouble($n.text);}
        | v=VAR                   {$value = SymbolsTable.getInstance().getSymbol($v.text);}
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
STR     : '"'[a-zA-Z0-9\t ]*'"';
WS      : [\n\r \t]+ -> skip;