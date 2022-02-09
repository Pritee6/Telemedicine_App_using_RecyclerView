package com.example.tele_medicine_doctor.BuyMedicinesOnline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tele_medicine_doctor.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        placeOrderButton = findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, OrderSummary.class);
                startActivity(intent);

                Toast.makeText(CartActivity.this, "Order Successfully Placed", Toast.LENGTH_LONG).show();
            }
        });

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("image_price")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imagePrice = getIntent().getStringExtra("image_price");

            setOrderInCart(imageUrl, imageName, imagePrice);
        }
    }


    private void setOrderInCart(String imageUrl, String imageName, String imagePrice){

        TextView name = findViewById(R.id.medicine_name_cart);
        name.setText(imageName);

        ImageView image = findViewById(R.id.medicine_image_cart);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        TextView price = findViewById(R.id.medicine_price_cart);
        price.setText("₹"+imagePrice);
    }
}