package com.pitchedapps.library.everything.cardlist;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitchedapps.library.everything.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cardTitle;
        TextView cardDesc;
        ImageView cardPhoto;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            cardTitle = (TextView)itemView.findViewById(R.id.card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.card_desc);
            cardPhoto = (ImageView)itemView.findViewById(R.id.card_photo);
        }
    }

    List<Card> cards;

    RVAdapter(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CardViewHolder cvh = new CardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        cardViewHolder.cardTitle.setText(cards.get(i).title);
        cardViewHolder.cardDesc.setText(cards.get(i).desc);
        cardViewHolder.cardPhoto.setImageResource(cards.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
