package com.demo.checkcreditscore.tips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;

public class TipsActivity extends AppCompatActivity implements View.OnClickListener {
    public static int tipsId;
    Animation animZoom;
    RelativeLayout layTip1;
    RelativeLayout layTip2;
    RelativeLayout layTip3;
    RelativeLayout layTip4;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_tips);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        bindViews();
    }

    private void bindViews() {
        this.layTip1 = (RelativeLayout) findViewById(R.id.layTip1);
        this.layTip2 = (RelativeLayout) findViewById(R.id.layTip2);
        this.layTip3 = (RelativeLayout) findViewById(R.id.layTip3);
        this.layTip4 = (RelativeLayout) findViewById(R.id.layTip4);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_zoom);
        this.animZoom = loadAnimation;
        this.layTip1.startAnimation(loadAnimation);
        this.layTip2.startAnimation(this.animZoom);
        this.layTip3.startAnimation(this.animZoom);
        this.layTip4.startAnimation(this.animZoom);
        this.layTip1.setOnClickListener(this);
        this.layTip2.setOnClickListener(this);
        this.layTip3.setOnClickListener(this);
        this.layTip4.setOnClickListener(this);
    }

    public void onClick(View view) {
        Class<TipsWebActivity> cls = TipsWebActivity.class;
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.viewpush));
        int id = view.getId();
        if (id == R.id.layTip1) { /*2131296545*/
            tipsId = 1;
            startActivity(new Intent(getApplicationContext(), cls));
            return;
        } else if (id == R.id.layTip2) { /*2131296546*/
            tipsId = 2;
            startActivity(new Intent(getApplicationContext(), cls));
            return;
        } else if (id == R.id.layTip3) { /*2131296547*/
            tipsId = 3;
            startActivity(new Intent(getApplicationContext(), cls));
            return;
        } else if (id == R.id.layTip4) { /*2131296548*/
            tipsId = 4;
            startActivity(new Intent(getApplicationContext(), cls));
            return;
        }
        return;
    }
}
