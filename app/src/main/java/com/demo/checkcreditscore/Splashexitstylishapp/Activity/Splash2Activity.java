package com.demo.checkcreditscore.Splashexitstylishapp.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.demo.checkcreditscore.BuildConfig;
import com.demo.checkcreditscore.Glob;
import com.demo.checkcreditscore.MainActivity;
import com.demo.checkcreditscore.R;
import com.demo.checkcreditscore.Splashexitstylishapp.TokanData.PreferencesUtils;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;

public class Splash2Activity extends AppCompatActivity implements View.OnClickListener {
    private static final int MY_REQUEST_CODE = 1;
    private static final int MY_REQUEST_CODE2 = 4;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 2000;
    public static int intScreenHeight;
    public static int intScreenWidth;
    public static ArrayList<String> listIcon2 = new ArrayList<>();
    public static ArrayList<String> listName2 = new ArrayList<>();
    public static ArrayList<String> listUrl2 = new ArrayList<>();
    private LinearLayout banner_layout;
    private Configuration config;
    int counter = 0;
    private boolean dataAvailable = false;
    private long diffMills = 0;
    boolean doubleBackToExitPressedOnce = false;
    private boolean isAlreadyCall = false;
    private boolean isBackPressed = false;
    ImageView llstart1;
    private PreferencesUtils pref;
    private SharedPreferences prefs;
    private int totalHours = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_splash2);
//        new AdAdmob(this).BannerAd((RelativeLayout) findViewById(R.id.banner), this);
//        AdAdmob.FullscreenAd_Counter(this);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        intScreenWidth = defaultDisplay.getWidth();
        intScreenHeight = defaultDisplay.getHeight();
        this.prefs = getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        this.config = getBaseContext().getResources().getConfiguration();
        this.counter = 0;
        this.pref = PreferencesUtils.getInstance(this);
        bind();
    }

    private void bind() {
        this.banner_layout = (LinearLayout) findViewById(R.id.banner_layout);
        ImageView imageView = (ImageView) findViewById(R.id.llstart1);
        this.llstart1 = imageView;
        imageView.setOnClickListener(this);
    }

    private void share() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.TEXT", Glob.app_name + " Created By :" + Glob.app_link);
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), BitmapFactory.decodeResource(getResources(), R.drawable.banner), (String) null, (String) null)));
        startActivity(Intent.createChooser(intent, "Share Image using"));
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.llstart1) {
            view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.viewpush));
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                callnext();
            } else if (i < 23) {
                callnext();
            } else if (checkAndRequestPermissions()) {
                callnext();
            }
        }
    }

    private void callnext() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @SuppressLint("WrongConstant")
    public void onBackPressed() {
        if (!isOnline()) {
            if (this.doubleBackToExitPressedOnce) {
                finish();
                super.onBackPressed();
            }
            this.doubleBackToExitPressedOnce = true;
            Snackbar make2 = Snackbar.make((View) this.banner_layout, (CharSequence) "click BACK again to exit", -1);
//            ((TextView) make2.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
            make2.show();
            Toast.makeText(this, "click BACK again to exit", 1);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Splash2Activity.this.doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else if ((TextUtils.isEmpty(this.pref.getPrefString(PreferencesUtils.EXIT_JSON)) && !isOnline()) || !this.dataAvailable) {
            if (this.doubleBackToExitPressedOnce) {
                finish();
                super.onBackPressed();
            }
            this.doubleBackToExitPressedOnce = true;
            Snackbar make = Snackbar.make((View) this.banner_layout, (CharSequence) "click BACK again to exit", -1);
//            ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
            make.show();
            Toast.makeText(this, "click BACK again to exit", 1);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Splash2Activity.this.doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else if (this.counter == 0) {
            startActivity(new Intent(this, BackActivity.class).addFlags(335544320));
            finish();
        }
    }

    public boolean checkAndRequestPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (checkSelfPermission2 != 0) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 4) {
            if (iArr[0] == 0) {
                share();
            } else if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } else if (i == REQUEST_ID_MULTIPLE_PERMISSIONS) {
            HashMap hashMap = new HashMap();
            hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
            hashMap.put("android.permission.READ_EXTERNAL_STORAGE", 0);
            if (iArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (((Integer) hashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() != 0 || ((Integer) hashMap.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() != 0) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE") || ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                        showDialogOK("Permission required for this app", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                if (i3 == -1) {
                                    Splash2Activity.this.checkAndRequestPermissions();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void showDialogOK(String str, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this).setMessage((CharSequence) str).setPositiveButton((CharSequence) "OK", onClickListener).setNegativeButton((CharSequence) "Cancel", onClickListener).create().show();
    }
}
