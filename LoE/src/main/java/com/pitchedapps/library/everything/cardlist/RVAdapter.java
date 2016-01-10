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

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView cardTitle;
        TextView cardDesc;
        ImageView cardPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            cardTitle = (TextView)itemView.findViewById(R.id.card_title);
            cardDesc = (TextView)itemView.findViewById(R.id.card_desc);
            cardPhoto = (ImageView)itemView.findViewById(R.id.card_photo);
        }
    }

    List<Card> card;

    RVAdapter(List<Card> card){
        this.card = card;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.cardTitle.setText(card.get(i).title);
        personViewHolder.cardDesc.setText(card.get(i).desc);
        personViewHolder.cardPhoto.setImageResource(card.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return card.size();
    }
}
