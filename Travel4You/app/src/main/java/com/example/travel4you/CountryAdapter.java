package com.example.travel4you;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(Context context, int resource, List<Country> countryList) {
        super(context, resource, countryList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Country country = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_view_country, parent, false);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.countryName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.countryImage);

        tv.setText(country.getName());
        iv.setImageResource(country.getImage());

        return convertView;
    }
}
