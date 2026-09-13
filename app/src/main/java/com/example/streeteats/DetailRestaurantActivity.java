package com.example.streeteats;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_restaurant);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Match the ID from activity_detail_restaurant.xml (txtRestaurantName)
        TextView txtRestaurantName = findViewById(R.id.txtRestaurantName);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Retrieve the selected restaurant name passed from ResturantListActivity
        String restaurantName = getIntent().getStringExtra("EXTRA_RESTAURANT_NAME");

        if (restaurantName != null && txtRestaurantName != null) {
            txtRestaurantName.setText(restaurantName);
        }

        // Set back button functionality
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}