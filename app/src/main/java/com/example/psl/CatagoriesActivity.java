package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class CatagoriesActivity extends AppCompatActivity implements CatagorieAdapter.ItemSelected {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<CatagorieModelClass> catagories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);

        recyclerView = findViewById(R.id.CatagorierecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        catagories = new ArrayList<>();

        catagories.add(new CatagorieModelClass("Alphabets"));
        catagories.add(new CatagorieModelClass("Airport"));
        catagories.add(new CatagorieModelClass("Appliances"));
        catagories.add(new CatagorieModelClass("Arts"));
        catagories.add(new CatagorieModelClass("Birds"));
        catagories.add(new CatagorieModelClass("Bedroom"));
        catagories.add(new CatagorieModelClass("Banking"));
        catagories.add(new CatagorieModelClass("Bathroom"));
        catagories.add(new CatagorieModelClass("Beach"));
        catagories.add(new CatagorieModelClass("Computer"));
        catagories.add(new CatagorieModelClass("Colors"));
        catagories.add(new CatagorieModelClass("Drinks"));
        catagories.add(new CatagorieModelClass("Kitchen"));
        catagories = sortList(catagories);
        adapter = new CatagorieAdapter(catagories, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int index) {
        String name = catagories.get(index).getName();
        Intent intent = new Intent(CatagoriesActivity.this, ShowCategorie.class);
        intent.putExtra("category", name);
        startActivity(intent);
    }
    private ArrayList<CatagorieModelClass> sortList(ArrayList<CatagorieModelClass> list){
        int size = list.size();
        for(int i = 0; i<size-1; i++)
        {
            for (int j = i+1; j<list.size(); j++)
            {
                if(list.get(i).getName().compareTo(list.get(j).getName()) > 0)
                {
                    String temp = list.get(i).getName();
                    list.get(i).setName(list.get(j).getName());
                    list.get(j).setName(temp);
                }
            }
        }
        return list;
    }
}