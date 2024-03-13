package com.demo.checkcreditscore.Splashexitstylishapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.demo.checkcreditscore.R;

public class SplashScreen extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, Splash2Activity.class));
                SplashScreen.this.finish();
            }
        }, 4000);
    }
}
