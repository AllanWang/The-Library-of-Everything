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
    public void onContact(String email, String subject, String title) {
        StringBuilder emailBuilder = new StringBuilder();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

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
        c.startActivity(Intent.createChooser(intent, title));
    }

    public void onRate() {
        Intent rate = new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_URL + c.getApplicationContext().getPackageName()));
        c.startActivity(rate);
    }


}
