package com.demo.checkcreditscore.calculatescore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.calculatescore.common.DataKeeper;

public class Result_Screen_Activity_CB extends AppCompatActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_result__screen_);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(8192, 8192);
//        new AdAdmob(this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    private void initWidgets() {
        ((TextView) findViewById(R.id.your_score)).setText(String.valueOf(DataKeeper.getInstance().getScore()));
        findViewById(R.id.see_full_report).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.see_full_report) {
            startActivity(new Intent(this, Report_Activity_CB.class));
        }
    }

    public void onResume() {
        super.onResume();
        initWidgets();
    }
}
