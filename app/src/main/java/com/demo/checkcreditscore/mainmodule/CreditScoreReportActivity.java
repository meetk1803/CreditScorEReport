package com.demo.checkcreditscore.mainmodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.activity.FaqActivity;

public class CreditScoreReportActivity extends AppCompatActivity implements View.OnClickListener {
    Animation animZoom;
    RelativeLayout lay1;
    RelativeLayout lay2;
    RelativeLayout lay3;
    RelativeLayout lay4;
    RelativeLayout lay5;
    RelativeLayout lay6;
    RelativeLayout lay7;
    RelativeLayout lay8;
    RelativeLayout lay9;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_credit_score_report);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        bindViews();
    }

    private void bindViews() {
        this.lay1 = (RelativeLayout) findViewById(R.id.lay1);
        this.lay2 = (RelativeLayout) findViewById(R.id.lay2);
        this.lay3 = (RelativeLayout) findViewById(R.id.lay3);
        this.lay4 = (RelativeLayout) findViewById(R.id.lay4);
        this.lay5 = (RelativeLayout) findViewById(R.id.lay5);
        this.lay6 = (RelativeLayout) findViewById(R.id.lay6);
        this.lay7 = (RelativeLayout) findViewById(R.id.lay7);
        this.lay8 = (RelativeLayout) findViewById(R.id.lay8);
        this.lay9 = (RelativeLayout) findViewById(R.id.lay9);
        this.lay1.setOnClickListener(this);
        this.lay2.setOnClickListener(this);
        this.lay3.setOnClickListener(this);
        this.lay4.setOnClickListener(this);
        this.lay5.setOnClickListener(this);
        this.lay6.setOnClickListener(this);
        this.lay7.setOnClickListener(this);
        this.lay8.setOnClickListener(this);
        this.lay9.setOnClickListener(this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_zoom);
        this.animZoom = loadAnimation;
        this.lay1.startAnimation(loadAnimation);
        this.lay2.startAnimation(this.animZoom);
        this.lay3.startAnimation(this.animZoom);
        this.lay4.startAnimation(this.animZoom);
        this.lay5.startAnimation(this.animZoom);
        this.lay6.startAnimation(this.animZoom);
        this.lay7.startAnimation(this.animZoom);
        this.lay8.startAnimation(this.animZoom);
        this.lay9.startAnimation(this.animZoom);
    }

    public void onClick(View view) {
        Class<CreditScoreDetailsActivity> cls = CreditScoreDetailsActivity.class;
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.viewpush));
        int id = view.getId();
        if (id == R.id.lay1) { /*2131296532*/
            Intent intent = new Intent(getApplicationContext(), cls);
            intent.putExtra("scorePosition", "1");
            startActivity(intent);
            return;
        } else if (id == R.id.lay2) { /*2131296533*/
            Intent intent2 = new Intent(getApplicationContext(), cls);
            intent2.putExtra("scorePosition", "2");
            startActivity(intent2);
            return;
        } else if (id == R.id.lay3) { /*2131296534*/
            Intent intent3 = new Intent(getApplicationContext(), cls);
            intent3.putExtra("scorePosition", "3");
            startActivity(intent3);
            return;
        } else if (id == R.id.lay4) { /*2131296535*/
            Intent intent4 = new Intent(getApplicationContext(), cls);
            intent4.putExtra("scorePosition", "4");
            startActivity(intent4);
            return;
        } else if (id == R.id.lay5) { /*2131296536*/
            Intent intent5 = new Intent(getApplicationContext(), cls);
            intent5.putExtra("scorePosition", "5");
            startActivity(intent5);
            return;
        } else if (id == R.id.lay6) { /*2131296537*/
            Intent intent6 = new Intent(getApplicationContext(), cls);
            intent6.putExtra("scorePosition", "6");
            startActivity(intent6);
            return;
        } else if (id == R.id.lay7) { /*2131296538*/
            Intent intent7 = new Intent(getApplicationContext(), cls);
            intent7.putExtra("scorePosition", "7");
            startActivity(intent7);
            return;
        } else if (id == R.id.lay8) { /*2131296539*/
            Intent intent8 = new Intent(getApplicationContext(), cls);
            intent8.putExtra("scorePosition", "8");
            startActivity(intent8);
            return;
        } else if (id == R.id.lay9) { /*2131296540*/
            startActivity(new Intent(getApplicationContext(), FaqActivity.class));
            return;
        }
        return;
    }
}
