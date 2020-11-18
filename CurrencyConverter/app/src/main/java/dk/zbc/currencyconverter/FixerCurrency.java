package dk.zbc.currencyconverter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FixerCurrency implements CurrencyDAO {

    private final String baseUrl = "http://data.fixer.io/api/";

    private  final String apiKey = "?access_key=27941c556c105fdacbd42ae2a8811c5c";

    public FixerCurrency() {

    }

    @Override
    public List<Valuta> getValutas(Context context) {

        String url = baseUrl + "symbols" + apiKey;
        List<Valuta> valutas = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonValutas = response.getJSONObject("symbols");
                    Iterator<String> valutaKeys = jsonValutas.keys();

                    for (int i = 0; i < jsonValutas.length(); i++) {
                        String tempKey = valutaKeys.next();
                        valutas.add(new Valuta(tempKey));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(context).add(jsonObjectRequest);

        return valutas;
    }

    @Override
    public List<Rate> getRates(String base, Context context) {

        String url = baseUrl + "latest" + apiKey;
        List<Rate> rates = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonRates = response.getJSONObject("rates");
                    Iterator<String> rateKeys = jsonRates.keys();

                    for (int i = 0; i < jsonRates.length(); i++) {
                        String tempKey = rateKeys.next();
                        rates.add(new Rate(tempKey, jsonRates.getDouble(tempKey)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(context).add(jsonObjectRequest);

        return rates;
    }
}
