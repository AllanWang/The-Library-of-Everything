package com.pitchedapps.library.everything.cardlist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LoERecyclerView {

    private Context c;
    private List<Card> card;
    private RecyclerView rv;

    public LoERecyclerView(Context c) {
        this.c = c;
    }

    public void initialize(View view) {
        card = new ArrayList<>();
        rv=(RecyclerView)view;
        LinearLayoutManager llm = new LinearLayoutManager(c);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
    }

    public void addCard(String title, String desc, int photoId) {
        card.add(new Card (title, desc, photoId));
    }

    public void finalize() {
        RVAdapter adapter = new RVAdapter(card);
        rv.setAdapter(adapter);
    }
}
