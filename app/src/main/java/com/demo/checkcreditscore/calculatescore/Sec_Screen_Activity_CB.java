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

public class Sec_Screen_Activity_CB extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sec__screen_);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(8192, 8192);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    private void initWidgets() {
        findViewById(R.id.next).setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.all_credit_limits_bar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setMax(100000);
        seekBar.setProgress(DataKeeper.getInstance().getCreditLimit());
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.recent_balances_bar);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar2.setMax(100000);
        seekBar2.setProgress(DataKeeper.getInstance().getRecentBalances());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            startActivity(new Intent(this, Third_Screen_Activity_CB.class));
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        String valueOf = String.valueOf(i);
        int id = seekBar.getId();
        if (id == R.id.all_credit_limits_bar) {
            if (i == 0) {
                valueOf = getString(R.string.zero_dollars).substring(1);
            } else if (i == 100000) {
                valueOf = getString(R.string.all_credit_limits_bar_max).substring(1);
            }
            second_btn_class.f8 = valueOf;
            setText(R.id.all_credit_limits_value, "$" + valueOf);
        } else if (id == R.id.recent_balances_bar) {
            if (i == 0) {
                valueOf = getString(R.string.zero_dollars).substring(1);
            } else if (i == 100000) {
                valueOf = getString(R.string.all_credit_limits_bar_max).substring(1);
            }
            second_btn_class.f9 = valueOf;
            setText(R.id.recent_balances_value, "$" + valueOf);
        }
    }

    public void setText(int i, String str) {
        ((TextView) findViewById(i)).setText(str);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        if (id == R.id.all_credit_limits_bar) {
            DataKeeper.getInstance().setCreditLimit(seekBar.getProgress());
        } else if (id == R.id.recent_balances_bar) {
            DataKeeper.getInstance().setRecentBalances(seekBar.getProgress());
        }
    }

    public void onResume() {
        super.onResume();
        initWidgets();
    }
}
