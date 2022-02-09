package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tele_medicine_doctor.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManageProfileFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Manage Profile");

        PersonalDetails personalDetails = new PersonalDetails();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, personalDetails);
        fragmentTransaction.commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_manage_profile, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_nav_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.personalDetails)
                {
                    PersonalDetails personalDetails = new PersonalDetails();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, personalDetails);
                    fragmentTransaction.commit();
                }

                else if (id==R.id.registrationDetails)
                {
                    RegistrationDetails registrationDetails = new RegistrationDetails();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, registrationDetails);
                    fragmentTransaction.commit();
                }

                else if (id==R.id.clinicDetails)
                {
                    ClinicDetails clinicDetails = new ClinicDetails();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, clinicDetails);
                    fragmentTransaction.commit();
                }

                return true;
            }
        });

        return view;
    }
}