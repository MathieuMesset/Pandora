package com.example.pandora;

public class StoredItem {

    private int mImageResource;
    private String mName;
    private String mDescription;

    public StoredItem(int imageResource, String name, String description) {
        mImageResource = imageResource;
        mName = name;
        mDescription = description;
    }

    public void changeName(String name){
        mName = name;
    }

    public int getImageResource(){
        return mImageResource;
    }

    public  String getName(){
        return mName;
    }

    public String getDescription(){
        return mDescription;
    }

}
