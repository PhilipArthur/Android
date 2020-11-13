package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private ImageView ivFoto;
    private TextView tvFoodName, tvFoodPrice;
    private EditText etQuantity;
    private Integer menuFoto;
    private String menuName, menuPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent =getIntent();

        menuFoto = intent.getIntExtra("menuFoto", 0);
        menuName = intent.getStringExtra("menuName");
        menuPrice = intent.getStringExtra("menuPrice");

        ivFoto = findViewById(R.id.iv_foto);
        tvFoodName = findViewById(R.id.tv_menuName);
        tvFoodPrice = findViewById(R.id.tv_menuPrice);
        etQuantity = findViewById(R.id.et_quantity);

        ivFoto.setImageResource(menuFoto);
        tvFoodName.setText(menuName);
        tvFoodPrice.setText("Rp. " + menuPrice);

    }

    public void order(View view) {
        String quantity = etQuantity.getText().toString();
        if(quantity.equals("")){
            Toast.makeText(this, "Cannot Be Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            ShopCart cart = new ShopCart(menuFoto, menuName, Integer.valueOf(menuPrice), Integer.valueOf(quantity));
            MyOrderActivity.addToCart(cart);
            Toast.makeText(this, "Item Has Been Added", Toast.LENGTH_SHORT).show();
        }
    }

    public void orderMore(View view){
        finish();
    }

    public void goToMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}