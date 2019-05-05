package com.e.softwaricaassignment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ItemsAdapter;
import model.Items;

public class DashboardActivity extends AppCompatActivity {
private Button btnAddItems;
private RecyclerView recyclerView;
private FloatingActionButton fabAddItem;
List<Items>itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fabAddItem= findViewById(R.id.fabAddItem);
        recyclerView = findViewById(R.id.recyclerViewDashboard);

        readFromFile();

        ItemsAdapter itemsAdapter = new ItemsAdapter(this,itemsList);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddItemActivity.class);
                startActivity(intent);
            }
        });
    }
    private void readFromFile(){
        try {
            FileInputStream fileInputStream = openFileInput("item.txt");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";

            while ((line= bufferedReader.readLine()) !=null){
                String[] parts = line.split("->");
                itemsList.add(new Items(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (Exception e) {
            Log.d("error", "readFromFile error: "+e);
            e.printStackTrace();
        }


    }
}

