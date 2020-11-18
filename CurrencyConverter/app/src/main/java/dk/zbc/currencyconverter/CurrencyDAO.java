package dk.zbc.currencyconverter;

import android.content.Context;

import java.util.List;

public interface CurrencyDAO {

    public List<Valuta> getValutas(Context context);
    public List<Rate> getRates(String base, Context context);
}
