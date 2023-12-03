package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mi_farmer.R;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Button contactUsBTN = findViewById(R.id.btn_send_contact_us);

        Intent intent = getIntent();

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
        }

        ImageButton backButton = (ImageButton) findViewById(R.id.backB);
        String finalCurrUser = currUser;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyerLanding.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        contactUsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyerLanding.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

    }
}