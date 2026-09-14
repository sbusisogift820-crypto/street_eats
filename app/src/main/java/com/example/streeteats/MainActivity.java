package com.example.streeteats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private EditText edtSearch;
    private ImageView imgRestaurant1, imgRestaurant2, imgRestaurant3, imgRestaurant4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        edtSearch = findViewById(R.id.edtSearch);
        imgRestaurant1 = findViewById(R.id.imgCategory1);
        imgRestaurant2 = findViewById(R.id.imgCategory2);
        imgRestaurant3 = findViewById(R.id.imgCategory3);

        navigation.setSelectedItemId(R.id.nav_home);

        if (imgRestaurant1 != null) {
            imgRestaurant1.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
                intent.putExtra("EXTRA_RESTAURANT_NAME", "Pholas");
                startActivity(intent);
            });
        }

        if (imgRestaurant2 != null) {
            imgRestaurant2.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
                intent.putExtra("EXTRA_RESTAURANT_NAME", "Tashas");
                startActivity(intent);
            });
        }

        if (imgRestaurant3 != null) {
            imgRestaurant3.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
                intent.putExtra("EXTRA_RESTAURANT_NAME", "Momo");
                startActivity(intent);
            });
        }

        navigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                return true;

            } else if (itemId == R.id.nav_explore) {
                Intent explorePage = new Intent(MainActivity.this, ExploreActivity.class);
                explorePage.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(explorePage);
                overridePendingTransition(0, 0);
                return true;

            } else if (itemId == R.id.nav_categories) {
                Intent categoriesPage = new Intent(MainActivity.this, ResturantListActivity.class);
                categoriesPage.putExtra("EXTRA_CATEGORY_NAME", "All");
                categoriesPage.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(categoriesPage);
                overridePendingTransition(0, 0);
                return true;
            }

            return false;
        });
    }
}