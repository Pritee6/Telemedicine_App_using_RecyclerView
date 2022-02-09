package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tele_medicine_doctor.R;
import com.example.tele_medicine_doctor.TeleMedicineUser;

public class SwitchToUserAppFragment extends Fragment {

    private Button btn_switchtoUserApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_switch_to_user_app, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Are you apatient or user?");

        btn_switchtoUserApp = (Button) view.findViewById(R.id.btn_switchtoUserApp);
        btn_switchtoUserApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TeleMedicineUser.class);
                startActivity(intent);
            }
        });

        return view;
    }
}