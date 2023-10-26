package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mi_farmer.R;

public class BuyerLanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_landing);

        Button farmer = (Button) findViewById(R.id.farmer_btn);
        ImageButton backButton = (ImageButton) findViewById(R.id.backB);
        ImageButton logOutButton = (ImageButton) findViewById(R.id.logOutB);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileB);

        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToFarmer = new Intent(v.getContext(), LandingActivity.class);
                v.getContext().startActivity(goToFarmer);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), UserProfileActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}