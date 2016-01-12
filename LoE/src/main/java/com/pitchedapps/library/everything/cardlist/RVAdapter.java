package com.pitchedapps.library.everything.cardlist;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pitchedapps.library.everything.BasicFunctions;
import com.pitchedapps.library.everything.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {
    private Context c;
    public View view;

    public class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cardTitle;
        TextView cardDesc;
        TextView cardAuthor;
        ImageView cardPhoto;
        RelativeLayout cardLayout;
        LinearLayout cardTopLayout;
        RelativeLayout buttonLayout;
        TextView card1Button;
        TextView card2Button;

        CardViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            cv = (CardView)itemView.findViewById(R.id.cv);
            cardTitle = (TextView)itemView.findViewById(R.id.card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.card_desc);
            cardAuthor = (TextView)itemView.findViewById(R.id.card_author);
            cardPhoto = (ImageView)itemView.findViewById(R.id.card_photo);
            cardLayout = (RelativeLayout)itemView.findViewById(R.id.card_layout);
            cardTopLayout = (LinearLayout)itemView.findViewById(R.id.top_layout);
            buttonLayout = (RelativeLayout)itemView.findViewById(R.id.button_layout);
            card1Button = (TextView)itemView.findViewById(R.id.card_button_1);
            card2Button = (TextView)itemView.findViewById(R.id.card_button_2);
        }
    }

    List<Card> cards;
    CardTheme cardTheme;

    RVAdapter(List<Card> cards, Context c, CardTheme cardTheme){
        this.cards = cards;
        this.cardTheme = cardTheme;
        this.c = c;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        CardViewHolder cvh = new CardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        cardViewHolder.cardTitle.setText(cards.get(i).title);
        cardViewHolder.cardDesc.setText(cards.get(i).desc);
        if(cards.get(i).photoEnabled) {
            cardViewHolder.cardPhoto.setImageResource(cards.get(i).photoId);
        } else {
            cardViewHolder.cardLayout.removeView(cardViewHolder.cardPhoto);
        }
        final BasicFunctions basic = new BasicFunctions(c);
        if(cards.get(i).buttonEnabled) {
            final String button1Link = cards.get(i).button1Link;
            final String button2Link = cards.get(i).button2Link;
            cardViewHolder.cardDesc.setPadding(0, 0, 0, cardViewHolder.cardLayout.getPaddingBottom()/3); //changes bottom padding as it will be done in buttons
            cardViewHolder.cardLayout.setPadding(cardViewHolder.cardLayout.getPaddingLeft(), cardViewHolder.cardLayout.getPaddingTop(), cardViewHolder.cardLayout.getPaddingRight()/3, cardViewHolder.cardLayout.getPaddingBottom()/3); //changes bottom padding as it will be done in buttons
            cardViewHolder.card1Button.setText(cards.get(i).button1Text);
            cardViewHolder.card1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    basic.link(button1Link);
                }

            });
            cardViewHolder.card2Button.setText(cards.get(i).button2Text);
            cardViewHolder.card2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    basic.link(button2Link);
                }

            });
        } else {
            cardViewHolder.cardLayout.removeView(cardViewHolder.buttonLayout);

        }
        if(cards.get(i).authorEnabled) {
            cardViewHolder.cardAuthor.setText(cards.get(i).author);
            cardViewHolder.cardLayout.setBackground(ContextCompat.getDrawable(c, R.drawable.card_ripple));
            final String link = cards.get(i).link;
            cardViewHolder.cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    basic.link(link);
                }

            });
        } else {
            cardViewHolder.cardTopLayout.removeView(cardViewHolder.cardAuthor);
        }
        if(cardTheme.themeCardEnabled) {
            cardViewHolder.cardTitle.setTextColor(cardTheme.themeCardTitle);
            cardViewHolder.cardTitle.setTypeface(Typeface.create(cardTheme.themeCardCustomFont, Typeface.NORMAL));
            cardViewHolder.cardDesc.setTextColor(cardTheme.themeCardDesc);
            cardViewHolder.cardDesc.setTypeface(Typeface.create(cardTheme.themeCardCustomFont, Typeface.NORMAL));
            if(cards.get(i).authorEnabled) {
                cardViewHolder.cardAuthor.setTextColor(cardTheme.themeCardAuthor);
                cardViewHolder.cardAuthor.setTypeface(Typeface.create(cardTheme.themeCardCustomFont, Typeface.NORMAL));
            }
            if(cards.get(i).buttonEnabled) {
                cardViewHolder.card1Button.setTextColor(cardTheme.themeCardButton);
                cardViewHolder.card1Button.setTypeface(Typeface.create(cardTheme.themeCardCustomFont, Typeface.NORMAL));
                cardViewHolder.card2Button.setTextColor(cardTheme.themeCardButton);
                cardViewHolder.card2Button.setTypeface(Typeface.create(cardTheme.themeCardCustomFont, Typeface.NORMAL));
            }
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

}
