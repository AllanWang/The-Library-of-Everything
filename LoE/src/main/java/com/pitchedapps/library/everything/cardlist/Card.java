package com.pitchedapps.library.everything.cardlist;


import android.util.Log;

public class Card {
    String title;
    String desc;
    int photoId;
    String link;
    boolean buttonEnabled;
    String buttonText;
    String buttonLink;

    public Card(String title, String desc, int photoId, String link) {
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
        this.link = link;
        this.buttonEnabled = false;
    }

    public Card(String title, String desc, int photoId, String link, String button, String buttonLink) {
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
        this.link = link;
        this.buttonEnabled = true;
        this.buttonText = button;
        this.buttonLink = buttonLink;
    }
}