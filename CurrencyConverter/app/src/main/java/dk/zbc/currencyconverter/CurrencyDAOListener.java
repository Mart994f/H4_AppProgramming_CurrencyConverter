package dk.zbc.currencyconverter;

import java.util.ArrayList;

public interface CurrencyDAOListener {
    void returnValuta(ArrayList<Valuta> valutas);
    void returnRates(ArrayList<Rate> rates);
}
