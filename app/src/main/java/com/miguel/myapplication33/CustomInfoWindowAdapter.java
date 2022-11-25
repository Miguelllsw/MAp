package com.miguel.myapplication33;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    public static final String TAG = "CustomInfoWindowAdapter";
    public LayoutInflater inflater;

    public CustomInfoWindowAdapter(MapsActivity inflater){
        this.inflater = LayoutInflater.from(inflater);
    }

    @Override
    public View getInfoContents(final Marker m) {

        View vi = inflater.inflate(R.layout.infowindow_layout, null);
        String[] info = m.getTitle().split("&");

        String url = m.getSnippet();
        ((TextView)vi.findViewById(R.id.textView)).setText(m.getTitle());
        ((TextView)vi.findViewById(R.id.textView2)).setText(m.getSnippet());
        ((ImageView)vi.findViewById(R.id.imageView2)).setImageResource(R.drawable.logo);
        ((ImageView)vi.findViewById(R.id.ivLocation)).setImageResource(R.drawable.ic_location_foreground);
        ((ImageView)vi.findViewById(R.id.ivEdificio)).setImageResource(R.drawable.ic_baseline_apartment_24);

        return vi;
    }

    @Override
    public View getInfoWindow(Marker m) {
        return null;
    }


}