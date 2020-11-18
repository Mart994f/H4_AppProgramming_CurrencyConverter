package dk.zbc.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

    }

    @Override
    public void setSpinnerContent(ArrayList<Valuta> valutas) {
        Spinner spinner = findViewById(R.id.currencySpinner);

        ArrayAdapter<Valuta> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, valutas);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerArrayAdapter.setNotifyOnChange(true);

        spinner.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void setListViewContent(ArrayList<Rate> rates) {
        ListView listView = findViewById(R.id.currencyListView);

        ArrayAdapter<Rate> listViewArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rates);
        listViewArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        listViewArrayAdapter.setNotifyOnChange(true);

        listView.setAdapter(listViewArrayAdapter);
    }
}