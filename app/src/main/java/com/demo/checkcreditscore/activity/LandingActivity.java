package com.demo.checkcreditscore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.MainActivity;
import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.mainmodule.CreditScoreReportActivity;
import com.demo.checkcreditscore.tips.TipsActivity;

public class LandingActivity extends AppCompatActivity {
    public static int webId;
    ImageView layBenefits;
    ImageView layReports;
    ImageView laySecrets;
    ImageView layTips;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_landing);
//        new AdAdmob(this);
//        AdAdmob.FullscreenAd_Counter(this);
        bindViews();
    }

    private void bindViews() {
        this.layReports = (ImageView) findViewById(R.id.layReports);
        this.layTips = (ImageView) findViewById(R.id.layTips);
        this.layBenefits = (ImageView) findViewById(R.id.layBenefits);
        this.laySecrets = (ImageView) findViewById(R.id.laySecrets);
        this.layReports.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(LandingActivity.this, R.anim.viewpush));
                LandingActivity landingActivity = LandingActivity.this;
                landingActivity.startActivity(new Intent(landingActivity.getApplicationContext(), CreditScoreReportActivity.class));
            }
        });
        this.layTips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(LandingActivity.this, R.anim.viewpush));
                LandingActivity landingActivity = LandingActivity.this;
                landingActivity.startActivity(new Intent(landingActivity.getApplicationContext(), TipsActivity.class));
            }
        });
        this.layBenefits.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(LandingActivity.this, R.anim.viewpush));
                LandingActivity.webId = 1;
                LandingActivity landingActivity = LandingActivity.this;
                landingActivity.startActivity(new Intent(landingActivity.getApplicationContext(), BenefitsSecretActivity.class));
            }
        });
        this.laySecrets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(LandingActivity.this, R.anim.viewpush));
                LandingActivity.webId = 2;
                LandingActivity landingActivity = LandingActivity.this;
                landingActivity.startActivity(new Intent(landingActivity.getApplicationContext(), BenefitsSecretActivity.class));
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
