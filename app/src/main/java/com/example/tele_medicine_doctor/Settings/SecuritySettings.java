package com.example.tele_medicine_doctor.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tele_medicine_doctor.R;

public class SecuritySettings extends AppCompatActivity {

    private LinearLayout ll_two_step_verification, ll_app_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_settings);

        ll_app_lock = (LinearLayout) findViewById(R.id.ll_app_lock);
        ll_two_step_verification = (LinearLayout) findViewById(R.id.ll_two_step_verification);

        ll_app_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettings.this, AppLock.class);
                startActivity(intent);
            }
        });

        ll_two_step_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettings.this, TwoStepVerification.class);
                startActivity(intent);
            }
        });
    }
}