package dk.zbc.currencyconverter;

public class Valuta {

    private String symbol;

    private String name;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Valuta(String symbol, String name) {

        this.symbol = symbol;
        this.name = name;
    }
}
