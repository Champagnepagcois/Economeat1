package com.marlon.economeat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageViewBack=(ImageView) findViewById(R.id.id_Iv_back2);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back= new Intent(Profile.this,Into.class);
                startActivity(back);
                finish();
            }
        });
    }
}
