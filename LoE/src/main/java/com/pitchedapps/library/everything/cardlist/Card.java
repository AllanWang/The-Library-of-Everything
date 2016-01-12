package com.pitchedapps.library.everything.cardlist;

public class Card {
    String title;
    String desc;
    String author;
    int photoId;
    String link;
    boolean buttonEnabled;
    boolean twoButtons;
    boolean photoEnabled;
    boolean authorEnabled;

    String button1Text;
    String button1Link;
    String button2Text;
    String button2Link;

    //library card, no photo or buttons
    public Card(String title, String desc, String author, String link) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.link = link;
        this.photoEnabled = false;
        this.buttonEnabled = false;
        this.authorEnabled = true;
    }

    //card with photo and one button
//    public Card(String title, String desc, int photoId, String button1Text, String button1Link) {
//        this.title = title;
//        this.desc = desc;
//        this.photoId = photoId;
//        this.button1Text = button1Text;
//        this.button1Link = button1Link;
//        this.photoEnabled = true;
//        this.buttonEnabled = true;
//        this.twoButtons = false;
//        this.authorEnabled = false;
//    }

    //card with photo and two buttons
    public Card(String title, String desc, int photoId, String button1Text, String button1Link, String button2Text, String button2Link) {
        this.title = title;
        this.desc = desc;
        this.photoId = photoId;
        this.button1Text = button1Text;
        this.button1Link = button1Link;
        this.button2Text = button2Text;
        this.button2Link = button2Link;
        this.photoEnabled = true;
        this.buttonEnabled = true;
        this.twoButtons = true;
        this.authorEnabled = false;
    }

    //card without photo and one button
//    public Card(String title, String desc, String button1Text, String button1Link) {
//        this.title = title;
//        this.desc = desc;
//        this.button1Text = button1Text;
//        this.button1Link = button1Link;
//        this.photoEnabled = false;
//        this.buttonEnabled = true;
//        this.twoButtons = false;
//        this.authorEnabled = false;
//    }

    //card with photoout and two buttons
    public Card(String title, String desc, String button1Text, String button1Link, String button2Text, String button2Link) {
        this.title = title;
        this.desc = desc;
        this.button1Text = button1Text;
        this.button1Link = button1Link;
        this.button2Text = button2Text;
        this.button2Link = button2Link;
        this.photoEnabled = false;
        this.buttonEnabled = true;
        this.twoButtons = true;
        this.authorEnabled = false;
    }
}