package com.example.heath_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edusername,edpassword;
    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edusername=findViewById(R.id.editTextTextLoginUserName);
        edpassword=findViewById(R.id.editTextTextLoginPassword);

        bt=findViewById(R.id.loginButton);
        tv=findViewById(R.id.textViewNewUser);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {

                String username=edusername.getText().toString();
                String password=edpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Enter All details",Toast.LENGTH_SHORT).show();
                }
                else{


                    if(db.login(username,password)==1){

                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedpreferences= getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString("username",username);
                        editor.apply();

                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid UserName or Password",Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });

    }

}