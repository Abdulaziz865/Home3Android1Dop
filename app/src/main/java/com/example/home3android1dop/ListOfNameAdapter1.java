package com.example.home3android1dop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfNameAdapter1 extends RecyclerView.Adapter<ListOfNameAdapter1.NameViewHolder> {

    public List<String> itemList;

    public ListOfNameAdapter1(List<String> item) {
        this.itemList = item;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        NameViewHolder nameViewHolder = new NameViewHolder(view);
        return nameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        holder.textView.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void onBind(String name) {
            textView.setText(name);
        }
    }

}
