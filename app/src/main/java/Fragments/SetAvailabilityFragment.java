package Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tele_medicine_doctor.R;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;
import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.HashMap;


public class SetAvailabilityFragment extends Fragment {

    private CalendarView calendar_view;
    private TextView txt_set_date, txt_set_time;
    private Button btn_nineTotwelve, btn_twelveTothree, btn_threeTosix;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_set_availability, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Set Availability");

        calendar_view = (CalendarView) view.findViewById(R.id.calendar_view);
        txt_set_date = (TextView) view.findViewById(R.id.txt_set_date);
        txt_set_time = (TextView) view.findViewById(R.id.txt_set_time);

        btn_nineTotwelve = (Button) view.findViewById(R.id.btn_nineTotwelve);
        btn_twelveTothree = (Button) view.findViewById(R.id.btn_twelveTothree);
        btn_threeTosix = (Button) view.findViewById(R.id.btn_threeTosix);

        calendar_view.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String sDate = dayOfMonth + "-" + ( month + 1 ) + "-" + year;
                txt_set_date.setText("Available Date: " + sDate);

                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", "A Test Event from android app");
                startActivity(intent);
                //Toast.makeText(getActivity().getApplicationContext(), "Selected Date: " + sDate, Toast.LENGTH_SHORT).show();
            }
        });

        btn_nineTotwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sTime = btn_nineTotwelve.getText().toString();
                txt_set_time.setText("Avialable Time: " + sTime);
            }
        });

        btn_twelveTothree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sTime = btn_twelveTothree.getText().toString();
                txt_set_time.setText("Avialable Time: " + sTime);
            }
        });

        btn_threeTosix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sTime = btn_threeTosix.getText().toString();
                txt_set_time.setText("Avialable Time: " + sTime);
            }
        });

        return view;
    }
}