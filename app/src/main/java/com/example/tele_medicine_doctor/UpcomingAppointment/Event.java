package com.example.tele_medicine_doctor.UpcomingAppointment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();
    //public static EventAdapter eventAdapter;

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date) && event != null) {

                /*Collections.sort(eventsList, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                try {
                    //return new SimpleDateFormat("hh:mm a").parse(String.valueOf(o1)).compareTo(new SimpleDateFormat("hh:mm a").parse(String.valueOf(o2)));
                    String a1 = o1.getTime();
                    String a2 = o2.getTime();

                    return a1.compareTo(a2);

                } catch (Exception e) {
                    return 0;
                }
            }
        });
        eventAdapter.notifyDataSetChanged();*/
                events.add(event);
            }
            else if (event.getDate().equals(date))
            {
                events.add(event);
            }
        }

        return events;
    }


    private String name;
    private LocalDate date;
    private String time;

    public Event(String name, LocalDate date, String time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}
