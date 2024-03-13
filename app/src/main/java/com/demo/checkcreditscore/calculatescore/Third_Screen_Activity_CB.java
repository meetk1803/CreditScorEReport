package com.demo.checkcreditscore.calculatescore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.calculatescore.common.DataKeeper;
import com.demo.checkcreditscore.calculatescore.common.second_btn_class;

public class Third_Screen_Activity_CB extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static boolean thirdfb = false;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_third__screen_);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(8192, 8192);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    public void onResume() {
        super.onResume();
        initWidgets();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            thirdfb = true;
            startActivity(new Intent(this, Result_Screen_Activity_CB.class));
        }
    }

    private void initWidgets() {
        findViewById(R.id.next).setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.apply_credit_bar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setMax(10);
        seekBar.setProgress(DataKeeper.getInstance().getAppliedCredit());
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.first_open_oldest_active_bar);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar2.setMax(10);
        seekBar2.setProgress(DataKeeper.getInstance().getFirstOpenCredit());
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        String sb;
        String valueOf = String.valueOf(i);
        int id = seekBar.getId();
        if (id == R.id.apply_credit_bar) {
            if (i == 10) {
                valueOf = getString(R.string.apply_credit_bar_max);
            }
            second_btn_class.f10 = valueOf;
            setText(R.id.apply_credit_limits_value, valueOf);
        } else if (id == R.id.first_open_oldest_active_bar) {
            if (i == 0) {
                sb = getString(R.string.no_accounts_open);
            } else if (i == 10) {
                sb = getString(R.string.first_open_oldest_active_bar_max);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(valueOf);
                sb2.append(i != 1 ? " years" : " year");
                sb = sb2.toString();
            }
            second_btn_class.f11 = sb;
            setText(R.id.first_open_oldest_active_value, sb);
        }
    }

    public void setText(int i, String str) {
        ((TextView) findViewById(i)).setText(str);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        if (id == R.id.apply_credit_bar) {
            DataKeeper.getInstance().setAppliedCredit(seekBar.getProgress());
        } else if (id == R.id.first_open_oldest_active_bar) {
            DataKeeper.getInstance().setFirstOpenCredit(seekBar.getProgress());
        }
    }
}
