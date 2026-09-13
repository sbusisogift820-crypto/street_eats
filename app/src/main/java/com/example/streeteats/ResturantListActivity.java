package com.example.streeteats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResturantListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resturant_list);

        // 1. Find and handle back button click
        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());
        }

        // 2. Handle System Window Insets for EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3. Setup Layout Views & Data
        TextView tvCategoryHeader = findViewById(R.id.tvCategoryHeader);
        RecyclerView rvRestaurants = findViewById(R.id.rvRestaurants);

        // Retrieve category passed via Intent
        String categoryName = getIntent().getStringExtra("EXTRA_CATEGORY_NAME");
        if (categoryName != null && tvCategoryHeader != null) {
            tvCategoryHeader.setText(categoryName);
        }

        List<Restaurant> restaurants = getRestaurantsForCategory(categoryName);

        if (rvRestaurants != null) {
            rvRestaurants.setLayoutManager(new LinearLayoutManager(this));

            // Attach intent logic for selecting a restaurant
            RestaurantAdapter adapter = new RestaurantAdapter(restaurants, restaurant -> {
                Intent intent = new Intent(ResturantListActivity.this, DetailRestaurantActivity.class);
                intent.putExtra("EXTRA_RESTAURANT_NAME", restaurant.getName());
                startActivity(intent);
            });

            rvRestaurants.setAdapter(adapter);
        }
    }

    private List<Restaurant> getRestaurantsForCategory(String category) {
        List<Restaurant> list = new ArrayList<>();
        if ("Burgers".equalsIgnoreCase(category)) {
            list.add(new Restaurant("Burger Palace", "Burgers • Fast Food", "★ 4.8", R.drawable.rest1));
            list.add(new Restaurant("Smash & Co.", "Burgers • American", "★ 4.5", R.drawable.rest1));
            list.add(new Restaurant("Patty Shack", "Burgers • Gourmet", "★ 4.2", R.drawable.rest1));
        } else if ("Pizza".equalsIgnoreCase(category)) {
            list.add(new Restaurant("Pizza Heaven", "Pizza • Italian", "★ 4.9", R.drawable.rest1));
            list.add(new Restaurant("Slice & Dice", "Pizza • Fast Food", "★ 4.4", R.drawable.rest1));
            list.add(new Restaurant("Mama Mia Pizzeria", "Pizza • Authentic", "★ 4.7", R.drawable.rest1));
        } else {
            list.add(new Restaurant("Street Eats Central", "Street Food • Variety", "★ 4.7", R.drawable.rest1));
            list.add(new Restaurant("Urban Bites", "Fast Casual • Mixed", "★ 4.3", R.drawable.rest1));
            list.add(new Restaurant("The Corner Grill", "Grill • BBQ", "★ 4.6", R.drawable.rest1));
        }
        return list;
    }
}