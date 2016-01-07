package com.pitchedapps.library.everything;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

/**
 * Created by 7681 on 2016-01-07.
 */
public class BasicFunctions {
    private Context c;
    private static final String MARKET_URL = "https://play.google.com/store/apps/details?id=";

    public BasicFunctions(Context c) {
        this.c = c;
    }
    public void contact() {
        StringBuilder emailBuilder = new StringBuilder();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + c.getResources().getString(R.string.email_id)));
        intent.putExtra(Intent.EXTRA_SUBJECT, c.getResources().getString(R.string.email_subject));

        emailBuilder.append("Write here");
        emailBuilder.append("\n \nOS Version: ").append(System.getProperty("os.version")).append("(").append(Build.VERSION.INCREMENTAL).append(")");
        emailBuilder.append("\nOS API Level: ").append(Build.VERSION.SDK_INT);
        emailBuilder.append("\nDevice: ").append(Build.DEVICE);
        emailBuilder.append("\nManufacturer: ").append(Build.MANUFACTURER);
        emailBuilder.append("\nModel (and Product): ").append(Build.MODEL).append(" (").append(Build.PRODUCT).append(")");
        PackageInfo appInfo = null;
        try {
            appInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        assert appInfo != null;
        emailBuilder.append("\nApp Version Name: ").append(appInfo.versionName);
        emailBuilder.append("\nApp Version Code: ").append(appInfo.versionCode);

        intent.putExtra(Intent.EXTRA_TEXT, emailBuilder.toString());
        c.startActivity(Intent.createChooser(intent, (c.getResources().getString(R.string.send_title))));
    }

    public void rate() { //defaults to actual package
        openPlay(c.getApplicationContext().getPackageName());
    }
    public void openPlay (String package_name) { //in case variant is not on the play store
        Intent rate = new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_URL + package_name));
        c.startActivity(rate);
    }

    public void share() {
        share(c.getApplicationContext().getPackageName());
    }
    public void share(String package_name) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody =
                c.getResources().getString(R.string.share_one) +
                        c.getResources().getString(R.string.dev) +
                        c.getResources().getString(R.string.share_two) +
                        MARKET_URL + package_name;
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        c.startActivity(Intent.createChooser(sharingIntent, (c.getResources().getString(R.string.share_title))));
    }


}
