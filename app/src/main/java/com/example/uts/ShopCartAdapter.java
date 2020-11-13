package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.menuViewHolder> {
    private ArrayList<ShopCart> cartList;
    private Context context;

    public ShopCartAdapter(ArrayList<ShopCart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public menuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_item,parent, false);
        return new menuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menuViewHolder holder, final int position) {
        final ShopCart cart = cartList.get(position);
        holder.ivFoto.setImageResource(cart.getMenuFoto());
        holder.tvFoodName.setText(cart.getMenuName());
        holder.tvFoodPrice.setText("Total: Rp. " + cart.getMenuPrice() * cart.getQuantity());
        holder.tvQuantity.setText("Quantity: " + cart.getQuantity());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrderActivity.listCart.remove(position);
                notifyDataSetChanged();
                MyOrderActivity.tvTotalPrice.setText(getTotalPrice());
            }
        });
    }

    public String getTotalPrice(){
        Long totalPrice = 0L;
        for(int i = 0; i <cartList.size(); i++){
            totalPrice += (cartList.get(i).getMenuPrice() * cartList.get(i).getQuantity());
        }
        return totalPrice.toString();
    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class menuViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private TextView tvFoodName, tvFoodPrice, tvQuantity;
        private Button btnDelete;

        public menuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvFoodName = itemView.findViewById(R.id.tv_name);
            tvFoodPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }

}
