package com.example.android.tourguideathlone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Cian on 15/05/2017.
 */

public class FoodDrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FoodDrinkFragment())
                .commit();
    }
}