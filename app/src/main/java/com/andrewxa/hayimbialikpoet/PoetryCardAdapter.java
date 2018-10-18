package com.andrewxa.hayimbialikpoet;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.model.poetrycard.PoetryCard;
import com.andrewxa.hayimbialikpoet.poetry.PoetryOnItemClickListener;

import java.util.List;

public class PoetryCardAdapter extends RecyclerView.Adapter<PoetryCardAdapter.ViewHolder>{

    private List<PoetryCard> lstPoetryCard;
    private Typeface myFont;
    private PoetryCardClickListener poetryCardClickListener;

    public PoetryCardAdapter(List<PoetryCard> lstPoetryCard) {
        this.lstPoetryCard = lstPoetryCard;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        myFont = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/shmulikclm.ttf");
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setTypeface(myFont);
        holder.textView.setText(lstPoetryCard.get(position).getTitle());
        holder.imageView.setImageResource(lstPoetryCard.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return lstPoetryCard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview_id);
            cardView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.cardview_image_id);
            textView = itemView.findViewById(R.id.cardview_title_id);


        }

        @Override
        public void onClick(View view) {
            poetryCardClickListener.onPoetryCardViewClick(getAdapterPosition());
        }
    }

    public void setpoetryCardClickListener(PoetryCardClickListener poetryCardClickListener) {
        this.poetryCardClickListener = poetryCardClickListener;
    }
}
