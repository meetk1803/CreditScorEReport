package com.demo.checkcreditscore.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;

public class BenefitsSecretActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        bindViews();
//        new AdAdmob(this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    private void bindViews() {
        int i = LandingActivity.webId;
        if (i == 1) {
            setContentView((int) R.layout.layout_activity_benefits);
        } else if (i == 2) {
            setContentView((int) R.layout.layout_activity_secrets);
        }
        findViewById(R.id.imgBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BenefitsSecretActivity.this.onBackPressed();
            }
        });
    }
}
