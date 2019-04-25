package com.example.pandora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);

        ArrayList<StoredItem> storedList = new ArrayList<>();
        storedList.add(new StoredItem(R.drawable.ic_android,"TestName1","TestDescription1"));
        storedList.add(new StoredItem(R.drawable.ic_monetization,"TestName2","TestDescription2"));
        storedList.add(new StoredItem(R.drawable.ic_folder,"TestName3","TestDescription3"));
        storedList.add(new StoredItem(R.drawable.ic_android,"TestName4","TestDescription4"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StoredAdapter(storedList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


}
