package interpretador.parser;

import java.util.HashMap;

public class SymbolsTable {

    public HashMap<String, Double> symbols;

    protected SymbolsTable() {
        symbols = new HashMap<>();
    }

    private static SymbolsTable INSTANCE;

    public static SymbolsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SymbolsTable();
        }
        return INSTANCE;
    }

    public void addSymbol(String symbol, Double value) {
        symbols.put(symbol, value);
    }
    public Double getSymbol(String symbol) {
        if(symbols.containsKey(symbol)){
            return symbols.get(symbol);
        }
        return null;
    }
}
