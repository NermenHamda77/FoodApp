package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.finalproject.BottomNavigationBar.Authentication.LoginActivity;
import com.example.finalproject.BottomNavigationBar.BottomNavigationActivity;

public class SplashScreen extends AppCompatActivity {


    TextView appName;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appName = findViewById(R.id.appname);
        lottie = findViewById(R.id.lottie);


        appName.animate().translationY(-1500).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME , 0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn" , false);


                if(hasLoggedIn){
                    Intent intent = new Intent(getApplicationContext(), BottomNavigationActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);
    }
}