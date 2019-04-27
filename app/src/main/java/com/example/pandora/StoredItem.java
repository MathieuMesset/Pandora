package com.example.pandora;

public class StoredItem {

    private int mImageResource;
    private String mName;
    private String mDescription;
    private boolean mDelete;

    public StoredItem(int imageResource, String name, String description, boolean delete) {
        mImageResource = imageResource;
        mName = name;
        mDescription = description;
        mDelete = delete;
    }

    public void changeDeleteState() {
        if(mDelete == true){
            mDelete = false;
        }else {
            mDelete = true;
        }

        mName =toString().valueOf(mDelete);

    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public boolean getDeleteState(){
        return mDelete;
    }

}
