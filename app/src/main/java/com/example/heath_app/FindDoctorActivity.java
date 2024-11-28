package com.example.heath_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView familyphysician,dietician,dentist,surgeon,cardiologist,back;


        familyphysician=findViewById(R.id.cardFamilyPhysician);
        dietician=findViewById(R.id.cardDietician);
        dentist=findViewById(R.id.cardDentist);
        surgeon=findViewById(R.id.cardSurgeon);
        cardiologist=findViewById(R.id.cardCardiologist);
        back=findViewById(R.id.cardBack);

        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });
    }
}