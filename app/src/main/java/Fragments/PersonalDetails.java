package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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

public class PersonalDetails extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private EditText edt_Name, edt_Address, edt_Email, edt_Speciality, edt_Education, edt_UniversityName;
    private RadioGroup radioGroup_Gender;
    String gender;
    private Button btn_Next;
    private Spinner spinner_year;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.personal_details, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Personal Details");

        edt_Name = (EditText) view.findViewById(R.id.edt_Name);
        edt_Address = (EditText) view.findViewById(R.id.edt_Address);
        edt_Email = (EditText) view.findViewById(R.id.edt_Email);
        edt_Speciality = (EditText) view.findViewById(R.id.edt_Speciality);
        edt_Education = (EditText) view.findViewById(R.id.edt_Education);
        edt_UniversityName = (EditText) view.findViewById(R.id.edt_UniversityName);

        radioGroup_Gender = (RadioGroup)view.findViewById(R.id.radioGroup_Gender);
        radioGroup_Gender.setOnCheckedChangeListener(this);

        spinner_year = (Spinner) view.findViewById(R.id.spinner_year);
        spinner_year.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CountryCodes.year));

        btn_Next = (Button)view.findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                RegistrationDetails registrationDetails = new RegistrationDetails();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, registrationDetails);
                fragmentTransaction.commit();
            }
        });

        return view;
}

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId)
        {
            case R.id.radioButton_Male:
                gender = "Male";
                break;

            case R.id.radioButton_Female:
                gender = "Female";
                break;
        }

    }
}
