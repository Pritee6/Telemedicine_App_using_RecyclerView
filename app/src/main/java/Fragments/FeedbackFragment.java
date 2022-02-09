package Fragments;

import android.media.Rating;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tele_medicine_doctor.R;

public class FeedbackFragment extends Fragment {

    private TextView rate_Count;
    private RatingBar rating_Bar;
    float rateValue;
    String temp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Feedback");

        rate_Count = (TextView) view.findViewById(R.id.rate_Count);
        rating_Bar = (RatingBar) view.findViewById(R.id.rating_Bar);

        rating_Bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                rateValue = rating_Bar.getRating();

                /*if (rateValue<=1 && rateValue>0)
                    rate_Count.setText("Bad " + rateValue + "/5");
                else if (rateValue<=2 && rateValue<1)
                    rate_Count.setText("OK " + rateValue + "/5");
                else if (rateValue<=3 && rateValue<2)
                    rate_Count.setText("Good " + rateValue + "/5");
                else if (rateValue<=4 && rateValue<3)
                    rate_Count.setText("Very Good " + rateValue + "/5");
                else if (rateValue<=5 && rateValue<4)
                    rate_Count.setText("Best " + rateValue + "/5");*/

                if (rateValue==0 || rateValue==0.5)
                    rate_Count.setText("Bad " + rateValue + "/5");
                else if (rateValue==1 || rateValue==1.5)
                    rate_Count.setText("OK " + rateValue + "/5");
                else if (rateValue==2 || rateValue==2.5)
                    rate_Count.setText("OK " + rateValue + "/5");
                else if (rateValue==3 || rateValue==3.5)
                    rate_Count.setText("Good " + rateValue + "/5");
                else if (rateValue==4 || rateValue==4.5)
                    rate_Count.setText("Good " + rateValue + "/5");
                else if (rateValue==5)
                    rate_Count.setText("Best " + rateValue + "/5");
            }
        });

        return view;
    }
}