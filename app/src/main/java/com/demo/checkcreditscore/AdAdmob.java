//package com.demo.checkcreditscore;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.util.Log;
//import android.widget.RelativeLayout;
//import androidx.annotation.NonNull;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.interstitial.InterstitialAd;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//
//public class AdAdmob {
//    public static String BannerAdID = "/6499/example/banner";
//    private static final String Count_Ads = "Count_Ads";
//    public static String FullscreenAdID = "/6499/example/interstitial";
//    static ProgressDialog ProgressDialog;
//
//    public AdAdmob(Activity activity) {
//        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//    }
//
//    public void BannerAd(final RelativeLayout Ad_Layout, Activity activity) {
//        final AdView mAdView = new AdView(activity);
//        mAdView.setAdSize(AdSize.BANNER);
//        mAdView.setAdUnitId(BannerAdID);
//        mAdView.loadAd(new AdRequest.Builder().build());
//        Ad_Layout.addView(mAdView);
//        mAdView.setAdListener(new AdListener() {
//            public void onAdLoaded() {
//                Ad_Layout.setVisibility(0);
//                super.onAdLoaded();
//                Log.e("ddddd", "dddd");
//            }
//
//            public void onAdOpened() {
//                super.onAdOpened();
//                Ad_Layout.setVisibility(4);
//                Log.e("ddddd1", "dddd");
//            }
//
//            public void onAdFailedToLoad(LoadAdError loadAdError) {
//                super.onAdFailedToLoad(loadAdError);
//                mAdView.destroy();
//                Ad_Layout.setVisibility(4);
//                Log.e("ddddd2", "dddd" + loadAdError.getMessage());
//            }
//        });
//    }
//
//    public void FullscreenAd(final Activity activity) {
//        Ad_Popup(activity);
//        InterstitialAd.load(activity, FullscreenAdID, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
//            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                interstitialAd.show(activity);
//                AdAdmob.ProgressDialog.dismiss();
//            }
//
//            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                AdAdmob.ProgressDialog.dismiss();
//            }
//        });
//    }
//
//    public static void setCount_Ads(Context mContext, int string) {
//        mContext.getSharedPreferences(mContext.getPackageName(), 0).edit().putInt(Count_Ads, string).commit();
//    }
//
//    public static int getCount_Ads(Context mContext) {
//        return mContext.getSharedPreferences(mContext.getPackageName(), 0).getInt(Count_Ads, 1);
//    }
//
//    public static void FullscreenAd_Counter(final Activity activity) {
//        int counter_ads = getCount_Ads(activity);
//        if (counter_ads >= 3) {
//            setCount_Ads(activity, 1);
//            try {
//                Ad_Popup(activity);
//                InterstitialAd.load(activity, FullscreenAdID, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        interstitialAd.show(activity);
//                        AdAdmob.ProgressDialog.dismiss();
//                    }
//
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        AdAdmob.ProgressDialog.dismiss();
//                    }
//                });
//            } catch (Exception e) {
//            }
//        } else {
//            setCount_Ads(activity, counter_ads + 1);
//        }
//    }
//
//    private static void Ad_Popup(Context mContext) {
//        ProgressDialog show = ProgressDialog.show(mContext, "", "Ad Loading . . .", true);
//        ProgressDialog = show;
//        show.setCancelable(true);
//        ProgressDialog.show();
//    }
//}
