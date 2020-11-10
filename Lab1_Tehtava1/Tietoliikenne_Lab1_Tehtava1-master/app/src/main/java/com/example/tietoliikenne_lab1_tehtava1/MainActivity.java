package com.example.tietoliikenne_lab1_tehtava1;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private String latitude;
    private String longitude;
    private String kaupunki;
    private String maa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tekstikentta = findViewById(R.id.gpsPiste);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        final Geocoder geocoder = new Geocoder(this);

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if ( location != null){
                    latitude = String.valueOf(location.getLatitude());
                    longitude = String.valueOf(location.getLongitude());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        String address = addresses.get(0).getAddressLine(0);
                        kaupunki = addresses.get(0).getLocality();
                        maa = addresses.get(0).getCountryName();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tekstikentta.setText(latitude + " , " + longitude + "\n" +kaupunki + "\n" + maa);

                }
                else {
                    tekstikentta.setText("ei sijaintia");
                }
            }
        });
    }
}
