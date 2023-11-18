package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mi_farmer.R;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button buyer = (Button) findViewById(R.id.todoB);
        ImageButton backButton = (ImageButton) findViewById(R.id.backA);
        ImageButton logOutButton = (ImageButton) findViewById(R.id.logOutA);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileB);

        CardView sellCard = findViewById(R.id.sellCard);
        CardView agrovetsCard = findViewById(R.id.agrovetsCard);

        sellCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), UploadInfoActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        agrovetsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), AgrovetServices.class);
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

        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToBuyerIntent = new Intent(v.getContext(), BuyerLanding.class);
                v.getContext().startActivity(goToBuyerIntent);
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