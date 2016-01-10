package com.pitchedapps.library.everything.cardlist;


import android.util.Log;

public class Card {
    String title;
    String desc;
    int photoId;
    String link;
//    boolean button;
//    String buttonText;
//    String link;

    public Card(String title, String desc, int photoId, String link) {
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
        this.link = link;
//        this.button = false;
    }

//    public Card(String title, String desc, int photoId, String button, String link) {
//        this.title = title;
//        this.desc = desc;
//        this.photoId = photoId;
//        this.button = true;
//        Log.d("everything", "card with link");
//        this.buttonText = button;
//        this.link = link;
//    }
}