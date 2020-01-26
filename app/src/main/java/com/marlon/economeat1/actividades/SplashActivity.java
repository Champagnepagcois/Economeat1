package com.marlon.economeat1.actividades;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.marlon.economeat1.MainActivity;
import com.marlon.economeat1.R;

public class SplashActivity extends AppCompatActivity {


    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SubirLatLongFirebase();
                Intent intent= new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }

    private void SubirLatLongFirebase() {
        final int duration = Toast.LENGTH_SHORT;
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                            Toast.makeText(getApplicationContext(),"Latitud: "+location.getLatitude()+"Longitud: "+ location.getLongitude(),duration).show();

                        }
                    }
                });
    }
}