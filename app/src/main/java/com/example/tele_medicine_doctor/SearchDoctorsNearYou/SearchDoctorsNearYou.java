package com.example.tele_medicine_doctor.SearchDoctorsNearYou;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tele_medicine_doctor.R;

import java.util.ArrayList;

public class SearchDoctorsNearYou extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_doctors_near_you);

        initImageBitmaps();
    }

    private void initImageBitmaps() {

        mImageUrls.add("https://image.shutterstock.com/image-photo/covid19-coronavirus-healthcare-doctors-concept-260nw-1687768795.jpg");
        mNames.add("Dr. Gayatri Devkhile, Neaurologist");

        mImageUrls.add("https://www.languagelegos.com/wp-content/uploads/2018/05/doctor-blog-2.jpg");
        mNames.add("Dr. Shubham Mahalkar, Pediatrician");

        mImageUrls.add("https://image.shutterstock.com/image-photo/doctor-wearing-medical-mask-isolated-260nw-1675095655.jpg");
        mNames.add("Dr. Ashok Mehta, Gynacologist");

        mImageUrls.add("https://www.languagelegos.com/wp-content/uploads/2018/05/doctor-blog-2.jpg");
        mNames.add("Dr. Mahesh Patil, Pediatrician");


        mImageUrls.add("https://thumbs.dreamstime.com/b/young-female-caucasian-nhs-general-practitioner-sitting-office-desk-young-female-caucasian-nhs-general-practitioner-sitting-209276692.jpg");
        mNames.add("Dr. Pooja Patil, Neaurologist");

        mImageUrls.add("https://image.shutterstock.com/image-photo/covid19-coronavirus-healthcare-doctors-concept-260nw-1687768795.jpg");
        mNames.add("Dr. Priyanka Patil, Gynacologist");


        mImageUrls.add("https://thumbs.dreamstime.com/b/young-female-caucasian-nhs-general-practitioner-sitting-office-desk-young-female-caucasian-nhs-general-practitioner-sitting-209276692.jpg");
        mNames.add("Dr. Shital Devik, Dermatologist");

        mImageUrls.add("https://image.shutterstock.com/image-photo/doctor-wearing-medical-mask-isolated-260nw-1675095655.jpg");
        mNames.add("Dr. Rahul Kaushik, Neaurologist");

        mImageUrls.add("https://image.shutterstock.com/image-photo/covid19-coronavirus-healthcare-doctors-concept-260nw-1687768795.jpg");
        mNames.add("Dr. Deepika Choudhari, Neaurologist");

        initRecyclerView();
    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdpater adapter = new RecyclerViewAdpater(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

