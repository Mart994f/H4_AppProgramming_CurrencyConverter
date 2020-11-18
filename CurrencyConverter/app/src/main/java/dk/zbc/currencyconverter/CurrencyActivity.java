package dk.zbc.currencyconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CurrencyActivity extends AppCompatActivity implements CurrencyPresenter.View {

    private CurrencyPresenter currencyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        currencyPresenter = new CurrencyPresenter(this);

    }

    public void onConvertButtonClick(View view) {
        double value;

        Valuta valuta = (Valuta) ((Spinner)findViewById(R.id.currencySpinner)).getSelectedItem();
        String stringValue = ((EditText)findViewById(R.id.currencyInput)).getText().toString();

        if (!"".equals(stringValue)) {
            value = Double.parseDouble(stringValue);

            currencyPresenter.calculateValues(valuta, value);
        }
    }

    @Override
    public void setSpinnerContent(ArrayList<Valuta> valutas) {
        Spinner spinner = findViewById(R.id.currencySpinner);

        ValutaAdapter adapter = new ValutaAdapter(this, valutas);

        spinner.setAdapter(adapter);
    }

    @Override
    public void setListViewContent(ArrayList<Rate> rates) {
        ListView listView = findViewById(R.id.currencyListView);

        RateAdapter adapter = new RateAdapter(this, rates);

        listView.setAdapter(adapter);
    }
}