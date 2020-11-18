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

public class FixerCurrency implements CurrencyDAO {

    private final String baseUrl = "http://data.fixer.io/api/";

    private  final String apiKey = "?access_key=27941c556c105fdacbd42ae2a8811c5c";

    private  ArrayList<CurrencyDAOListener> listeners;

    private ArrayList<Valuta> valutas;

    public FixerCurrency() {
        listeners = new ArrayList<>();
    }

    public void addListener(CurrencyDAOListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CurrencyDAOListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void getValutas(Context context) {

        String url = baseUrl + "symbols" + apiKey;
        valutas = new ArrayList<>();

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

                for (CurrencyDAOListener listener : listeners) {
                    listener.returnValuta(valutas);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    @Override
    public void getRates(String base, Context context) {

        String url = baseUrl + "latest" + apiKey;
        ArrayList<Rate> rates = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Get Rates Response!");
                try {
                    JSONObject jsonRates = response.getJSONObject("rates");
                    Iterator<String> rateKeys = jsonRates.keys();

                    for (int i = 0; i < jsonRates.length(); i++) {
                        String tempKey = rateKeys.next();
                        rates.add(new Rate(tempKey, jsonRates.getDouble(tempKey), (context.getResources().getIdentifier(tempKey.toLowerCase(), "drawable", context.getPackageName()))));
                    }

                    System.out.println("Got Rates!");
                } catch (JSONException e) {
                    System.out.println("Get Rates Error!");
                    e.printStackTrace();
                }

                for (CurrencyDAOListener listener : listeners) {
                    listener.returnRates(rates);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }
}
