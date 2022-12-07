package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.loginbtn);
        username = (EditText) findViewById(R.id.usernametf);
        password = (EditText) findViewById(R.id.passwordtf);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.d("Chara",charSequence.toString()+i+"  "+i1+"  "+i2);
                try {
                    if(charSequence.charAt(i)== ' ')
                    {
                        username.setText(charSequence.subSequence(i1,i));
                    }
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,SecondScreen.class);
                if(username.getText().toString().equals("Usama") && password.getText().toString().equals("4444"))
                {
                    startActivity(i);
                }
                else{
                    Log.d("Login","Wrong Username or Password");
                    Log.d("Login",username.getText().toString()+password.getText().toString());
                }
            }
        });
     }
}