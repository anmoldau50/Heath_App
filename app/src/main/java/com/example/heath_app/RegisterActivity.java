package com.example.heath_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edusername,edemail,edpassword1,edpassword2;
    Button bt;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edusername=findViewById(R.id.editTextBookAppUserName);
        edemail=findViewById(R.id.editTextTextBookAppAddress);
        edpassword1=findViewById(R.id.editTextTextBookAppContact);
        edpassword2=findViewById(R.id.editTextTextBookAppFees);
        bt=findViewById(R.id.registerButton);
        tv=findViewById(R.id.textViewAlreadyUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username=edusername.getText().toString();
                String email=edemail.getText().toString();
                String password1=edpassword1.getText().toString();
                String password2=edpassword2.getText().toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);

                if(validate(username)==false){
                    Toast.makeText(getApplicationContext(),"User name very Small",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(validate(email)==false){
                        Toast.makeText(getApplicationContext(),"Email not Good",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(validate(password1,password2)==false){
                            Toast.makeText(getApplicationContext(),"password and confirm password not matched",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            db.register(username,email,password1);
                            Toast.makeText(getApplicationContext(),"SuccessFull Register",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                    }
                }

            }
        });

    }

    public static boolean validate(String s){

        if(s.length()<=4){
            return false;
        }
        return true;
    }
    public static boolean validate(String password1,String password2){

        if(password1.equals(password2)){
            return true;
        }
        return false;
    }
}