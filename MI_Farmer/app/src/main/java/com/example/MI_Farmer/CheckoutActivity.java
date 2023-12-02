package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mi_farmer.R;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private ArrayList<CropModal> cropModalArrayList;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ImageButton backButton = findViewById(R.id.backB);

        CardView newYorkCard = findViewById(R.id.newYorkCard);
        CardView londonCard = findViewById(R.id.londonCard);
        CardView delhiCard = findViewById(R.id.delhiCard);
        CardView mumbaiCard = findViewById(R.id.mumbaiCard);
        CardView kolkataCard = findViewById(R.id.kolkataCard);
        CardView jaipurCard = findViewById(R.id.jaipurCard);

        TextView mumbaiStreet = findViewById(R.id.mumbaiStreet);
        TextView delhiStreet = findViewById(R.id.streetDelhi);
        TextView londonStreet = findViewById(R.id.londonStreet);
        TextView newYorkStreet = findViewById(R.id.newYorkStreet);
        TextView kolkataStreet = findViewById(R.id.kolkataStreet);
        TextView jaipurStreet = findViewById(R.id.jaipurStreet);

        dbHandler = new DBHandler(CheckoutActivity.this);
        cropModalArrayList = dbHandler.readCrops();
        double total = 0.00;
        for (int i = 0; i < cropModalArrayList.size(); i++){
            double subtringTemp = Double.parseDouble(cropModalArrayList.get(i).getSubtotal());
            total = subtringTemp + total;

        }

        total = total + 5;

        String totalString = String.valueOf(total);
        mumbaiStreet.setText("Total: $"+ totalString +" fee: 5");

        total = total + 2;
        totalString = String.valueOf(total);
        delhiStreet.setText("Total: $"+ totalString +"  Fee: $2");

        total = total + 50;
        totalString = String.valueOf(total);
        londonStreet.setText("Total: $"+ totalString +" Fee: $50");

        total = total + 15;
        totalString = String.valueOf(total);
        newYorkStreet.setText("Total: $"+ totalString +" Fee: $15");

        total = total + 1.5;
        totalString = String.valueOf(total);
        kolkataStreet.setText("Total: $"+ totalString +" Fee: $1.5");

        total = total + 3.5;
        totalString = String.valueOf(total);
        jaipurStreet.setText("Total: $"+ totalString +" Fee: $3.5");


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), ViewCrops.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        newYorkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "New York";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class );

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

        londonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "London";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

        delhiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Delhi";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

        mumbaiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Mumbai";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

        kolkataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Kolkata";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

        jaipurCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Jaipur";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);

                intent.putExtra("city", city);
                startActivity(intent);
            }
        });


    }
}