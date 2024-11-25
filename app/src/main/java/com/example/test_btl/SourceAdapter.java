package com.example.test_btl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.SourceViewHolder> {

    private List<Source> sourceList;

    public SourceAdapter(List<Source> sourceList) {
        this.sourceList = sourceList;
    }

    @Override
    public SourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_source, parent, false);
        return new SourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourceViewHolder holder, int position) {
        Source source = sourceList.get(position);
        holder.nameTextView.setText(source.getName());
        holder.amountTextView.setText(String.valueOf(source.getAmount()));
        holder.sourceFromTextView.setText(source.getSourceFrom());
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }

    public static class SourceViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, amountTextView, sourceFromTextView;

        public SourceViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.sourceName);
            amountTextView = itemView.findViewById(R.id.sourceAmount);
            sourceFromTextView = itemView.findViewById(R.id.sourceFrom);
        }
    }
}
