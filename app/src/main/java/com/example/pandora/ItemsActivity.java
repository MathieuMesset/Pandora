package com.example.pandora;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity {

    private ArrayList<StoredItem> mStoredList;

    private RecyclerView mRecyclerView;
    private StoredAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);

        createStoredList();
        buildRecyclerView();
        setButtons();


    }

    public void insertItem(int position){
        mStoredList.add(position,new StoredItem(R.drawable.ic_android,"New Item ","Description"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position){
        mStoredList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text){
        mStoredList.get(position).changeName(text);
        mAdapter.notifyItemChanged(position);
    }


    public void createStoredList() {
        loadData();
    }


    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StoredAdapter(mStoredList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new StoredAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position,"Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
                saveData();
            }
        });

    }

    public void setButtons(){
        buttonInsert = findViewById(R.id.insert_button);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem(0);
                saveData();
            }
        });

    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences( "shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mStoredList);
        editor.putString("task list",json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences( "shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<StoredItem>>(){}.getType();
        mStoredList = gson.fromJson(json,type);

        if(mStoredList == null) {
            mStoredList = new ArrayList<>();
        }

    }

}
