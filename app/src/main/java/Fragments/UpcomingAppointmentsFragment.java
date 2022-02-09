package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tele_medicine_doctor.UpcomingAppointment.CalendarAdapter;
import com.example.tele_medicine_doctor.UpcomingAppointment.CalendarUtils;
import com.example.tele_medicine_doctor.R;
import com.example.tele_medicine_doctor.UpcomingAppointment.WeekViewActivity;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.tele_medicine_doctor.UpcomingAppointment.CalendarUtils.daysInMonthArray;
import static com.example.tele_medicine_doctor.UpcomingAppointment.CalendarUtils.monthYearFromDate;

public class UpcomingAppointmentsFragment extends Fragment implements CalendarAdapter.OnItemListener{

    //private Button btn_OpenCalendar;
    //int mYear, mMonth, mDay;
    private TextView monthYearTV;
    private RecyclerView calendarRecyclerView;
    private Button btn_weeklyAction, btn_nextMonthAction, btn_previousMonthAction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_appointments, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Upcoming Appointments");

        /*btn_OpenCalendar = (Button) view.findViewById(R.id.btn_OpenCalendar);
        btn_OpenCalendar.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    String mdate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
            }
        });*/


        CalendarUtils.selectedDate = LocalDate.now();

        btn_nextMonthAction = (Button) view.findViewById(R.id.btn_nextMonthAction);
        btn_previousMonthAction = (Button) view.findViewById(R.id.btn_previousMonthAction);

        calendarRecyclerView = (RecyclerView) view.findViewById(R.id.calendarRecyclerView);
        monthYearTV = (TextView) view.findViewById(R.id.monthYearTV);
        btn_weeklyAction = (Button) view.findViewById(R.id.btn_weeklyAction);

        btn_weeklyAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WeekViewActivity.class);
                startActivity(intent);
            }
        });

        btn_previousMonthAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
                setMonthView();
            }
        });

        btn_nextMonthAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
                setMonthView();
            }
        });

        setMonthView();

        return view;
    }

    private void setMonthView()
    {
        monthYearTV.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
            setMonthView();
        }
    }


}