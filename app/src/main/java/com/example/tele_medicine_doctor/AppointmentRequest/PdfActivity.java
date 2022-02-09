package com.example.tele_medicine_doctor.AppointmentRequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tele_medicine_doctor.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    private PDFView pdf_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdf_view = findViewById(R.id.pdf_view);
        pdf_view.fromAsset("AppointmentForm.pdf").load();
    }
}