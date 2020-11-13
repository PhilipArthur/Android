package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private MenuAdapter adapter;
    private RecyclerView rvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        rvMenu = findViewById(R.id.rv_menu);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        ArrayList<Menu> menus = new ArrayList<>();
        setTitle("Home Menu");
        if(type.equals("snacks")){
            menus = getsnacksItem();
        }

        else if(type.equals("foods")){
            menus = getfoodsItem();
        }

        else if(type.equals("drinks")){
            menus = getdrinksItem();
        }
        adapter = new MenuAdapter(menus, this);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
    }

    private ArrayList<Menu> getdrinksItem(){
        ArrayList<Menu> drinks = new ArrayList<>();
        drinks.add(new Menu(R.drawable.mineral_water, "Air Mineral", "5000"));
        drinks.add(new Menu(R.drawable.mango, "Jus Mangga", "15000"));
        drinks.add(new Menu(R.drawable.apple, "Jus Apel", "12000"));
        drinks.add(new Menu(R.drawable.guava, "Jus Jambu", "15000"));
        drinks.add(new Menu(R.drawable.strawberry, "Jus Strawberry", "15000"));
        drinks.add(new Menu(R.drawable.dragon_fruit, "Jus Buah Naga", "18000"));
        drinks.add(new Menu(R.drawable.tomato, "Jus Tomat", "12000"));
        drinks.add(new Menu(R.drawable.lime, "Lime", "15000"));
        drinks.add(new Menu(R.drawable.lemon_juice, "Lemon", "15000"));
        drinks.add(new Menu(R.drawable.iced_tea, "Teh Manis", "3000"));
        return drinks;
    }

    private ArrayList<Menu> getfoodsItem(){
        ArrayList<Menu> foods = new ArrayList<>();
        foods.add(new Menu(R.drawable.pizza, "Pizza", "40000"));
        foods.add(new Menu(R.drawable.noodle, "Mie Goreng", "25000"));
        foods.add(new Menu(R.drawable.spaghetti, "Spaghetti", "30000"));
        foods.add(new Menu(R.drawable.fried_rice, "Nasi Goreng", "25000"));
        foods.add(new Menu(R.drawable.kwetiaw, "Kwetiaw Goreng", "25000"));
        foods.add(new Menu(R.drawable.bihun, "Bihun Goreng", "25000"));
        foods.add(new Menu(R.drawable.bakso, "Bakso Kuah", "25000"));
        foods.add(new Menu(R.drawable.sup_ayam, "Sup Ayam", "25000"));
        foods.add(new Menu(R.drawable.salad, "Salad", "25000"));
        foods.add(new Menu(R.drawable.lasagna, "Lasagna", "25000"));
        return foods;
    }

    private ArrayList<Menu> getsnacksItem(){
        ArrayList<Menu> snacks = new ArrayList<>();
        snacks.add(new Menu(R.drawable.cracker, "Crackers", "5000"));
        snacks.add(new Menu(R.drawable.kentang, "Kentang", "15000"));
        snacks.add(new Menu(R.drawable.cookie, "Cookies", "8000"));
        snacks.add(new Menu(R.drawable.wafer, "Wafer", "2000"));
        snacks.add(new Menu(R.drawable.pancake, "Pancake", "12000"));
        snacks.add(new Menu(R.drawable.peanut, "Kacang", "1000"));
        snacks.add(new Menu(R.drawable.sunflower_seed, "Kuaci", "2000"));
        snacks.add(new Menu(R.drawable.candies, "Candy", "3000"));
        snacks.add(new Menu(R.drawable.churros, "Churros", "18000"));
        snacks.add(new Menu(R.drawable.sandwich, "Sandwich", "26000"));
        return snacks;
    }


    public void goToMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}
