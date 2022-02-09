package Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.tele_medicine_doctor.Messages;
import com.example.tele_medicine_doctor.R;
import com.example.tele_medicine_doctor.SearchDoctorsNearYou.GallaryActivity;
import com.example.tele_medicine_doctor.SearchDoctorsNearYou.SearchDoctorsNearYou;


import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class HomeScreen extends Fragment {

    private static final int GALLARY_REQUEST_CODE = 123;
    private CircleImageView profile_image;
    private CardView doctorsNearYou, messages;
    Uri imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_screen, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Telemedicine-Doctor");

        doctorsNearYou = (CardView) view.findViewById(R.id.doctorsNearYou);
        messages = (CardView) view.findViewById(R.id.messages);

        profile_image = (CircleImageView) view.findViewById(R.id.profile_image);

        profile_image.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Pick an Image"), GALLARY_REQUEST_CODE);
            }
        });

        doctorsNearYou.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SearchDoctorsNearYou.class);
                startActivity(intent);
            }
        });

        messages.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Messages.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLARY_REQUEST_CODE && resultCode == RESULT_OK)
        {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                profile_image.setImageBitmap(bitmap);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
