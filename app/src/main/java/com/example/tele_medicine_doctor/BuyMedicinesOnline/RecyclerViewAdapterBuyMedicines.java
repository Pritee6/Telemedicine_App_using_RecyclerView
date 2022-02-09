package com.example.tele_medicine_doctor.BuyMedicinesOnline;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tele_medicine_doctor.R;

import java.util.ArrayList;

public class RecyclerViewAdapterBuyMedicines extends RecyclerView.Adapter<RecyclerViewAdapterBuyMedicines.ViewHolder> {

    private ArrayList<String> medicineNames = new ArrayList<>();
    private ArrayList<String> medicineImages = new ArrayList<>();
    private ArrayList<String> medicinePrice = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapterBuyMedicines(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> price) {
        medicineNames = imageNames;
        medicineImages = images;
        medicinePrice = price;
        mcontext = context;
  }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_medicines, parent, false);
        RecyclerViewAdapterBuyMedicines.ViewHolder holder = new RecyclerViewAdapterBuyMedicines.ViewHolder(view1);

        return holder;
    }

        @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

            Glide.with(mcontext)
                    .asBitmap()
                    .load(medicineImages.get(position))
                    .into(holder.recycler_image_medicines);

            holder.txt_medicine_name.setText(medicineNames.get(position));
            holder.txt_price.setText("₹"+medicinePrice.get(position));

            holder.parent_recycler_layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(mcontext, medicineNames.get(position), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mcontext, MedicineDetails.class);
                    intent.putExtra("image_url", medicineImages.get(position));
                    intent.putExtra("image_name", medicineNames.get(position));
                    intent.putExtra("image_price", medicinePrice.get(position));
                    mcontext.startActivity(intent);
                }
            });

            holder.btn_addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(mcontext, medicineNames.get(position), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mcontext, CartActivity.class);
                    intent.putExtra("image_url", medicineImages.get(position));
                    intent.putExtra("image_name", medicineNames.get(position));
                    intent.putExtra("image_price", medicinePrice.get(position));
                    mcontext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return medicineNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recycler_image_medicines, medicine_image_cart;
        TextView txt_medicine_name, txt_price, medicine_name_cart, medicine_price_cart;
        Button btn_addToCart;
        RelativeLayout parent_recycler_layout2, parent_recycler_layout_cart;

        public ViewHolder(View itemView) {
            super(itemView);
            recycler_image_medicines = itemView.findViewById(R.id.recycler_image_medicines);
            txt_medicine_name = itemView.findViewById(R.id.txt_medicine_name);
            txt_price = itemView.findViewById(R.id.txt_price);
            parent_recycler_layout2 = itemView.findViewById(R.id.parent_recycler_layout2);
            btn_addToCart = itemView.findViewById(R.id.btn_addToCart);

//            medicine_image_cart = itemView.findViewById(R.id.medicine_image_cart);
//            medicine_name_cart = itemView.findViewById(R.id.medicine_name_cart);
//            medicine_price_cart = itemView.findViewById(R.id.medicine_price_cart);
//            btn_addToCart = itemView.findViewById(R.id.btn_addToCart);
//            parent_recycler_layout_cart = itemView.findViewById(R.id.parent_recycler_layout_cart);
        }
    }
}
