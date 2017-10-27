package interpretador;

import interpretador.parser.InterpretadorLexer;
import interpretador.parser.InterpretadorParser;
import interpretador.parser.SymbolsTable;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import interpretador.parser.InterpretadorLexer;
import interpretador.parser.InterpretadorParser;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Run {


    public static void main(String[] args) throws Exception {
        String fn = "";
        if(args.length > 0){
            fn = args[0];
        }else{
            System.out.println("Error: missing parameter");
            return;
        }
        ANTLRInputStream input = new ANTLRFileStream(fn);
        InterpretadorLexer lexer = new InterpretadorLexer(input);
        TokenStream tokens = new BufferedTokenStream(lexer);
        InterpretadorParser parser = new InterpretadorParser(tokens);
        parser.program();
        //showParseTreeFrame(expr, parser);
        //System.out.println(SymbolsTable.getInstance().symbols);
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
    }
}
