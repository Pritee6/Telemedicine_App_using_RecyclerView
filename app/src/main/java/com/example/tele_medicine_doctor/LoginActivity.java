package com.example.tele_medicine_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity {

    private Button btn_register;
    private Spinner spinner_countryCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    public void init()
    {
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new BtnRegisterOnClickListener());

//        spinner_countryCodes = findViewById(R.id.spinner_countryCodes);
//        spinner_countryCodes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryCodes.code));
    }

    class BtnRegisterOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}