package com.example.tele_medicine_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import Fragments.AppointmentRequestsFragment;
import Fragments.BuyMedicinesFragment;
import Fragments.FeedbackFragment;
import Fragments.HomeScreen;
import Fragments.ManageProfileFragment;
import Fragments.PaymentFragment;
import Fragments.PersonalDetails;
import Fragments.SetAvailabilityFragment;
import Fragments.SettingsFragment;
import Fragments.SwitchToUserAppFragment;
import Fragments.UpcomingAppointmentsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Button btn_ViewandEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open_Drawer, R.string.Close_Drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeScreen()).commit();
        navigationView.setCheckedItem(R.id.nav_manage_profile);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:
                HomeScreen homeScreen = new HomeScreen();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeScreen).addToBackStack(null).commit();
                break;

            case R.id.nav_manage_profile:
                ManageProfileFragment manageProfileFragment = new ManageProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, manageProfileFragment).addToBackStack(null).commit();
                break;

           case R.id.nav_set_availability:
                SetAvailabilityFragment setAvailabilityFragment = new SetAvailabilityFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, setAvailabilityFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_appointment_request:
                AppointmentRequestsFragment appointmentRequestsFragment = new AppointmentRequestsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, appointmentRequestsFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_upcoming_appointments:
                UpcomingAppointmentsFragment upcomingAppointmentsFragment = new UpcomingAppointmentsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, upcomingAppointmentsFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_buy_medicines:
                BuyMedicinesFragment buyMedicinesFragment = new BuyMedicinesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, buyMedicinesFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_feedback:
                FeedbackFragment feedbackFragment = new FeedbackFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, feedbackFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_payment:
                PaymentFragment paymentFragment = new PaymentFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, paymentFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_settings:
                SettingsFragment settingsFragment = new SettingsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,settingsFragment).addToBackStack(null).commit();
                break;

            case R.id.nav_user_app:
                SwitchToUserAppFragment switchToUserAppFragment = new SwitchToUserAppFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,switchToUserAppFragment).addToBackStack(null).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStackImmediate();
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}