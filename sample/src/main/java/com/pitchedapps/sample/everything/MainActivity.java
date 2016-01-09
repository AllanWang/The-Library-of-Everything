package com.pitchedapps.sample.everything;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pitchedapps.library.everything.BasicFunctions;

/**
 * Created by 7681 on 2016-01-07.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        BasicFunctions basic = new BasicFunctions(this);
        switch (item.getItemId()) {
            case R.id.share:
                basic.share();
                break;
            case R.id.rate_mg:
                basic.openPlay("com.pitchedapps.material.glass.free");
                break;
            case R.id.sendemail:
                basic.contact();
                break;
        }
        return true;
    }

}
