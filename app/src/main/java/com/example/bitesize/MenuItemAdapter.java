package com.example.bitesize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.AllMenuViewHolder> {

    Context context;
    List<MenuItem> menuList;

    public MenuItemAdapter(Context context, List<MenuItem> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, final int position) {

        holder.menuItemName.setText(menuList.get(position).getName());
        holder.menuItemPrice.setText(menuList.get(position).getPrice());
        holder.menuItemRating.setText(menuList.get(position).getRating());
        holder.menuItemNote.setText(menuList.get(position).getDescription());
        holder.menuItemImage.setImageResource(context.getResources().getIdentifier(menuList.get(position).getImageName(), "drawable", context.getPackageName() ));
//        getResources().getIdentifier(business.getImageName(), "drawable", getPackageName())



    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder {

        TextView menuItemName, menuItemNote, menuItemRating, menuItemPrice;
        ImageView menuItemImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            menuItemName = itemView.findViewById(R.id.all_menu_name);
            menuItemNote = itemView.findViewById(R.id.all_menu_note);
            menuItemRating = itemView.findViewById(R.id.all_menu_rating);
            menuItemPrice = itemView.findViewById(R.id.all_menu_price);
            menuItemImage = itemView.findViewById(R.id.all_menu_image);
        }
    }
}