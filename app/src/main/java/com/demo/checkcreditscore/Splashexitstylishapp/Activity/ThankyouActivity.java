package com.demo.checkcreditscore.Splashexitstylishapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;

public class ThankyouActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.thankyoudia);
//        new AdAdmob(this);
//        AdAdmob.FullscreenAd_Counter(this);
        ((ImageView) findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ThankyouActivity.this.finishAffinity();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
