package com.demo.checkcreditscore.tips;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.demo.checkcreditscore.R;

public class TipsWebActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        bindViews();
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    private void bindViews() {
        int i = TipsActivity.tipsId;
        if (i == 1) {
            setContentView((int) R.layout.layout_activity_tips_1);
        } else if (i == 2) {
            setContentView((int) R.layout.layout_activity_tips_2);
            Glide.with((FragmentActivity) this).load(Integer.valueOf(R.drawable.image_tips_two)).into((ImageView) findViewById(R.id.img_top_bg));
        } else if (i == 3) {
            setContentView((int) R.layout.layout_activity_tips_3);
        } else if (i == 4) {
            setContentView((int) R.layout.layout_activity_tips_4);
        }
        findViewById(R.id.imgBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TipsWebActivity.this.onBackPressed();
            }
        });
    }
}
