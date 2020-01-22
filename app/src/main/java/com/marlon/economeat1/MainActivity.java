package com.marlon.economeat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewRe,textViewFo;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRe = (TextView) findViewById(R.id.id_Tv_register);
        textViewRe = (TextView) findViewById(R.id.id_Tv_forgot);
        buttonLogin = (Button) findViewById(R.id.btn_SingIn);

        textViewRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rephone = new Intent (MainActivity.this, Register1.class);
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
