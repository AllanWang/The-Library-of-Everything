package com.pitchedapps.library.everything.cardlist;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView cardPhoto;
//        TextView cardButton;


        CardViewHolder(View itemView, int i) {
            super(itemView);
            view = itemView;
            cv = (CardView)itemView.findViewById(R.id.cv);
            cardTitle = (TextView)itemView.findViewById(R.id.card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.card_desc);
            cardPhoto = (ImageView)itemView.findViewById(R.id.card_photo);
//            cardButton = (TextView)itemView.findViewById(R.id.card_button);
//            Log.d("everything", "button is " + cards.get(i).button);
//            if(!(cards.get(i).button)) {
//                ((ViewManager)cardButton.getParent()).removeView(cardButton);
//            }
            final BasicFunctions basic = new BasicFunctions(c);
            final String link = cards.get(i).link;
            Log.d("Everything", "link set");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("EVerything", "pressed, opening link");
                    basic.link(link);
                }
            });
        }
    }

    List<Card> cards;

    RVAdapter(List<Card> cards, Context c){
        this.cards = cards;
        this.c = c;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        CardViewHolder cvh = new CardViewHolder(v, i);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        cardViewHolder.cardTitle.setText(cards.get(i).title);
        cardViewHolder.cardDesc.setText(cards.get(i).desc);
        cardViewHolder.cardPhoto.setImageResource(cards.get(i).photoId);
//        if(cards.get(i).button) {
//            cardViewHolder.cardButton.setText(cards.get(i).buttonText);
//        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
