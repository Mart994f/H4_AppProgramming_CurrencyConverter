package dk.zbc.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

    public void setSpinnerContent(ArrayList<Valuta> spinnerContent) {
        Spinner spinner = (Spinner) findViewById(R.id.currencySpinner);

        ArrayAdapter<Valuta> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerContent);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}