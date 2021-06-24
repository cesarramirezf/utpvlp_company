package com.ubisast.utpvlp_company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.scrolling_up);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.scrolling_down);

        TextView deTextView = findViewById(R.id.deTextView);
        TextView utTextView = findViewById(R.id.utTextView);
        TextView pvlpTextView = findViewById(R.id.pvlpTextView);
        ImageView logoSplashScreen = findViewById(R.id.logoSplashScreen);

        deTextView.setAnimation(animacion2);
        utTextView.setAnimation(animacion2);
        pvlpTextView.setAnimation(animacion2);
        logoSplashScreen.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}