package com.marlon.economeat1.SingUp;

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
import com.marlon.economeat1.CountryData;
import com.marlon.economeat1.Into;
import com.marlon.economeat1.MainActivity;
import com.marlon.economeat1.R;

import java.util.Calendar;

public class Register1 extends AppCompatActivity {



    private EditText editTextPhone,editTextEmail,editTextName,editTextSurname;
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

                Intent gopassword = new Intent(Register1.this, Password.class);
                startActivity(gopassword);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent into =new Intent(Register1.this, Into.class);
                startActivity(into);
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

        editTextPhone = (EditText) findViewById(R.id.id_phone_register);
        editTextName = (EditText) findViewById(R.id.id_Et_name);
        editTextSurname = (EditText) findViewById(R.id.id_Et_surname);
        editTextEmail = (EditText) findViewById(R.id.id_Et_email);


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

