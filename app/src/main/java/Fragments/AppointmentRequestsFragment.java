package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tele_medicine_doctor.AppointmentRequest.PdfActivity;
import com.example.tele_medicine_doctor.AppointmentRequest.PdfActivity2;
import com.example.tele_medicine_doctor.AppointmentRequest.PdfActivity3;
import com.example.tele_medicine_doctor.R;

public class AppointmentRequestsFragment extends Fragment {

    private Button btn_view_form, btn_view_form2, btn_view_form3;
    private Button btn_accept_request, btn_accept_request2, btn_accept_request3;
    private Button btn_reject_request, btn_reject_request2, btn_reject_request3;
    private TextView txt_container, txt_name1, txt_name2, txt_name3;
    private LinearLayout ll1, ll2, ll3;
    private Button btn_addEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_appointment_requests, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Appointment Requests");

        btn_view_form = (Button) view.findViewById(R.id.btn_view_form);
        btn_view_form2 = (Button) view.findViewById(R.id.btn_view_form2);
        btn_view_form3 = (Button) view.findViewById(R.id.btn_view_form3);

        btn_accept_request = (Button) view.findViewById(R.id.btn_accept_request);
        btn_accept_request2 = (Button) view.findViewById(R.id.btn_accept_request2);
        btn_accept_request3 = (Button) view.findViewById(R.id.btn_accept_request3);

        btn_reject_request = (Button) view.findViewById(R.id.btn_reject_request);
        btn_reject_request2 = (Button) view.findViewById(R.id.btn_reject_request2);
        btn_reject_request3 = (Button) view.findViewById(R.id.btn_reject_request3);

        txt_container = (TextView) view.findViewById(R.id.txt_container);
        txt_name1 = (TextView) view.findViewById(R.id.txt_name1);
        txt_name2 = (TextView) view.findViewById(R.id.txt_name2);
        txt_name3 = (TextView) view.findViewById(R.id.txt_name3);

        ll1 = (LinearLayout) view.findViewById(R.id.ll1);
        ll2 = (LinearLayout) view.findViewById(R.id.ll2);
        ll3 = (LinearLayout) view.findViewById(R.id.ll3);

        btn_addEvent = (Button) view.findViewById(R.id.btn_addEvent);


        btn_view_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), PdfActivity.class);
                startActivity(intent);
            }
        });

        btn_view_form2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), PdfActivity2.class);
                startActivity(intent);
            }
        });

        btn_view_form3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), PdfActivity3.class);
                startActivity(intent);
            }
        });

        btn_accept_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addData = txt_container.getText().toString();
                String sData = txt_name1.getText().toString();
                txt_container.setText(addData + "\nAppointment booked for " + sData + " @ 10 AM - 11 AM\n");
                ll1.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Accepteted", Toast.LENGTH_SHORT).show();


            }
        });

        btn_accept_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sData = txt_name2.getText().toString();
                String addData = txt_container.getText().toString();
                txt_container.setText(addData + "\nAppointment booked for " + sData + " @ 11 AM - 12 PM\n");
                ll2.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Accepteted", Toast.LENGTH_SHORT).show();
            }
        });

        btn_accept_request3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addData = txt_container.getText().toString();
                String sData = txt_name3.getText().toString();
                txt_container.setText(addData + "\nAppointment booked for " + sData + " @ 1 PM - 2 PM\n");
                ll3.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Accepteted", Toast.LENGTH_SHORT).show();
            }
        });

        btn_reject_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ll1.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Rejected", Toast.LENGTH_SHORT).show();
            }
        });

        btn_reject_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ll2.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Rejected", Toast.LENGTH_SHORT).show();
            }
        });

        btn_reject_request3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ll3.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Request Rejected", Toast.LENGTH_SHORT).show();
            }
        });

        btn_addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, txt_container.getText().toString());
                intent.putExtra(CalendarContract.Events.ALL_DAY, "true");
                startActivity(intent);
            }
        });

        return view;
    }
}