package com.marlon.economeat1.actividades;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.marlon.economeat1.MainActivity;
import com.marlon.economeat1.R;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;


    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.id_progressBar1);

        compruebaConexion();
    }

    private void compruebaConexion() {

        ConnectivityManager connectivity = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info_wifi = connectivity.getNetworkInfo (ConnectivityManager.TYPE_WIFI);

        NetworkInfo info_datos = connectivity.getNetworkInfo (ConnectivityManager.TYPE_MOBILE);

        if(String.valueOf(info_wifi.getState()).equals("CONNECTED")){
            progressBar.setVisibility(View.VISIBLE);
            Splash1();
        }
        else{
            if(String.valueOf(info_datos.getState()).equals("CONNECTED")){
                progressBar.setVisibility(View.VISIBLE);
                Splash1();
            }else{

                fallo();

        }}

}




    private void fallo() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Sin conexion a internet");
        dialogo1.setMessage("¿ Deseas volver a intentar conectar a internet ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                compruebaConexion();
            }
        });
        dialogo1.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }



    public void cancelar() {
        System.exit(0);
    }

    private void Splash1() {
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