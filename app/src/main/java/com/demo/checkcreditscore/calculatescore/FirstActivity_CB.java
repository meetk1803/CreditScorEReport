package com.demo.checkcreditscore.calculatescore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.MainActivity;
import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.calculatescore.common.DataKeeper;
import com.demo.checkcreditscore.calculatescore.common.second_btn_class;

public class FirstActivity_CB extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_first);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(8192, 8192);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
    }

    private void initWidgets() {
        findViewById(R.id.next).setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.last_negative_item_bar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setMax(7);
        seekBar.setProgress(DataKeeper.getInstance().getLastNegativeItem());
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.credit_cards_bar);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar2.setMax(6);
        seekBar2.setProgress(DataKeeper.getInstance().getCreditCards());
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.mortgages_bar);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar3.setMax(6);
        seekBar3.setProgress(DataKeeper.getInstance().getMortgages());
        SeekBar seekBar4 = (SeekBar) findViewById(R.id.retail_finances_bar);
        seekBar4.setOnSeekBarChangeListener(this);
        seekBar4.setMax(6);
        seekBar4.setProgress(DataKeeper.getInstance().getRetailFinances());
        SeekBar seekBar5 = (SeekBar) findViewById(R.id.auto_loans_bar);
        seekBar5.setOnSeekBarChangeListener(this);
        seekBar5.setMax(6);
        seekBar5.setProgress(DataKeeper.getInstance().getAutoLoans());
        SeekBar seekBar6 = (SeekBar) findViewById(R.id.student_loans_bar);
        seekBar6.setOnSeekBarChangeListener(this);
        seekBar6.setMax(6);
        seekBar6.setProgress(DataKeeper.getInstance().getStudentLoans());
        SeekBar seekBar7 = (SeekBar) findViewById(R.id.other_loans_bar);
        seekBar7.setOnSeekBarChangeListener(this);
        seekBar7.setMax(6);
        seekBar7.setProgress(DataKeeper.getInstance().getOtherLoans());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            startActivity(new Intent(this, Sec_Screen_Activity_CB.class));
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        String sb;
        String valueOf = String.valueOf(i);
        int id = seekBar.getId();
        if (id == R.id.auto_loans_bar) { /*2131296350*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f5 = valueOf;
            setText(R.id.auto_loans_value, valueOf);
            return;
        } else if (id == R.id.credit_cards_bar) { /*2131296416*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f2 = valueOf;
            setText(R.id.credit_cards_value, valueOf);
            return;
        } else if (id == R.id.last_negative_item_bar) { /*2131296530*/
            if (i == 0) {
                sb = getString(R.string.never);
            } else if (i == 7) {
                sb = getString(R.string.last_negative_item_bar_max);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(valueOf);
                sb2.append(i != 1 ? " years" : " year");
                sb = sb2.toString();
            }
            second_btn_class.f1 = sb;
            setText(R.id.last_negative_item_value, sb);
            return;
        } else if (id == R.id.mortgages_bar) { /*2131296600*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f3 = valueOf;
            setText(R.id.mortgages_value, valueOf);
            return;
        } else if (id == R.id.other_loans_bar) { /*2131296650*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f7 = valueOf;
            setText(R.id.other_loans_value, valueOf);
            return;
        } else if (id == R.id.retail_finances_bar) { /*2131296679*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f4 = valueOf;
            setText(R.id.retail_finances_value, valueOf);
            return;
        } else if (id == R.id.student_loans_bar) { /*2131296751*/
            if (i == 6) {
                valueOf = getString(R.string.credit_cards_bar_max);
            }
            second_btn_class.f6 = valueOf;
            setText(R.id.student_loans_value, valueOf);
            return;
        }
        return;
    }

    public void setText(int i, String str) {
        ((TextView) findViewById(i)).setText(str);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        if (id == R.id.auto_loans_bar) { /*2131296350*/
            DataKeeper.getInstance().setAutoLoans(seekBar.getProgress());
            return;
        } else if (id == R.id.credit_cards_bar) { /*2131296416*/
            DataKeeper.getInstance().setCreditCards(seekBar.getProgress());
            return;
        } else if (id == R.id.last_negative_item_bar) { /*2131296530*/
            DataKeeper.getInstance().setLastNegativeItem(seekBar.getProgress());
            return;
        } else if (id == R.id.mortgages_bar) { /*2131296600*/
            DataKeeper.getInstance().setMortgages(seekBar.getProgress());
            return;
        } else if (id == R.id.other_loans_bar) { /*2131296650*/
            DataKeeper.getInstance().setOtherLoans(seekBar.getProgress());
            return;
        } else if (id == R.id.retail_finances_bar) { /*2131296679*/
            DataKeeper.getInstance().setRetailFinances(seekBar.getProgress());
            return;
        } else if (id == R.id.student_loans_bar) { /*2131296751*/
            DataKeeper.getInstance().setStudentLoans(seekBar.getProgress());
            return;
        }
        return;
    }

    public void onResume() {
        super.onResume();
        initWidgets();
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
