package dk.zbc.currencyconverter;

import android.content.Context;

import java.util.ArrayList;

public class CurrencyCalculator implements CurrencyDAOListener {

    private final CurrencyDAO currencyDAO;

    private ArrayList<CurrencyCalculatorListener> listeners;

    private double value;

    public CurrencyCalculator() {
        listeners = new ArrayList<>();
        currencyDAO = new FixerCurrency();
        currencyDAO.addListener(this);
    }

    public void addListener(CurrencyCalculatorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CurrencyCalculatorListener listener) {
        listeners.remove(listener);
    }

    public void getValuta(Context context) {
        currencyDAO.getValutas(context);
    }

    public void getRates(String baseCurrency, Context context, double value) {
        this.value = value;

        currencyDAO.getRates(baseCurrency, context);
    }

    @Override
    public void returnValuta(ArrayList<Valuta> valutas) {
        for (CurrencyCalculatorListener listener : listeners) {
            listener.setSpinnerValuta(valutas);
        }
    }

    @Override
    public void returnRates(ArrayList<Rate> rates) {
        for (Rate rate : rates) {
            rate.setConvertedValue(this.value * rate.getSpotRate());
        }

        for (CurrencyCalculatorListener listener : listeners) {
            listener.setListViewRates(rates);
        }
    }
}
