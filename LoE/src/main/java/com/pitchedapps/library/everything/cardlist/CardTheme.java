package com.pitchedapps.library.everything.cardlist;

public class CardTheme {
    int themeCardTitle;
    int themeCardDesc;
    int themeCardAuthor;
    int themeCardButton;
    String themeCardCustomFont;
    boolean themeCardEnabled = false;

    public CardTheme() {
        //empty initiator method
    }

    public CardTheme(int title, int desc, int author, int button, String font) {
        this.themeCardTitle = title;
        this.themeCardDesc = desc;
        this.themeCardAuthor = author;
        this.themeCardButton = button;
        this.themeCardCustomFont = font;
        this.themeCardEnabled = true;
    }

    public CardTheme(int title, int desc, int author, int button) {
        this.themeCardTitle = title;
        this.themeCardDesc = desc;
        this.themeCardAuthor = author;
        this.themeCardButton = button;
        this.themeCardCustomFont = "sans-serif";
        this.themeCardEnabled = true;
    }

    public CardTheme(int title, int desc, int author, String font) {
        this.themeCardTitle = title;
        this.themeCardDesc = desc;
        this.themeCardAuthor = author;
        this.themeCardButton = author;
        this.themeCardCustomFont = font;
        this.themeCardEnabled = true;
    }

    public CardTheme(int title, int desc, int author) {
        this.themeCardTitle = title;
        this.themeCardDesc = desc;
        this.themeCardAuthor = author;
        this.themeCardButton = author;
        this.themeCardCustomFont = "sans-serif";
        this.themeCardEnabled = true;
    }

    public CardTheme(int textPrimary, int textSecondary, String font) {
        this.themeCardTitle = textPrimary;
        this.themeCardDesc = textSecondary;
        this.themeCardAuthor = textSecondary;
        this.themeCardButton = textPrimary;
        this.themeCardCustomFont = font;
        this.themeCardEnabled = true;
    }

    public CardTheme(int textPrimary, int textSecondary) {
        this.themeCardTitle = textPrimary;
        this.themeCardDesc = textSecondary;
        this.themeCardAuthor = textSecondary;
        this.themeCardButton = textPrimary;
        this.themeCardCustomFont = "sans-serif";
        this.themeCardEnabled = true;
    }
}