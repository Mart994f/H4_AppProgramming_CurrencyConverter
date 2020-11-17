package dk.zbc.currencyconverter;

import java.util.ArrayList;

public class CurrencyPresenter {

    private View view;
    private CurrencyCalculator currencyCalculator;

    public CurrencyPresenter(View view) {
        this.view = view;
        currencyCalculator = new CurrencyCalculator();
    }

    public void setBase(String base) {

    }

    public ArrayList<Valuta> getValutas() {
        return currencyCalculator.getValutas();
    }

    public void convert() {

    }

    public interface View {

    }
}
