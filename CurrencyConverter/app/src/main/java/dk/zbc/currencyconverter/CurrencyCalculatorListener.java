package dk.zbc.currencyconverter;

import java.util.ArrayList;

public interface CurrencyCalculatorListener {
    void setSpinnerValuta(ArrayList<Valuta> valutas);
    void setListViewRates(ArrayList<Rate> rates);
}
