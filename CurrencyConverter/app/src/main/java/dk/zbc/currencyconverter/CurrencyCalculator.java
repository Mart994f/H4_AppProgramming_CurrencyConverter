package dk.zbc.currencyconverter;

import java.util.ArrayList;

public class CurrencyCalculator {

    private ArrayList<Valuta> valutas;

    public ArrayList<Valuta> getValutas() {
        return valutas;
    }

    private void setValutas(ArrayList<Valuta> valutas) {
        this.valutas = valutas;
    }

    public CurrencyCalculator() {

    }
}
