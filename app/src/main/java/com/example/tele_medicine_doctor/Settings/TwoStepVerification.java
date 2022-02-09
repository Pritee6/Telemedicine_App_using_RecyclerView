package com.example.tele_medicine_doctor.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tele_medicine_doctor.R;

public class TwoStepVerification extends AppCompatActivity {

    private Button btn_setUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_step_verification);

        btn_setUp = findViewById(R.id.btn_setUp);
        btn_setUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoStepVerification.this, AppLock.class);
                startActivity(intent);
            }
        });
    }
}