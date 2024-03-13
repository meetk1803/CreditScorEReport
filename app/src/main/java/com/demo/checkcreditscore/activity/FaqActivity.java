package com.demo.checkcreditscore.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;

public class FaqActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_faq);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        bindViews();
    }

    private void bindViews() {
        findViewById(R.id.imgBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FaqActivity.this.onBackPressed();
            }
        });
    }
}
