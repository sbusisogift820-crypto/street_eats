package com.example.streeteats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class ExploreActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnBurger, btnPizza, btnSushi;
    ImageView imgRestaurant1, imgRestaurant2, imgRestaurant3;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explore_ctivity);

        edtSearch = findViewById(R.id.edtExploreSearch);

        btnBurger = findViewById(R.id.btnBurgers);
        btnPizza = findViewById(R.id.btnPizza);
        btnSushi = findViewById(R.id.btnSushi);

        imgRestaurant1 = findViewById(R.id.imgRestaurant1);
        imgRestaurant2 = findViewById(R.id.imgRestaurant2);
        imgRestaurant3 = findViewById(R.id.imgRestaurant3);

        navigation = findViewById(R.id.navigation);


        imgRestaurant1.setOnClickListener(view -> {
            Intent intent = new Intent(ExploreActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });

        imgRestaurant2.setOnClickListener(view -> {
            Intent intent = new Intent(ExploreActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });

        imgRestaurant3.setOnClickListener(view -> {
            Intent intent = new Intent(ExploreActivity.this, DetailRestaurantActivity.class);
            startActivity(intent);
        });


        navigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if(itemId == R.id.nav_home){
                Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
                startActivity(intent);
            } else if (itemId == R.id.nav_explore) {
                return true;
            } else if (itemId == R.id.nav_categories) {
                Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
                startActivity(intent);
            }
            return false;
        });

    }
}