package com.marlon.economeat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marlon.economeat1.SingUp.Phone;
import com.marlon.economeat1.SingUp.Register1;

public class MainActivity extends AppCompatActivity {

    TextView textViewRe,textViewFo;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*bloquea el giro de pantalla*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        textViewRe = (TextView) findViewById(R.id.id_Tv_register);
        textViewFo = (TextView) findViewById(R.id.id_Tv_forgot);
        buttonLogin = (Button) findViewById(R.id.btn_SingIn);


        textViewRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rephone = new Intent (MainActivity.this, Phone.class);
                startActivity(Rephone);
            }
        });

        textViewFo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Forgot = new Intent(MainActivity.this,ForgottenPassword.class);
                startActivity(Forgot);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(MainActivity.this, Into.class);
                startActivity(Login);
            }
        });
    }
}
