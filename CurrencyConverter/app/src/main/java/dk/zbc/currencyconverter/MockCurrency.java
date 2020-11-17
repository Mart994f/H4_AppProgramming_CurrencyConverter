package dk.zbc.currencyconverter;

import java.util.List;

public class MockCurrency implements CurrencyDAO {

    public MockCurrency() {

    }

    @Override
    public List<Rate> getRates(String base) {
        return null;
    }
}
