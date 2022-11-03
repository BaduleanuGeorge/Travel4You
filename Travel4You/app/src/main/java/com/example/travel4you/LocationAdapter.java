package com.example.travel4you;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, int resource, List<Location> locationList) {
        super(context, resource, locationList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Location location = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_view_locations_list, parent, false);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.locationName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.locationImage);

        tv.setText(location.getName());
        iv.setImageResource(location.getImage());

        return convertView;
    }
}
