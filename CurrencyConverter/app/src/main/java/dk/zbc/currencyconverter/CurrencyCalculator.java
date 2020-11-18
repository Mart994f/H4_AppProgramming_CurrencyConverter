package dk.zbc.currencyconverter;

import java.util.ArrayList;

public class CurrencyCalculator {

    private ArrayList<Rate> rates;

    private CurrencyDAO currencyDAO;

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public CurrencyCalculator() {
        currencyDAO = new FixerCurrency();
    }
}
