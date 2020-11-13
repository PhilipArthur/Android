package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderCompleteAdapter.menuViewHolder> {
    private ArrayList<ShopCart> cartList;
    private Context context;

    public OrderCompleteAdapter(ArrayList<ShopCart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public menuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_item,parent, false);
        return new menuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menuViewHolder holder, final int position) {
        final ShopCart cart = cartList.get(position);
        holder.ivFoto.setImageResource(cart.getMenuFoto());
        holder.tvFoodName.setText(cart.getMenuName());
        holder.tvFoodPrice.setText("Total: Rp. " + cart.getMenuPrice() * cart.getQuantity());
        holder.tvQuantity.setText("Quantity: " + cart.getQuantity());
        ;
    }




    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class menuViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private TextView tvFoodName, tvFoodPrice, tvQuantity;

        public menuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvFoodName = itemView.findViewById(R.id.tv_name);
            tvFoodPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
        }
    }

}

