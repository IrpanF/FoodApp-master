package com.example.FoodApp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.FoodApp.Adapter.FoodListAdapter;
import com.example.FoodApp.Domain.FoodDomain;
import com.example.FoodApp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger","Satisfy your cravings with our juicy Cheese Burger Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink, it's the perfect meal for any occasion."
                ,"fast_1",15,20,120,4));
        items.add(new FoodDomain("Pizza Peperoni","Satisfy your cravings with our juicy Cheese Burger Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink, it's the perfect meal for any occasion."
                ,"fast_2",10,25,200,5));
        items.add(new FoodDomain("Vegetable Pizza","Satisfy your cravings with our juicy Cheese Burger Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink, it's the perfect meal for any occasion."
                ,"fast_3",13,30,100,4.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }
}