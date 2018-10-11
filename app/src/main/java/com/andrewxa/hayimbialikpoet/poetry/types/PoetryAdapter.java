package com.andrewxa.hayimbialikpoet.poetry.types;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;
import com.andrewxa.hayimbialikpoet.model.Poetry;
import com.andrewxa.hayimbialikpoet.poetry.menu.PoetryMenuAdapter;
import com.andrewxa.hayimbialikpoet.poetry.menu.PoetryOnItemClickListener;

import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder>{


    private List<Poetry> poetries;
    private PoetryOnItemClickListener poetryOnItemClickListener;
    Typeface myFont;

    public PoetryAdapter(List<Poetry> poetries) {
        this.poetries = poetries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        myFont = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/shmulikclm.ttf");
        View view = inflater.inflate(R.layout.poetry_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.poetryTitle.setTypeface(myFont);
        holder.poetryTitle.setText(poetries.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return poetries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView poetryTitle;
        CardView poetryContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poetryTitle = itemView.findViewById(R.id.poetry_item);
            poetryContainer = itemView.findViewById(R.id.cardViewPoetry);
            poetryContainer.setOnClickListener(this::onClick);

        }

        @Override
        public void onClick(View view) {

        }
    }

}
