package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTopup(View view) {

    }

    public void goToFoods(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("type", "foods");
        startActivity(intent);
    }

    public void goToSnacks(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("type", "snacks");
        startActivity(intent);
    }

    public void goToDrinks(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("type", "drinks");
        startActivity(intent);
    }

    public void goToMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}