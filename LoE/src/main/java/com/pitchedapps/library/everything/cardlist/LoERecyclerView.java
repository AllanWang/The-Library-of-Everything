package com.pitchedapps.library.everything.cardlist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LoERecyclerView {

    private Context c;
    private List<Card> cards;
    private CardTheme cardTheme;
    private RecyclerView rv;

    public LoERecyclerView(Context c) {
        this.c = c;
    }

    public void initialize(View v) {
        cards = new ArrayList<>();
        cardTheme = new CardTheme();
        rv=(RecyclerView)v;
        LinearLayoutManager llm = new LinearLayoutManager(c);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
    }

//    public void addPhotoCard(String title, String desc, int photoId, String button1Text, String button1Link) {
//        cards.add(new Card(title, desc, photoId, button1Text, button1Link));
//    }

    public void addPhotoCard(String title, String desc, int photoId, String button1Text, String button1Link, String button2Text, String button2Link) {
        cards.add(new Card(title, desc, photoId, button1Text, button1Link, button2Text, button2Link));
    }

    public void addLibCard(String title, String desc, String author, String link) {
        cards.add(new Card(title, desc, author, link));
    }

//    public void addBasicCard(String title, String desc, String button1Text, String button1Link) {
//        cards.add(new Card(title, desc, button1Text, button1Link));
//    }

    public void addBasicCard(String title, String desc, String button1Text, String button1Link, String button2Text, String button2Link) {
        cards.add(new Card(title, desc, button1Text, button1Link, button2Text, button2Link));
    }

    public void cardTheme(int title, int desc, int author, int button, String font) {
        cardTheme = new CardTheme(title, desc, author, button, font);
    }

    public void finalize() {
        RVAdapter adapter = new RVAdapter(cards, c, cardTheme);
        rv.setAdapter(adapter);
    }

}
