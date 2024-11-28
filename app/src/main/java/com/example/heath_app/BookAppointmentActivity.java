package com.example.heath_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    TextView tv;
    EditText ed1,ed2,ed3,ed4;
    Button btback,btbookapptm;

    private DatePickerDialog datepicker;
    private TimePickerDialog timepicker;

    private Button dateButton,timeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appointment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv=findViewById(R.id.textViewBookAppTitle);
        ed1=findViewById(R.id.editTextBookAppUserName);
        ed2=findViewById(R.id.editTextTextBookAppAddress);
        ed3=findViewById(R.id.editTextTextBookAppContact);
        ed4=findViewById(R.id.editTextTextBookAppFees);

        dateButton=findViewById(R.id.buttonCartTimePicker);
        timeButton=findViewById(R.id.buttonCartDatePicker);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it;
        it=getIntent();
        String title=it.getStringExtra("line1");
        String name=it.getStringExtra("line2");
        String address=it.getStringExtra("line3");
        String contact=it.getStringExtra("line4");
        String fees=it.getStringExtra("line5");

        tv.setText(title);
        ed1.setText(name);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees "+fees+"/-");


        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datepicker.show();
            }
        });

        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timepicker.show();
            }
        });



        btback=findViewById(R.id.buttonBookAppBack);
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
            }
        });

        btbookapptm=findViewById(R.id.buttonBookAppointment);
        btbookapptm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH);
        int day= cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datepicker= new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datepicker.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };

        Calendar cal= Calendar.getInstance();
        int hrs= cal.get(Calendar.HOUR);
        int mins= cal.get(Calendar.MINUTE);


        int style= AlertDialog.THEME_HOLO_DARK;
        timepicker= new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);


    }
}