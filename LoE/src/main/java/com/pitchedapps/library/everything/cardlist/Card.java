package com.pitchedapps.library.everything.cardlist;

public class Card {
    String title;
    String desc;
    int photoId;
    String link;
    boolean buttonEnabled = false;
    boolean photoEnabled = true;

    String buttonText;
    String buttonLink;

    //yesPhoto noButton
    public Card(String title, String desc, int photoId, String link) {
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
        this.link = link;
    }

    //noPhoto noButton
    public Card(String title, String desc, String link) {
        this.title = title;
        this.desc = desc;
        this.link = link;
        this.photoEnabled = false;
    }

    //yesPhoto noButton
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