package com.example.heath_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedpreferences= getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username=sharedpreferences.getString("username","").toString();

        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();

        CardView labtest,buymedicine,finddoctor,healthcare,orderdetails,logout;
        labtest=findViewById(R.id.cardLabTest);
        buymedicine=findViewById(R.id.cardBuyMedicine);
        finddoctor=findViewById(R.id.cardFindDoctor);
        healthcare=findViewById(R.id.cardHealthArticle);
        orderdetails=findViewById(R.id.cardOrderDetails);
        logout=findViewById(R.id.cardLogout);

        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });

        buymedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,BuyMedicineActivity.class));
            }
        });

        finddoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));
            }
        });

        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HealthCareActivity.class));
            }
        });


        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,OrderDetailsActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= sharedpreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(getApplicationContext(),"Logout Successfull",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });



    }
}