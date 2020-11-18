package dk.zbc.currencyconverter;

import android.app.Activity;

import java.util.ArrayList;

public class CurrencyPresenter implements CurrencyCalculatorListener{

    private final View view;
    private final CurrencyCalculator currencyCalculator;

    public CurrencyPresenter(View view) {
        this.view = view;
        currencyCalculator = new CurrencyCalculator();
        currencyCalculator.addListener(this);
        currencyCalculator.getValuta((Activity) this.view);
    }

    @Override
    public void setSpinnerValuta(ArrayList<Valuta> valutas) {
        view.setSpinnerContent(valutas);
    }

    @Override
    public void setListViewRates(ArrayList<Rate> rates) {
        view.setListViewContent(rates);
    }

    public void calculateValues(Valuta valuta, double value) {
        currencyCalculator.getRates(valuta.getName(), (Activity) view, value);
    }

    public interface View {
        void setSpinnerContent(ArrayList<Valuta> valutas);
        void setListViewContent(ArrayList<Rate> rates);
    }
}
