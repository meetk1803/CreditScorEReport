package com.demo.checkcreditscore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.demo.checkcreditscore.Splashexitstylishapp.Activity.Splash2Activity;
import com.demo.checkcreditscore.activity.LandingActivity;
import com.demo.checkcreditscore.calculatescore.FirstActivity_CB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int idds;
    private ImageView mCreditScoreOfflineLl;
    private ImageView mLlstart;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        initView();
    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.llstart);
        this.mLlstart = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.ll_credit_score_offline);
        this.mCreditScoreOfflineLl = imageView2;
        imageView2.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_credit_score_offline) { /*2131296563*/
            this.idds = 2;
            view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.viewpush));
            startActivity(new Intent(this, FirstActivity_CB.class));
            return;
        } else if (id == R.id.llstart) { /*2131296564*/
            this.idds = 1;
            view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.viewpush));
            startActivity(new Intent(this, LandingActivity.class));
            return;
        }
        return;
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Splash2Activity.class));
    }
}
