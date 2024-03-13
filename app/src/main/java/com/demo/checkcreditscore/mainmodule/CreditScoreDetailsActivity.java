package com.demo.checkcreditscore.mainmodule;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.checkcreditscore.R;
import kotlin.jvm.internal.CharCompanionObject;

//import kotlin.jvm.internal.CharCompanionObject;

public class CreditScoreDetailsActivity extends AppCompatActivity {
    Button imgCopyLink;
    String scorePosition;
    String strDetails;
    TextView tv_title1;
    TextView tv_title2;
    TextView tvcopy;
    TextView tvdetails;
    String url1 = "https://www.cibil.com/";
    String url2 = "https://cashkumar.com/free-online-cibil-score-check";
    String url3 = "https://www.cibil.com/cibilcreditscore/";
    String url4 = "https://www.cibil.com/company-credit-report";
    String url5 = "https://www.cibil.com/xpressacquire/";
    String url6 = "https://www.cibil.com/dispute-resolution";
    String url7 = "https://www.indiaratings.co.in/";
    String url8 = "https://www.creditmantri.com/";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_credit_score_details);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        bindViews();
    }

    private void bindViews() {
        findViewById(R.id.imgBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CreditScoreDetailsActivity.this.onBackPressed();
            }
        });
        this.tv_title1 = (TextView) findViewById(R.id.tv_title1);
        this.tv_title2 = (TextView) findViewById(R.id.tv_title2);
        this.tvdetails = (TextView) findViewById(R.id.tvdetails);
        this.tvcopy = (TextView) findViewById(R.id.tvcopy);
        Button button = (Button) findViewById(R.id.imgCopyLink);
        this.imgCopyLink = button;
        button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_zoom));
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("scorePosition");
            this.scorePosition = stringExtra;
            stringExtra.hashCode();
            char c = CharCompanionObject.MAX_VALUE;
            int i = stringExtra.hashCode();
            if (i == 49) {
                if (stringExtra.equals("1")) {
                    c = 0;
                }
            } else if (i == 50) {
                if (stringExtra.equals("2")) {
                    c = 1;
                }
            } else if (i == 51) {
                if (stringExtra.equals("3")) {
                    c = 2;
                }
            } else if (i == 52) {
                if (stringExtra.equals("4")) {
                    c = 3;
                }
            } else if (i == 53) {
                if (stringExtra.equals("5")) {
                    c = 4;
                }
            } else if (i == 54) {
                if (stringExtra.equals("6")) {
                    c = 5;
                }
            } else if (i == 55) {
                if (stringExtra.equals("7")) {
                    c = 6;
                }
            } else if (i == 56) {
                if (stringExtra.equals("8")) {
                    c = 7;
                }
            } else if (i == 57) {
                if (stringExtra.equals("9")) {
                    c = 8;
                }
            }
            if (c == 0) {
                this.tv_title1.setText("Home");
                this.tv_title2.setText("Check Your CIBIL Score & Report");
                TextView textView = this.tvcopy;
                textView.setText(getResources().getString(R.string.copytext1) + " \"Credit Score\" " + getResources().getString(R.string.copytext2));
                String string = getResources().getString(R.string.details1);
                this.strDetails = string;
                setHTMLText(this.tvdetails, string);
            } else if (c == 1) {
                this.tv_title1.setText("Buy Credit Score");
                this.tv_title2.setText("Get Score Simulator With Monitoring & Maintaining Services");
                TextView textView2 = this.tvcopy;
                textView2.setText(getResources().getString(R.string.copytext1) + " \"Buy Credit Score\" " + getResources().getString(R.string.copytext2));
                String string2 = getResources().getString(R.string.details2);
                this.strDetails = string2;
                setHTMLText(this.tvdetails, string2);
            } else if (c == 2) {
                this.tv_title1.setText("Company Credit Report");
                this.tv_title2.setText("Get CIBIL With Your Company Credit Report");
                TextView textView3 = this.tvcopy;
                textView3.setText(getResources().getString(R.string.copytext1) + " \"Company Credit Report\" " + getResources().getString(R.string.copytext2));
                String string3 = getResources().getString(R.string.details3);
                this.strDetails = string3;
                setHTMLText(this.tvdetails, string3);
            } else if (c == 3) {
                this.tv_title1.setText("Calculate CIBIL Score");
                this.tv_title2.setText("Calculate Or Estimate Your CIBIL Score");
                TextView textView4 = this.tvcopy;
                textView4.setText(getResources().getString(R.string.copytext1) + " \"Calculate CIBIL Score\" " + getResources().getString(R.string.copytext2));
                String string4 = getResources().getString(R.string.details4);
                this.strDetails = string4;
                setHTMLText(this.tvdetails, string4);
            } else if (c == 4) {
                this.tv_title1.setText("Apply For Loan");
                this.tv_title2.setText("Easy To Apply For Loan");
                TextView textView5 = this.tvcopy;
                textView5.setText(getResources().getString(R.string.copytext1) + " \"Apply For Loan\" " + getResources().getString(R.string.copytext2));
                String string5 = getResources().getString(R.string.details5);
                this.strDetails = string5;
                setHTMLText(this.tvdetails, string5);
            } else if (c == 5) {
                this.tv_title1.setText("Dispute Resolution");
                this.tv_title2.setText("Consumer Dispute Resolution");
                TextView textView6 = this.tvcopy;
                textView6.setText(getResources().getString(R.string.copytext1) + " \"Dispute Resolution\" " + getResources().getString(R.string.copytext2));
                String string6 = getResources().getString(R.string.details6);
                this.strDetails = string6;
                setHTMLText(this.tvdetails, string6);
            } else if (c == 6) {
                this.tv_title1.setText("Indian Rating and Research");
                this.tv_title2.setText("Get India Rating & Research Details");
                TextView textView7 = this.tvcopy;
                textView7.setText(getResources().getString(R.string.copytext1) + " \"India Rating and Research\" " + getResources().getString(R.string.copytext2));
                String string7 = getResources().getString(R.string.details7);
                this.strDetails = string7;
                setHTMLText(this.tvdetails, string7);
            } else if (c == 7) {
                this.tv_title1.setText("Credit Mantri");
                this.tv_title2.setText("Check Your Credit Score Instantly");
                TextView textView8 = this.tvcopy;
                textView8.setText(getResources().getString(R.string.copytext1) + " Credit Mantri " + getResources().getString(R.string.copytext2));
                String string8 = getResources().getString(R.string.details8);
                this.strDetails = string8;
                setHTMLText(this.tvdetails, string8);
            } else if (c == 8) {
                this.tv_title1.setText("FAQ");
                this.tv_title2.setText("Frequently Asked Questions For Users");
            }
        }


        imgCopyLink.setOnClickListener(view -> {
            view.startAnimation(AnimationUtils.loadAnimation(CreditScoreDetailsActivity.this, R.anim.anim_zoom));

            switch (CreditScoreDetailsActivity.this.scorePosition) {
                case "1":
                    copyLink(url1);
                    break;
                case "2":
                    copyLink(url2);
                    break;
                case "3":
                    copyLink(url3);
                    break;
                case "4":
                    copyLink(url4);
                    break;
                case "5":
                    copyLink(url5);
                    break;
                case "6":
                    copyLink(url6);
                    break;
                case "7":
                    copyLink(url7);
                    break;
                case "8":
                    copyLink(url8);
                    break;
            }
        });

//        this.imgCopyLink.setOnClickListener(new View.OnClickListener() {
//            /* JADX WARNING: Can't fix incorrect switch cases order */
//            /* Code decompiled incorrectly, please refer to instructions dump. */
//            public void onClick(View r5) {
//                /*
//                    r4 = this;
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r0 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    r1 = 2130772006(0x7f010026, float:1.7147118E38)
//                    android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r0, r1)
//                    r5.startAnimation(r0)
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r0 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r0 = r0.scorePosition
//                    int r1 = r0.hashCode()
//                    switch(r1) {
//                        case 49: goto L_0x0018;
//                        case 50: goto L_0x0022;
//                        case 51: goto L_0x002c;
//                        case 52: goto L_0x0036;
//                        case 53: goto L_0x0040;
//                        case 54: goto L_0x004a;
//                        case 55: goto L_0x0054;
//                        case 56: goto L_0x005e;
//                        default: goto L_0x0017;
//                    }
//                L_0x0017:
//                    goto L_0x0068
//                L_0x0018:
//                    java.lang.String r1 = "1"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x0022
//                    r1 = 0
//                    goto L_0x006b
//                L_0x0022:
//                    java.lang.String r1 = "2"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x002c
//                    r1 = 1
//                    goto L_0x006b
//                L_0x002c:
//                    java.lang.String r1 = "3"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x0036
//                    r1 = 2
//                    goto L_0x006b
//                L_0x0036:
//                    java.lang.String r1 = "4"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x0040
//                    r1 = 3
//                    goto L_0x006b
//                L_0x0040:
//                    java.lang.String r1 = "5"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x004a
//                    r1 = 4
//                    goto L_0x006b
//                L_0x004a:
//                    java.lang.String r1 = "6"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x0054
//                    r1 = 5
//                    goto L_0x006b
//                L_0x0054:
//                    java.lang.String r1 = "7"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x005e
//                    r1 = 6
//                    goto L_0x006b
//                L_0x005e:
//                    java.lang.String r1 = "8"
//                    boolean r1 = r0.equals(r1)
//                    if (r1 == 0) goto L_0x0068
//                    r1 = 7
//                    goto L_0x006b
//                L_0x0068:
//                    r1 = 65535(0xffff, float:9.1834E-41)
//                L_0x006b:
//                    switch(r1) {
//                        case 0: goto L_0x00a7;
//                        case 1: goto L_0x009f;
//                        case 2: goto L_0x0097;
//                        case 3: goto L_0x008f;
//                        case 4: goto L_0x0087;
//                        case 5: goto L_0x007f;
//                        case 6: goto L_0x0077;
//                        case 7: goto L_0x006f;
//                        default: goto L_0x006e;
//                    }
//                L_0x006e:
//                    return
//                L_0x006f:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url8
//                    r2.copyLink(r3)
//                    return
//                L_0x0077:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url7
//                    r2.copyLink(r3)
//                    return
//                L_0x007f:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url6
//                    r2.copyLink(r3)
//                    return
//                L_0x0087:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url5
//                    r2.copyLink(r3)
//                    return
//                L_0x008f:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url2
//                    r2.copyLink(r3)
//                    return
//                L_0x0097:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url4
//                    r2.copyLink(r3)
//                    return
//                L_0x009f:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url3
//                    r2.copyLink(r3)
//                    return
//                L_0x00a7:
//                    com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity r2 = com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.this
//                    java.lang.String r3 = r2.url1
//                    r2.copyLink(r3)
//                    return
//                */
//                throw new UnsupportedOperationException("Method not decompiled: com.demo.checkcreditscore.mainmodule.CreditScoreDetailsActivity.AnonymousClass2.onClick(android.view.View):void");
//            }
//        });
    }

    public void setHTMLText(TextView textView, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setText(Html.fromHtml("" + str, 63));
            return;
        }
        textView.setText(Html.fromHtml("" + str));
    }

    public void copyLink(String str) {
        if (str.length() > 0) {
            ((ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("Copied text", str));
            Toast.makeText(getApplicationContext(), "Link Copy Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
