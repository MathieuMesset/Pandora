package com.example.pandora;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StoredAdapter extends RecyclerView.Adapter<StoredAdapter.StoredViewHolder> {

    private ArrayList<StoredItem> mStoredList;


    public static class StoredViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mName;
        public TextView mDescription;

        public StoredViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.itemName);
            mDescription = itemView.findViewById(R.id.itemDescription);
        }
    }

    public StoredAdapter(ArrayList<StoredItem> storedList){
        mStoredList = storedList;
    }


    @NonNull
    @Override
    public StoredViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stored_item, viewGroup, false);
        StoredViewHolder svh = new StoredViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StoredViewHolder storedViewHolder, int i) {

        StoredItem currentItem =mStoredList.get(i);

        storedViewHolder.mImageView.setImageResource(currentItem.getImageResource());
        storedViewHolder.mName.setText(currentItem.getName());
        storedViewHolder.mDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mStoredList.size();
    }
}
