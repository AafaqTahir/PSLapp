package com.example.psl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowCategorie extends AppCompatActivity implements showCategoryAdapter.ItemSelected{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ExampleModelClass> categories;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_categorie);

        recyclerView = findViewById(R.id.show_category_recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        categories = new ArrayList<>();
        adapter = new showCategoryAdapter(this , categories);

        category = getIntent().getStringExtra("category");
        if(category.equals("Alphabets")){
            setAlphabetsList();
            categories = sortList(categories);
            recyclerView.setAdapter(adapter);
        }else if(category.equals("Airport")){
            setAirportList();
            categories = sortList(categories);
            recyclerView.setAdapter(adapter);
        }else if(category.equals("Appliances")){
            setAppliancesList();
            categories = sortList(categories);
            recyclerView.setAdapter(adapter);
        }else if(category.equals("Arts")){
            setArtsList();
            categories = sortList(categories);
            recyclerView.setAdapter(adapter);
        }else if(category.equals("Birds")){
            setBirdsList();
            categories = sortList(categories);
            recyclerView.setAdapter(adapter);
        }else if(category.equals("Bedroom")){
            setBedroomList();
            categories = sortList(categories);
        }else if(category.equals("Banking")){
            setBankingList();
            categories = sortList(categories);
        }else if(category.equals("Bathroom")){
            setBathroomList();
            categories = sortList(categories);
        }else if(category.equals("Beach")){
            setBeachList();
            categories = sortList(categories);
        }else if(category.equals("Computer")){
            setComputerList();
            categories = sortList(categories);
        }else if(category.equals("Colors")){
            setColorsList();
            categories = sortList(categories);
        }else if(category.equals("Drinks")){
            setDrinksList();
            categories = sortList(categories);
        }else if(category.equals("Kitchen")){
            setKitchenList();
            categories = sortList(categories);
        }else{

        }

    }

    private void setArtsList() {
        categories.add(new ExampleModelClass("Abstract"));
        categories.add(new ExampleModelClass("Painting"));
        categories.add(new ExampleModelClass("Palette Knife"));
        categories.add(new ExampleModelClass("Pastel"));
        categories.add(new ExampleModelClass("Palette"));
    }

    private void setAppliancesList() {
        categories.add(new ExampleModelClass("Battery"));
        categories.add(new ExampleModelClass("Ceiling Fan"));
        categories.add(new ExampleModelClass("Electric Iron"));
        categories.add(new ExampleModelClass("Electric Toaster"));
        categories.add(new ExampleModelClass("Freezer"));
    }

    private void setAirportList() {
        categories.add(new ExampleModelClass("Air Crash"));
        categories.add(new ExampleModelClass("Allama Iqbal Airport"));
        categories.add(new ExampleModelClass("Arrival"));
        categories.add(new ExampleModelClass("Baggage Cleaning"));
        categories.add(new ExampleModelClass("Quaid-e-Azam Airport"));
    }

    private void setAlphabetsList() {
        categories.add(new ExampleModelClass("A"));
        categories.add(new ExampleModelClass("B"));
        categories.add(new ExampleModelClass("C"));
        categories.add(new ExampleModelClass("D"));
        categories.add(new ExampleModelClass("E"));
    }

    private void setBirdsList() {
        categories.add(new ExampleModelClass("Crow"));
        categories.add(new ExampleModelClass("Dove"));
        categories.add(new ExampleModelClass("Falcon"));
        categories.add(new ExampleModelClass("Hawk"));
    }

    private void setBedroomList() {
    }

    private void setBankingList() {
    }

    private void setBathroomList() {
    }

    private void setBeachList() {
    }

    private void setComputerList() {
    }

    private void setColorsList() {
    }

    private void setDrinksList() {
    }

    private void setKitchenList() {
    }


    @Override
    public void onItemSelected(int index) {
        String name = categories.get(index).getName();
        Intent intent = new Intent(ShowCategorie.this, VideoPlayerActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("categoryItem", name);
        intent.putExtra("code" , 2);
        startActivity(intent);
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
}