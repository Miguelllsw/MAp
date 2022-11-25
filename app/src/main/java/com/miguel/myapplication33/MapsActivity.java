package com.miguel.myapplication33;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       // if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//return;
  //       }



        //mMap.setMyLocationEnabled(true);




        LatLng b = new LatLng(-36.6368442, -71.9976243);
        mMap.addMarker(new MarkerOptions()
                .position(b)
                .title("Aulas B")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.oie_1822419kz19yia6__1_)).anchor(0.0f,0.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(b,18F));
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

        LatLng d = new LatLng(-36.6363575, -71.9968689);
        mMap.addMarker(new MarkerOptions()
                .position(d)
                .title("Aulas D")
                        .snippet("-/D1  -/D2  -/D3\n\n-/D4  -/D5  -/D6")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.oie_1822419kz19yia6__1_)).anchor(0.0f,0.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(d,18F));
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

        //##################################################################################################################

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Context context = getApplicationContext();
                CharSequence text = "Hello toast! ";
                int duration = Toast.LENGTH_SHORT;
                marker.showInfoWindow();
                Toast toast = Toast.makeText(context, marker.getTitle(), duration);
                toast.show();
                return false;
            }
        });

    }



}