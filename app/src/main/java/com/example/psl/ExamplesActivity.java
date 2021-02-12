package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ExamplesActivity extends AppCompatActivity implements ExampleAdapter.ItemSelected{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ExampleModelClass> examples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        examples = new ArrayList<>();
        examples.add(new ExampleModelClass("Adobe"));
        examples.add(new ExampleModelClass("Apple"));
        examples.add(new ExampleModelClass("Artwork"));
        examples.add(new ExampleModelClass("Boss"));
        examples.add(new ExampleModelClass("Chicken"));

        adapter = new ExampleAdapter(this, examples);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(int index) {
        String name = examples.get(index).getName();
        Intent intent = new Intent(ExamplesActivity.this, VideoPlayerActivity.class);
        intent.putExtra("item", name);
        startActivity(intent);
    }
}