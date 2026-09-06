package com.example.streeteats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // Declare the views
    private BottomNavigationView navigation;
    private EditText edtSearch;
    private ImageView imgRestaurant1, imgRestaurant2, imgRestaurant3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge
        EdgeToEdge.enable(this);

        // Connect Java to activity_main.xml
        setContentView(R.layout.activity_main);

        // Connect the XML views to Java
        navigation = findViewById(R.id.navigation);
        edtSearch = findViewById(R.id.edtSearch);
        imgRestaurant1 = findViewById(R.id.imgCategory1);
        imgRestaurant2 = findViewById(R.id.imgCategory2);
        imgRestaurant3 = findViewById(R.id.imgCategory3);

        // Set Home as the default selected item
        navigation.setSelectedItemId(R.id.nav_home);


        imgRestaurant1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });

        imgRestaurant2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });

        imgRestaurant3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });

        // Handle Bottom Navigation clicks
        navigation.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {

                return true;

            } else if (itemId == R.id.nav_explore) {

                Intent explorepage = new Intent(MainActivity.this, ExploreActivity.class);

                startActivity(explorepage);


            } else if (itemId == R.id.nav_categories) {

                Toast.makeText(
                        MainActivity.this,
                        "Categories selected",
                        Toast.LENGTH_SHORT
                ).show();

                return true;
            }

            return false;
        });
    }
}