package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mi_farmer.R;

public class AgrovetServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrovet_services);

        ImageButton backButton = findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}