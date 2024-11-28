package com.example.heath_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btLDAddToCart,btLDBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvPackageName= findViewById(R.id.textViewCartPackageName);
        tvTotalCost= findViewById(R.id.textViewCartTotalCost);
        edDetails= findViewById(R.id.editTextLDMultiLine);
        btLDAddToCart= findViewById(R.id.buttonCartBack);
        btLDBack= findViewById(R.id.buttonCartCheckout);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");

        btLDBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });


        btLDAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username= sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                Float price= Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if(db.checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Product ALready Added",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addcart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Product Added Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });


    }
}