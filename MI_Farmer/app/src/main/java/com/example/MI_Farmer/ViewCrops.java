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

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        Button checkOutButton = findViewById(R.id.checkOutBTN);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyFruitsActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), CheckoutActivity.class);
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
