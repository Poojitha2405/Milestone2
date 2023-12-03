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

import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button updateProfile = findViewById(R.id.update_profile);


        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        TextView currUserTV = findViewById(R.id.user_name);
        TextView currUserTypeTV = findViewById(R.id.user_type);

        Intent intent = getIntent();


        String currUser =  intent.getStringExtra("currUser");

        if (intent != null){

            currUserTV.setText(currUser.toUpperCase());
            currUserTypeTV.setText("@"+currUser.toLowerCase());
        }

        TextInputEditText fullNameET = findViewById(R.id.full_name_profile_ET);
        TextInputEditText email_profile = findViewById(R.id.email_profile_ET);
        TextInputEditText phone_profile = findViewById(R.id.phone_profile_ET);

        if (currUser.equals("winwin")){

            fullNameET.setText("Win Win");
            email_profile.setText("win@win.com");
            phone_profile.setText("+190898397202");

        } else if (currUser.equals("james")) {

            fullNameET.setText("James Dean");
            email_profile.setText("james@info.com");
            phone_profile.setText("+921787373787");
        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                goToLoginActivity.putExtra("currUser", currUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });


        DBHandler dbHandler;
        ArrayList<UserModal> userModalArrayList;
        dbHandler = new DBHandler(this);

        userModalArrayList = dbHandler.readUsers();

        for (int i=0; i<userModalArrayList.size(); i++) {

            String userName = userModalArrayList.get(i).getUserName();
        }
        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                goToLoginActivity.putExtra("currUser", currUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }
}