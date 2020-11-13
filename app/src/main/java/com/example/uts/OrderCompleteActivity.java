package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    private RecyclerView rvOrderComplete;
    private OrderCompleteAdapter orderCompleteAdapter;
    private TextView tvTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        rvOrderComplete = findViewById(R.id.rv_order_complete);
        tvTotalPrice = findViewById(R.id.tv_total_price);

        ArrayList<ShopCart> cartList = new ArrayList<>();
        cartList.addAll(MyOrderActivity.listCart);
        tvTotalPrice.setText("Total: Rp. " + getTotalPrice(cartList));

        orderCompleteAdapter = new OrderCompleteAdapter(cartList, this);
        rvOrderComplete.setLayoutManager(new LinearLayoutManager(this));
        rvOrderComplete.setAdapter(orderCompleteAdapter);
        MyOrderActivity.listCart.clear();
        MyOrderActivity.isFromOrderComplete = true;


    }

    public String getTotalPrice(ArrayList<ShopCart> listCart){
        Long totalPrice = 0L;
        for(int i = 0; i <listCart.size(); i++){
            totalPrice += (listCart.get(i).getMenuPrice() * listCart.get(i).getQuantity());
        }
        return totalPrice.toString();
    }

    public void goToMainPage(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        MyOrderActivity.isFromOrderComplete = false;

    }
}