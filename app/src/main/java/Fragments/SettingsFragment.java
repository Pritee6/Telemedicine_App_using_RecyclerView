package Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tele_medicine_doctor.R;
import com.example.tele_medicine_doctor.Settings.SecuritySettings;

public class SettingsFragment extends Fragment {

    private LinearLayout ll_security;
    private Button btn_privacy_policy, btn_eula;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Settings");

        btn_privacy_policy = (Button) view.findViewById(R.id.btn_privacy_policy);
        btn_eula = (Button) view.findViewById(R.id.btn_eula);

        ll_security = (LinearLayout) view.findViewById(R.id.ll_security);
        ll_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecuritySettings.class);
                startActivity(intent);
            }
        });

        btn_privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vTMYD8qeFEL5bz19Q7IHA7O11OCpJOH9uSAg0jBonukIAF3ynvT9ngNWvCNATOMKKZnXEv5sfr5W75Y/pub"));
                startActivity(intent);
            }
        });

        btn_eula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vRxo8_iDcO9FnA_bEDahF4-l49SLO4vy-I_LxxJ0llZWCyyJ4uE006HwMj0D1vkmUjAquLIfmpHH6Yx/pub"));
                startActivity(intent);
            }
        });

        return view;
    }
}