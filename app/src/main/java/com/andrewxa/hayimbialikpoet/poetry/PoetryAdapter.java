package com.andrewxa.hayimbialikpoet.poetry;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.hayimbialikpoet.R;

import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder> {

    private List<String> poetryType;
    Typeface myFont;

    public PoetryAdapter(List<String> poetryType) {
        this.poetryType = poetryType;
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
        holder.poetryTypeText.setTypeface(myFont);
        holder.poetryTypeText.setText(poetryType.get(position));
    }

    @Override
    public int getItemCount() {
        return this.poetryType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView poetryTypeText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poetryTypeText = (TextView) itemView.findViewById(R.id.poetry_item);

        }
    }
}
