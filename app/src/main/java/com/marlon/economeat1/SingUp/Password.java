package com.marlon.economeat1.SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.marlon.economeat1.MainActivity;
import com.marlon.economeat1.R;

public class Password extends AppCompatActivity {

    ImageView imageViewBack;
    TextView textViewHome;
    EditText editTextPass1,editTextPass2;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        imageViewBack= (ImageView) findViewById(R.id.id_Iv_Back1);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone= new Intent(Password.this, Phone.class);
                startActivity(phone);
            }
        });

        textViewHome = (TextView) findViewById(R.id.id_Tv_home1);
        textViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home= new Intent(Password.this, MainActivity.class);
                startActivity(home);
            }
        });

        editTextPass1 = (EditText) findViewById(R.id.id_Et_pass11);
        editTextPass2 = (EditText) findViewById(R.id.id_Et_pass12);
        buttonNext = (Button)findViewById(R.id.id_button_next3);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Password.this,Register1.class);
                startActivity(next);
            }
        });


    }
}
