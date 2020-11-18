package dk.zbc.currencyconverter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public interface CurrencyDAO {

    void getValutas(Context context);
    void getRates(String base, Context context);
    void addListener(CurrencyDAOListener listener);
    void removeListener(CurrencyDAOListener listener);
}
