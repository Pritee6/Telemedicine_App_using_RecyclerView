package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tele_medicine_doctor.BuyMedicinesOnline.CartActivity;
import com.example.tele_medicine_doctor.BuyMedicinesOnline.RecyclerViewAdapterBuyMedicines;
import com.example.tele_medicine_doctor.R;
import com.example.tele_medicine_doctor.SearchDoctorsNearYou.RecyclerViewAdpater;

import java.util.ArrayList;

public class BuyMedicinesFragment extends Fragment {

    private ArrayList<String> medicineImageUrls = new ArrayList<>();
    private ArrayList<String> medicineNames = new ArrayList<>();
    private ArrayList<String> medicinePrice = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buy_medicines, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Buy Medicines");

        medicineImageUrls.add("https://5.imimg.com/data5/BM/QL/RX/SELLER-23618296/benadryl-syrup-500x500.jpg");
        medicineNames.add("Cough Syrup");
        medicinePrice.add("240");

        medicineImageUrls.add("https://5.imimg.com/data5/OC/TY/MY-2/crocin-pain-relief-tablet-500x500.jpg");
        medicineNames.add("Crocin Pain Relief Tablet");
        medicinePrice.add("99");

        medicineImageUrls.add("https://cdn.shopify.com/s/files/1/0272/4714/9155/products/kofflet-syrup-100ml_1200x1200.jpg");
        medicineNames.add("Himalaya Koflet Syrup");
        medicinePrice.add("199");

        medicineImageUrls.add("https://asset20.ckassets.com/blog/wp-content/uploads/sites/5/2018/05/Zinetac.jpg");
        medicineNames.add("Zinetac Tablet");
        medicinePrice.add("1599");

        medicineImageUrls.add("https://5.imimg.com/data5/ZW/HD/BM/SELLER-80230893/paracetamol-tablets-500x500.jpg");
        medicineNames.add("Paracetamol2 Tablet");
        medicinePrice.add("139");

        medicineImageUrls.add("https://5.imimg.com/data5/BM/QL/RX/SELLER-23618296/benadryl-syrup-500x500.jpg");
        medicineNames.add("Cough Syrup");
        medicinePrice.add("49");

        medicineImageUrls.add("https://cdn01.pharmeasy.in/dam/products_otc/I44532/cofsils-naturals-cough-syrup-bottle-of-100-ml-3-1613636950.jpg");
        medicineNames.add("Cofsils Naturals Syrup");
        medicinePrice.add("999");

        medicineImageUrls.add("https://drbest.in/wp-content/uploads/2019/06/DrDklo-Plus.jpg");
        medicineNames.add("Paracetamol Tablet");
        medicinePrice.add("69");


        RecyclerView recyclerViewMedicines = (RecyclerView) view.findViewById(R.id.recycler_view_buy_medicines);
        RecyclerViewAdapterBuyMedicines adapter = new RecyclerViewAdapterBuyMedicines(getContext(), medicineNames, medicineImageUrls, medicinePrice);
        recyclerViewMedicines.setAdapter(adapter);
        recyclerViewMedicines.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}