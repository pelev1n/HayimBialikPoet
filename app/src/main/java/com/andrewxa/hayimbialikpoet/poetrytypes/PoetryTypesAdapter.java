package com.andrewxa.hayimbialikpoet.poetrytypes;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;

import java.util.List;

public class PoetryTypesAdapter extends RecyclerView.Adapter<PoetryTypesAdapter.ViewHolder> {

    private List<String> poetryType;
    private PoetryOnItemClickListener poetryOnItemClickListener;
    Typeface myFont;

    public PoetryTypesAdapter(List<String> poetryType) {
        this.poetryType = poetryType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        myFont = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/shmulikclm.ttf");
        View view = inflater.inflate(R.layout.poetry_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.poetryTypeText.setTypeface(myFont);
        holder.poetryTypeText.setText(poetryType.get(position));
    }

    @Override
    public int getItemCount() {
        return this.poetryType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView poetryTypeText;
        CardView poetryContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poetryTypeText = itemView.findViewById(R.id.final_poetry_item);
            poetryContainer = itemView.findViewById(R.id.cardViewPoetry);
            poetryContainer.setOnClickListener(this::onClick);

        }

        @Override
        public void onClick(View v) {
            if (v instanceof CardView) {
                poetryOnItemClickListener.onCardViewClick(getAdapterPosition());
            }
        }
    }

    public void setPoetryOnItemClickListener(PoetryOnItemClickListener poetryOnItemClickListener) {
        this.poetryOnItemClickListener = poetryOnItemClickListener;
    }

}
