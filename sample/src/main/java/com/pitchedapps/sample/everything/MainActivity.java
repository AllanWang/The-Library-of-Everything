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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        rv=(RecyclerView)findViewById(R.id.rv);
//
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        rv.setLayoutManager(llm);
//        rv.setHasFixedSize(true);

//        initializeData();
//        initializeAdapter();

        LoERecyclerView lrv = new LoERecyclerView(this);
        lrv.initialize(findViewById(R.id.rv));
        lrv.addCard("Emma Wilson", "23 years old", com.pitchedapps.library.everything.R.drawable.emma, "https://www.google.ca");
//        lrv.addCard("Emma Wilson", "23 years old", com.pitchedapps.library.everything.R.drawable.emma, "open", "google.ca");
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
        BasicFunctions basic = new BasicFunctions(this);
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

//    public void initializeData(){
//        persons = new ArrayList<>();
//        persons.add(new Person("Emma Wilson", "23 years old", com.pitchedapps.library.everything.R.drawable.emma));
//        persons.add(new Person("Lavery Maiss", "25 years old", com.pitchedapps.library.everything.R.drawable.lavery));
//        persons.add(new Person("Lillie Watts", "35 years old", com.pitchedapps.library.everything.R.drawable.lillie));
//    }

//    public void initializeAdapter(){
//        RVAdapter adapter = new RVAdapter(persons);
//        rv.setAdapter(adapter);
//    }

}
