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
    private RecyclerView rv;

    public LoERecyclerView(Context c) {
        this.c = c;
    }

    public void initialize(View v) {
        cards = new ArrayList<>();
        rv=(RecyclerView)v;
        LinearLayoutManager llm = new LinearLayoutManager(c);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
    }

    public void addCard(String title, String desc, int photoId, String link) {
        cards.add(new Card(title, desc, photoId, link));
    }

    public void addCard(String title, String desc, int photoId, String link, String buttonText, String buttonLink) {
        cards.add(new Card (title, desc, photoId, link, buttonText, buttonLink));
    }

    public void finalize() {
        RVAdapter adapter = new RVAdapter(cards, c);
        rv.setAdapter(adapter);
    }
}
