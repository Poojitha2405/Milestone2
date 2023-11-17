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

        ImageButton backButton = (ImageButton) findViewById(R.id.backB);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyerLanding.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        contactUsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyerLanding.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

    }
}