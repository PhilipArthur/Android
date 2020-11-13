package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    public static ArrayList<ShopCart> listCart;
    private RecyclerView rvCart;
    private ShopCartAdapter cartAdapter;
    private TextView tvNoData;
    public static TextView tvTotalPrice;
    public static boolean isFromOrderComplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        tvNoData = findViewById(R.id.tv_noData);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        if (listCart == null || listCart.size() == 0) {
            listCart = new ArrayList<>();
            tvNoData.setVisibility(View.VISIBLE);
        }
        tvTotalPrice.setText("Total: Rp. " + getTotalPrice());
        rvCart = findViewById(R.id.rv_cart);
        cartAdapter = new ShopCartAdapter(listCart, this);
        rvCart.setLayoutManager(new LinearLayoutManager(this));
        rvCart.setAdapter(cartAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isFromOrderComplete){
            tvTotalPrice.setText(getTotalPrice());
            cartAdapter.notifyDataSetChanged();
            isFromOrderComplete = false;
        }
    }

    public static void addToCart(ShopCart cart){
        if (listCart == null) listCart = new ArrayList<>();
        listCart.add(cart);

    }

    public String getTotalPrice(){
        Long totalPrice = 0L;
        for(int i = 0; i <listCart.size(); i++){
            totalPrice += (listCart.get(i).getMenuPrice() * listCart.get(i).getQuantity());
        }
        return totalPrice.toString();
    }

    public void payNow(View view) {
        Intent intent = new Intent(this, OrderCompleteActivity.class);
        startActivity(intent);
    }
}