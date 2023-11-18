package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

        CardView cerealsCard = findViewById(R.id.cerealsCard);
        CardView nutscard = findViewById(R.id.nutsCard);
        CardView vegetablesCard = findViewById(R.id.vegetablesCard);
        CardView fruitsCard = findViewById(R.id.fruitsCard);

        TextView currUserTV = findViewById(R.id.textView);

        Intent intent = getIntent();

        String currUser =  intent.getStringExtra("currUser");

        if (intent != null){

            currUserTV.setText("Welcome back " + currUser);
        }

        cerealsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginActivity = new Intent(v.getContext(), BuyCerealsActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        vegetablesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginActivity = new Intent(v.getContext(), BuyVegetablesActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        nutscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginActivity = new Intent(v.getContext(), BuyNutsActivities.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        fruitsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginActivity = new Intent(v.getContext(), BuyFruitsActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        TextView contactUsTV = findViewById(R.id.contactUsTV);

        contactUsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), ContactUsActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

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
                goToLoginActivity.putExtra("currUser", currUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}