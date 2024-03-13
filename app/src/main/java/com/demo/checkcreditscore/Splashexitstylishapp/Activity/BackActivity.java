package com.demo.checkcreditscore.Splashexitstylishapp.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.Splashexitstylishapp.View.ExpandableGridView;

public class BackActivity extends AppCompatActivity {
    ExpandableGridView app_list;
    ExpandableGridView app_list1;
    private TextView btn_no;
    private TextView btn_yes;
    /* access modifiers changed from: private */
    public Dialog dialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_back);
        getWindow().setFlags(1024, 1024);
        ExpandableGridView expandableGridView = (ExpandableGridView) findViewById(R.id.gvAppList);
        this.app_list = expandableGridView;
        expandableGridView.setExpanded(true);
        ExpandableGridView expandableGridView2 = (ExpandableGridView) findViewById(R.id.gvAppList1);
        this.app_list1 = expandableGridView2;
        expandableGridView2.setExpanded(true);
    }

    public void moreapp() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=Stylist+Manager+App")));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "You don't have Google Play installed", 1).show();
        }
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void onBackPressed() {
        super.onBackPressed();
        opendialogexit();
    }

    private void opendialogexit() {
        @SuppressLint("ResourceType") Dialog dialog2 = new Dialog(this, 16973840);
        this.dialog = dialog2;
        dialog2.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.customdailog2);
        this.dialog.setCancelable(false);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((ImageView) this.dialog.findViewById(R.id.btn_no)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BackActivity.this.moreapp();
                BackActivity.this.dialog.dismiss();
            }
        });
        ((ImageView) this.dialog.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BackActivity.this.setResult(0);
                BackActivity.this.dialog.dismiss();
                BackActivity.this.startActivity(new Intent(BackActivity.this, ThankyouActivity.class));
                BackActivity.this.finish();
            }
        });
        this.dialog.show();
    }
}
