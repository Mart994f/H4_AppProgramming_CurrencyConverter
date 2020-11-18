package dk.zbc.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RateAdapter extends ArrayAdapter<Rate> {

    public RateAdapter(Context context, ArrayList<Rate> rates) {
        super(context, 0, rates);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rate_item, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.rateName);
        TextView textViewValue = convertView.findViewById(R.id.rateValue);
        ImageView imageViewFlag = convertView.findViewById(R.id.rateFlag);

        Rate currentItem = getItem(position);

        if (currentItem != null) {
            String convertedValue = Double.toString(currentItem.getConvertedValue());
            imageViewFlag.setImageResource(currentItem.getFlagId());
            textViewName.setText(currentItem.getName());
            textViewValue.setText(convertedValue);
        }

        return convertView;
    }
}
