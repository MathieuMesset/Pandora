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

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position, ImageView deleteImage);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class StoredViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mName;
        public TextView mDescription;
        public ImageView mDeleteImage;
        public boolean mDeleteState;

        public StoredViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.itemName);
            mDescription = itemView.findViewById(R.id.itemDescription);
            mDeleteImage = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position, mDeleteImage);
                        }
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

        }
    }

    public StoredAdapter(ArrayList<StoredItem> storedList) {
        mStoredList = storedList;
    }


    @NonNull
    @Override
    public StoredViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stored_item, viewGroup, false);
        StoredViewHolder svh = new StoredViewHolder(v, mListener);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StoredViewHolder storedViewHolder, int i) {

        StoredItem currentItem = mStoredList.get(i);

        storedViewHolder.mImageView.setImageResource(currentItem.getImageResource());
        storedViewHolder.mName.setText(currentItem.getName());
        storedViewHolder.mDescription.setText(currentItem.getDescription());
        storedViewHolder.mDeleteState = (currentItem.getDeleteState());
        if (storedViewHolder.mDeleteState == true){
            storedViewHolder.mDeleteImage.setVisibility(View.VISIBLE);
        }else if (storedViewHolder.mDeleteState == false){
            storedViewHolder.mDeleteImage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mStoredList.size();
    }
}
