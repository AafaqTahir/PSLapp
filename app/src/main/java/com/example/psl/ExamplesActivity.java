package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExamplesActivity extends AppCompatActivity implements ExampleAdapter.ItemSelected{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ExampleModelClass> examples;
    SearchView searchView;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchView.setQuery(query, false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);
        searchView = (SearchView) findViewById(R.id.searchView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        examples = new ArrayList<ExampleModelClass>();
        setList();
        examples = sortList(examples);
        adapter = new ExampleAdapter(this, examples);
        recyclerView.setAdapter(adapter);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ((ExampleAdapter) ExamplesActivity.this.adapter).getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ((ExampleAdapter) ExamplesActivity.this.adapter).getFilter().filter(newText);
                return false;
            }
        });

    }
    private ArrayList<ExampleModelClass> sortList(ArrayList<ExampleModelClass> list){
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
    private void setList() {
        examples.add(new ExampleModelClass("Abstract"));
        examples.add(new ExampleModelClass("Painting"));
        examples.add(new ExampleModelClass("Palette Knife"));
        examples.add(new ExampleModelClass("Pastel"));
        examples.add(new ExampleModelClass("Palette"));
        examples.add(new ExampleModelClass("Battery"));
        examples.add(new ExampleModelClass("Ceiling Fan"));
        examples.add(new ExampleModelClass("Electric Iron"));
        examples.add(new ExampleModelClass("Electric Toaster"));
        examples.add(new ExampleModelClass("Freezer"));
        examples.add(new ExampleModelClass("Air Crash"));
        examples.add(new ExampleModelClass("Allama Iqbal Airport"));
        examples.add(new ExampleModelClass("Arrival"));
        examples.add(new ExampleModelClass("Baggage Cleaning"));
        examples.add(new ExampleModelClass("Quaid-e-Azam Airport"));
        examples.add(new ExampleModelClass("A"));
        examples.add(new ExampleModelClass("B"));
        examples.add(new ExampleModelClass("C"));
        examples.add(new ExampleModelClass("D"));
        examples.add(new ExampleModelClass("E"));
        examples.add(new ExampleModelClass("Crow"));
        examples.add(new ExampleModelClass("Dove"));
        examples.add(new ExampleModelClass("Falcon"));
        examples.add(new ExampleModelClass("Hawk"));
    }

    @Override
    public void onItemSelected(int index) {
        String name = examples.get(index).getName();
        Intent intent = new Intent(ExamplesActivity.this, VideoPlayerActivity.class);
        intent.putExtra("item", name);
        intent.putExtra("code", 1);
        startActivity(intent);
    }
}