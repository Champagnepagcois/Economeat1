package com.marlon.economeat1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Register1 extends AppCompatActivity {


    private Spinner spinner;
    private EditText editTextPhone;

    private EditText date;
    DatePickerDialog datePickerDialog;
    Button button;
    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        button = (Button)findViewById(R.id.buttonNext1);

        imageViewBack = (ImageView) findViewById(R.id.id_image_back);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goHome = new Intent(Register1.this, MainActivity.class);
                startActivity(goHome);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
                String numero = editTextPhone.getText().toString().trim();

                if (numero.isEmpty()||numero.length()<10){
                    editTextPhone.setError("Introduce un numero valido");
                    editTextPhone.requestFocus();
                    return;
                }

                String phonenumber = "+" + code + numero;


                Intent goRegister1 = new Intent(Register1.this, RegisterPhone.class);
                goRegister1.putExtra("phonenumber",phonenumber);
                startActivity(goRegister1);
            }
        });

        date = (EditText) findViewById(R.id.ET_Date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar= Calendar.getInstance();
                int year= calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                final int day= calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog= new DatePickerDialog(Register1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"-"+month+"-"+year);

                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        spinner = (Spinner) findViewById(R.id.id_spinner_countries);
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        editTextPhone = (EditText) findViewById(R.id.id_phone_register);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() !=null){
            Intent i = new Intent(this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
}

