package com.example.streeteats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExploreActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_ctivity);

        // Bind Category Clicks
        View btnBurgers = findViewById(R.id.btnBurgers);
        View btnPizza = findViewById(R.id.btnPizza);
        View btnSushi = findViewById(R.id.btnSushi);

        if (btnBurgers != null) {
            btnBurgers.setOnClickListener(v -> openCategory("Burgers"));
        }

        if (btnPizza != null) {
            btnPizza.setOnClickListener(v -> openCategory("Pizza"));
        }

        if (btnSushi != null){
            btnSushi.setOnClickListener(view -> openCategory("Sushi"));
        }

        // Setup Bottom Navigation Bar in Explore Screen
        navigation = findViewById(R.id.navigation);
        if (navigation != null) {
            navigation.setSelectedItemId(R.id.nav_explore);

            navigation.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    Intent homeIntent = new Intent(ExploreActivity.this, MainActivity.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(homeIntent);
                    overridePendingTransition(0, 0);
                    return true;

                } else if (itemId == R.id.nav_explore) {
                    return true;

                } else if (itemId == R.id.nav_categories) {
                    Intent categoriesIntent = new Intent(ExploreActivity.this, ResturantListActivity.class);
                    categoriesIntent.putExtra("EXTRA_CATEGORY_NAME", "All");
                    categoriesIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(categoriesIntent);
                    overridePendingTransition(0, 0);
                    return true;
                }

                return false;
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Keep correct icon highlighted when returning to this activity
        if (navigation != null) {
            navigation.setSelectedItemId(R.id.nav_explore);
        }
    }

    private void openCategory(String categoryName) {
        Intent intent = new Intent(ExploreActivity.this, ResturantListActivity.class);
        intent.putExtra("EXTRA_CATEGORY_NAME", categoryName);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}