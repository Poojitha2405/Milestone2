package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mi_farmer.R;
import com.google.android.material.textfield.TextInputEditText;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button updateProfile = findViewById(R.id.update_profile);


        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        TextView currUserTV = findViewById(R.id.user_name);

        Intent intent = getIntent();


        String currUser =  intent.getStringExtra("currUser");

        if (intent != null){
            currUserTV.setText(currUser.toUpperCase());
        }

//        TextInputEditText fullNameET = findViewById(R.id.full_name_profile);
//
//        fullNameET.setText("@"+currUser);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                goToLoginActivity.putExtra("currUser", currUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}