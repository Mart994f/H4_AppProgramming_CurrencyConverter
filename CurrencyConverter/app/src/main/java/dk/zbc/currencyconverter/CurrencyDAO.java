package dk.zbc.currencyconverter;

import java.util.List;

public interface CurrencyDAO {

    public List<Rate> getRates(String base);
}
