package com.marlon.economeat1.SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.marlon.economeat1.CountryData;
import com.marlon.economeat1.MainActivity;
import com.marlon.economeat1.R;

public class Phone extends AppCompatActivity {

    Button buttonNext;
    ImageView imageViewHome;
    private EditText editTextNumer;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        buttonNext = (Button) findViewById(R.id.id_button_rePhone);
        editTextNumer = (EditText) findViewById(R.id.id_phone_register);

        imageViewHome = (ImageView) findViewById(R.id.id_close_1R);
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rephone = new Intent(Phone.this, MainActivity.class);
                startActivity(Rephone);
            }
        });


        spinner = (Spinner) findViewById(R.id.id_spinner_countries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String number = editTextNumer.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextNumer.setError("Valid number is required");
                    editTextNumer.requestFocus();
                    return;
                }

                String phonenumber = "+" + code + number;

                Intent intent = new Intent(Phone.this, RegisterPhone.class);
                intent.putExtra("phonenumber", phonenumber);
                intent.putExtra("number", number);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }
}
