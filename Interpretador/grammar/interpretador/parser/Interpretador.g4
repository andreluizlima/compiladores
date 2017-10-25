/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar Interpretador;

program : (statement EOL) + 
        
        ;

statement : print
          | read
          | attr
          | expr
          ;

print : PRINT STR
      | PRINT expr
      
      ;
EOL: ';';