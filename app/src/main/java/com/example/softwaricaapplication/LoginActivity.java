package com.example.softwaricaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etusername, etpassword;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CheckUser();

        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (etusername.getText().toString().equals("Admin") && etpassword.getText().toString().equals("Admin"))
                {
                    addusernameandpassword();
                    Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username and Password", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void addusernameandpassword()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Username",etusername.getText().toString().trim());
        editor.putString("Password",etpassword.getText().toString().trim());
        editor.commit();

        Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show();
    }


    private void CheckUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String username = sharedPreferences.getString("Username", "");
        String password = sharedPreferences.getString("Password", "");

        if (username.equals("Admin") && password.equals("Admin")) {
            Toast.makeText(LoginActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "UnSuccessfull", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }
            },2000);
        }
    }



}
