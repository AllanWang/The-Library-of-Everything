package com.pitchedapps.library.everything;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

/**
 * Created by 7681 on 2016-01-07.
 */
public class BasicFunctions {
    private Context c;
    private static final String MARKET_URL = "https://play.google.com/store/apps/details?id=";

    public BasicFunctions(Context c) {
        this.c = c;
    }

    /// email will open an email app and allow the user to send their requests with their device info
    public void email() {
        emailBase(false);
    }
    public void emailTheme() {
        emailBase(true);
    }
    private void emailBase(boolean theme) {
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

        if (theme) {
            Intent cm = c.getPackageManager().getLaunchIntentForPackage("org.cyanogenmod.theme.chooser");
            Intent cyngn = c.getPackageManager().getLaunchIntentForPackage("com.cyngn.theme.chooser");
            Intent rro = c.getPackageManager().getLaunchIntentForPackage("com.lovejoy777.rroandlayersmanager");
            if (cm != null) {
                emailBuilder.append("\n\nCM theme chooser is installed.");
            }
            if (cyngn != null) {
                emailBuilder.append("\n\nCyanogenOS theme chooser is installed.");
            }
            if (rro != null) {
                emailBuilder.append("\n\nLayers theme engine is installed.");
            }
        }

        intent.putExtra(Intent.EXTRA_TEXT, emailBuilder.toString());
        c.startActivity(Intent.createChooser(intent, (c.getResources().getString(R.string.send_title))));
    }

    public void rate() { //defaults to actual package
        openPlay(c.getApplicationContext().getPackageName());
    }
    public void openPlay (String package_name) { //in case variant is not on the play store
        c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_URL + package_name)));
    }
    public void link (String url) {
        c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

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

    public void wip() {
        Toast.makeText(c.getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
    }


}
