package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.BottomNavigationBar.Authentication.LoginActivity;
import com.example.finalproject.BottomNavigationBar.Authentication.SignUpActivity;
import com.example.finalproject.BottomNavigationBar.BottomNavigationActivity;

public class StartActivity extends AppCompatActivity {

    Button signup;
    Button login;
    Button guest;
    public  static boolean iisGuest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        signup = findViewById(R.id.btn_signup_start);
        login = findViewById(R.id.btn_login_start);
        guest = findViewById(R.id.btn_guest_start);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                iisGuest = false;

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                iisGuest = false;
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BottomNavigationActivity.class);
                startActivity(intent);
                iisGuest = true;
            }
        });
    }
}