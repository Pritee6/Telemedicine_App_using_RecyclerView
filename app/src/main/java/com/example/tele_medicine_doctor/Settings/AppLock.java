package com.example.tele_medicine_doctor.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tele_medicine_doctor.R;

import java.util.concurrent.Executor;

public class AppLock extends AppCompatActivity {

    private Switch btn_switch;
    private TextView txt;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);

        txt = findViewById(R.id.txt);

        final TextView result = (TextView) findViewById(R.id.txt);

        String text = txt.getText().toString();

        if (text.length()>72) {
            text=text.substring(0,72) + ".";
            result.setText(Html.fromHtml(text+"<font color='blue'> <u>Learn More</u></font>"));

        }

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vRg0ANx2gRZwu2SyThXU5t3Hr-5Y2-_AVqPEMIPLNgFoat0mL7G6Ttypd_S30Mj-lME4jvNOWj8to9O/pub"));
                startActivity(intent);

            }
        });

        btn_switch = (Switch) findViewById(R.id.btn_switch);

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(AppLock.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

                Toast.makeText(AppLock.this, "Biometric authentication error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                Toast.makeText(AppLock.this, "Biometric authentication succeeded", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                Toast.makeText(AppLock.this, "Biometric authentication failed", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Login using firgerprint authentication")
                .setNegativeButtonText("User app password")
                .build();

        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                biometricPrompt.authenticate(promptInfo);
            }
        });
    }
}