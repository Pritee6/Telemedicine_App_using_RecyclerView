package com.example.tele_medicine_doctor.BuyMedicinesOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tele_medicine_doctor.R;

public class MedicineDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        getIncomingIntent();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("image_price")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imagePrice = getIntent().getStringExtra("image_price");

            setImage(imageUrl, imageName, imagePrice);
        }
    }


    private void setImage(String imageUrl, String imageName, String imagePrice){

        TextView name = findViewById(R.id.medicine_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.medicine_image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        TextView price = findViewById(R.id.medicine_price);
        price.setText("₹"+imagePrice);
    }

}