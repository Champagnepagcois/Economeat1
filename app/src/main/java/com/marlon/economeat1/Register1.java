package com.marlon.economeat1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Register1 extends AppCompatActivity {


    private EditText date;
    DatePickerDialog datePickerDialog;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        button = (Button)findViewById(R.id.buttonNext1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRegister1 = new Intent(Register1.this, RegisterPhone.class);
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




    }

}

