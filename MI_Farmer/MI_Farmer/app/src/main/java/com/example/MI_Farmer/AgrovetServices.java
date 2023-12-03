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

        Intent intent = getIntent();

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
        }

        String finalCurrUser = currUser;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}