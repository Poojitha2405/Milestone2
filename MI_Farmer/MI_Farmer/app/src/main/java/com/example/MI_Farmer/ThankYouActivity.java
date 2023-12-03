package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.mi_farmer.R;

import java.util.ArrayList;

public class ThankYouActivity extends AppCompatActivity {

    public DBHandler dbHandler;

    private ArrayList<CropModal> cropModalArrayList;


    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        TextView thankYouTV = findViewById(R.id.thankYouTV);

        dbHandler = new DBHandler(this);

        cropModalArrayList = dbHandler.readCrops();
        dbHandler = new DBHandler(ThankYouActivity.this);
        cropModalArrayList = dbHandler.readCrops();
        dbHandler.deleteAll();
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String city = intent.getStringExtra("city");

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
            thankYouTV.setText("Thank you for shopping with us! Your goods will be ready for picking in two hours at our "+city + " branch" );

        }
        handler=new Handler();
        String finalCurrUser = currUser;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(ThankYouActivity.this,BuyerLanding.class);
                intent.putExtra("currUser", finalCurrUser);
                startActivity(intent);
                finish();
            }
        },10000);
    }
}