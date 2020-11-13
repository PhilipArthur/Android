package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.menuViewHolder>{

    private ArrayList<Menu> menuList;
    private Context context;

    public MenuAdapter(ArrayList<Menu> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @NonNull
    @Override
    public menuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menu_item,parent, false);
        return new menuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menuViewHolder holder, int position) {
        final Menu menu = menuList.get(position);
        holder.ivFoto.setImageResource(menu.getFoto());
        holder.tvFoodName.setText(menu.getMenuName());
        holder.tvFoodPrice.setText("Rp. " + menu.getMenuPrice());
        holder.llitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("menuFoto", menu.getFoto());
                intent.putExtra("menuName", menu.getMenuName());
                intent.putExtra("menuPrice", menu.getMenuPrice());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class menuViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private TextView tvFoodName, tvFoodPrice;
        private LinearLayout llitem;

        public menuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvFoodName = itemView.findViewById(R.id.tv_name);
            tvFoodPrice = itemView.findViewById(R.id.tv_price);
            llitem = itemView.findViewById(R.id.ll_item);
        }
    }
}
