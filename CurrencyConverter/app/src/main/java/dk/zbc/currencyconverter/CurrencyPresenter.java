package dk.zbc.currencyconverter;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CurrencyPresenter {

    private View view;
    private String baseCurrency;
    private ArrayList<Valuta> valutas;
    private ArrayList<Rate> rates;
    private CurrencyDAO currencyDAO;
    private CurrencyCalculator currencyCalculator;

    public CurrencyPresenter(View view) {
        this.view = view;
        currencyCalculator = new CurrencyCalculator();
        currencyDAO = new FixerCurrency();
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void getValutas() {
        currencyDAO.getValutas(((android.view.View)view).getContext());
    }

    public void returnValutas(ArrayList<Valuta> valutas) {
        view.setSpinnerContent(valutas);
    }

    public void getRates() {
        currencyDAO.getRates(baseCurrency, ((android.view.View)view).getContext());
    }

    public void returnRates(ArrayList<Valuta> valutas) {
        view.setSpinnerContent(valutas);
    }

    public interface View {
        void setSpinnerContent(ArrayList<Valuta> valutas);
        void setListViewContent(ArrayList<Rate> rates);
    }
}
