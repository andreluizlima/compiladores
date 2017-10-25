/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;
import interpretador.parser.InterpretadorLexer;
import interpretador.parser.InterpretadorParser;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
/**
 *
 * @author a120106
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRFileStream("input.basic");
                
        InterpretadorLexer lexer = new InterpretadorLexer(input);
        
        TokenStream tokens = new BufferedTokenStream(lexer);
        InterpretadorParser parser = new InterpretadorParser(tokens);
        
        parser.program();
    }
    
}
