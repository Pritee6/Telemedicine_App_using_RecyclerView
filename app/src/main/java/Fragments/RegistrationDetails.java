package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tele_medicine_doctor.CountryCodes;
import com.example.tele_medicine_doctor.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class RegistrationDetails extends Fragment {

    private Button btn_Next1;
    private Spinner spinner_year;
    private EditText edt_RegNumber, edt_RegCouncil, edt_Experience;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.registration_details, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Registration Details");

        edt_RegNumber = (EditText) view.findViewById(R.id.edt_RegNumber);
        edt_RegCouncil = (EditText) view.findViewById(R.id.edt_RegCouncil);
        edt_Experience = (EditText) view.findViewById(R.id.edt_Experience);

        spinner_year = (Spinner) view.findViewById(R.id.spinner_year1);
        spinner_year.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CountryCodes.year));

        btn_Next1 = (Button)view.findViewById(R.id.btn_Next1);
        btn_Next1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ClinicDetails clinicDetails = new ClinicDetails();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, clinicDetails);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
