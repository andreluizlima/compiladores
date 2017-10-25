package interpretador;
<<<<<<< HEAD

import interpretador.parser.InterpretadorLexer;
import interpretador.parser.InterpretadorParser;
import interpretador.parser.SymbolsTable;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
=======
import interpretador.parser.InterpretadorLexer;
import interpretador.parser.InterpretadorParser;
import java.io.IOException;
>>>>>>> f158291cf2ee9eb2d7ce921e5d61f27497a5e19b
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
<<<<<<< HEAD
import org.antlr.v4.runtime.tree.ParseTree;


public class Run {


    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRFileStream("input.basic");
        InterpretadorLexer lexer = new InterpretadorLexer(input);
        TokenStream tokens = new BufferedTokenStream(lexer);
        InterpretadorParser parser = new InterpretadorParser(tokens);
        InterpretadorParser.ExprContext expr = parser.expr();
        System.out.println(expr.value);
        parser.program();
        showParseTreeFrame(expr, parser);
        System.out.println(SymbolsTable.getInstance().symbols);
    }

    private static void showParseTreeFrame(ParseTree tree, InterpretadorParser parser) throws HeadlessException {
        JFrame frame = new JFrame("SRC: " + tree.getText());
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
        parser.getRuleNames()), tree);
        viewr.setScale(1);
        panel.add(viewr);
        frame.add(panel);
        frame.setSize(1000, 600);
        frame.setState(JFrame.MAXIMIZED_HORIZ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
=======
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
>>>>>>> f158291cf2ee9eb2d7ce921e5d61f27497a5e19b
    }
}
