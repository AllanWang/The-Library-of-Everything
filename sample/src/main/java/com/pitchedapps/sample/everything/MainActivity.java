package com.pitchedapps.sample.everything;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pitchedapps.library.everything.BasicFunctions;
import com.pitchedapps.library.everything.cardlist.LoERecyclerView;

/**
 * Created by 7681 on 2016-01-07.
 */
public class MainActivity extends AppCompatActivity {

    private static final String GIT_URL = "https://github.com/asdfasdfvful/The-Library-of-Everything";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //example of how to implement the cardview and how to add a new card with only one line
        LoERecyclerView lrv = new LoERecyclerView(this);
        lrv.initialize(findViewById(R.id.rv));
        lrv.addLibCard("This is a lib card", "I'm clickable and I have a ripple background", "author here", GIT_URL);
        lrv.addBasicCard("This is a basic card", "I have no photo and I'm not clickable, but I have two clickable buttons", "button 1", GIT_URL, "button 2", GIT_URL);
        lrv.addPhotoCard("This is a photo card", "<-- Here is a photo; I also have all the features of a basic card", R.drawable.pitchedapps, "button 1", GIT_URL, "button 2", GIT_URL);
        lrv.addLibCard("The Library of Everything hgfjhgfj hgfjhgfjh gfjhgfjhgfj hgfjgf jgfjgfhg", "Bits and pieces to make adding small features easier.", "asdfasdfvful (me :) )", "https://github.com/asdfasdfvful/The-Library-of-Everything");
        lrv.cardTheme(0xFFFFFFFF, 0xFFFF0000, 0xFFFF00FF, 0xFF00FFFF, "sans-serif-light");
        lrv.finalize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        BasicFunctions basic = new BasicFunctions(this); //initialize basic functions
        //example of how to implement the very basic functions
        switch (item.getItemId()) {
            case R.id.share:
                basic.share();
                break;
            case R.id.rate_mg:
                basic.openPlay("com.pitchedapps.material.glass.free");
                break;
            case R.id.sendemail:
                basic.email();
                break;
            case R.id.source:
                basic.link("https://github.com/asdfasdfvful/The-Library-of-Everything");
                break;
        }
        return true;
    }

}
