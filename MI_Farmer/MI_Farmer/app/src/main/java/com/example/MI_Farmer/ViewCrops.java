package com.example.MI_Farmer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mi_farmer.R;

import java.util.ArrayList;

public class ViewCrops extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<CropModal> cropModalArrayList;
    private DBHandler dbHandler;
    private CropsAdapter cropRVAdapter;
    private RecyclerView cropsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_crops);

        Intent intent = getIntent();

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
        }

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        Button checkOutButton = findViewById(R.id.checkOutBTN);

        String finalCurrUser1 = currUser;
        String finalCurrUser2 = currUser;
        String finalCurrUser3 = currUser;
        String finalCurrUser4 = currUser;
        String finalCurrUser5 = currUser;
        String finalCurrUser6 = currUser;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = getIntent();
                // receive the value by getStringExtra() method and
                // key must be same which is send by first activity
                String cropType;

                Intent goToLoginActivity;
                if (intent.getStringExtra("crop_type") != null){

                    cropType = intent.getStringExtra("crop_type");
                    if (cropType.equals("cereals")){

                        goToLoginActivity = new Intent(v.getContext(), BuyCerealsActivity.class);
                        goToLoginActivity.putExtra("crop_type", "cereals");
                        goToLoginActivity.putExtra("currUser", finalCurrUser6);
                        v.getContext().startActivity(goToLoginActivity);
                    }else if (cropType.equals("fruits")){

                        goToLoginActivity = new Intent(v.getContext(), BuyFruitsActivity.class);
                        goToLoginActivity.putExtra("crop_type", "fruits");
                        goToLoginActivity.putExtra("currUser", finalCurrUser5);
                        v.getContext().startActivity(goToLoginActivity);
                    }else if (cropType.equals("nuts")){

                        goToLoginActivity = new Intent(v.getContext(), BuyNutsActivities.class);
                        goToLoginActivity.putExtra("crop_type", "fruits");
                        goToLoginActivity.putExtra("currUser", finalCurrUser4);
                        v.getContext().startActivity(goToLoginActivity);
                    }else if (cropType.equals("vegetables")){

                        goToLoginActivity = new Intent(v.getContext(), BuyVegetablesActivity.class);
                        goToLoginActivity.putExtra("crop_type", "fruits");
                        goToLoginActivity.putExtra("currUser", finalCurrUser3);
                        v.getContext().startActivity(goToLoginActivity);
                    }

                }else{

                    goToLoginActivity = new Intent(v.getContext(), BuyFruitsActivity.class);
                    goToLoginActivity.putExtra("currUser", finalCurrUser1);
                    v.getContext().startActivity(goToLoginActivity);


                }


            }
        });

        String finalCurrUser = currUser;
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), CheckoutActivity.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        // Initializing our all variables.
        cropModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCrops.this);
        cropModalArrayList = dbHandler.readCrops();

        // getting our meals array
        // list from db handler class.

        // on below line passing our array list to our adapter class.
        cropRVAdapter = new CropsAdapter(cropModalArrayList, dbHandler, ViewCrops.this);
        cropsRV = findViewById(R.id.idRVMeals);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCrops.this, RecyclerView.VERTICAL, false);
        cropsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        cropsRV.setAdapter(cropRVAdapter);
    }
}
