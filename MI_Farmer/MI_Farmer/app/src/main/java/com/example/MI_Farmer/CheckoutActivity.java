package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mi_farmer.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private ArrayList<CropModal> cropModalArrayList;
    private DBHandler dbHandler;

    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
        }

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

            total = total + subtringTemp;

        }

        String totalString = df.format(total + 5.00);
        mumbaiStreet.setText("Total: $"+ totalString +" fee: 5");

        totalString = df.format(total + 2.00);
        delhiStreet.setText("Total: $"+ totalString +"  Fee: $2");

        totalString =df.format(total + 50.00);
        londonStreet.setText("Total: $"+ totalString +" Fee: $50");

        totalString = df.format(total + 15.00);
        newYorkStreet.setText("Total: $"+ totalString +" Fee: $15");

        totalString = df.format(total + 2.00);
        kolkataStreet.setText("Total: $"+ totalString +" Fee: $2");

        totalString = df.format(total + 5.00);
        jaipurStreet.setText("Total: $"+ totalString +" Fee: $5");


        String finalCurrUser6 = currUser;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), ViewCrops.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser6);
                v.getContext().startActivity(goToLoginActivity);
                finish();

            }
        });

        String finalCurrUser = currUser;
        newYorkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "New York";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class );
                intent.putExtra("currUser", finalCurrUser);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });

        String finalCurrUser1 = currUser;
        londonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "London";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);
                intent.putExtra("currUser", finalCurrUser1);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });

        String finalCurrUser2 = currUser;
        delhiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Delhi";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);
                intent.putExtra("currUser", finalCurrUser2);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });

        String finalCurrUser3 = currUser;
        mumbaiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Mumbai";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);
                intent.putExtra("currUser", finalCurrUser3);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });

        String finalCurrUser4 = currUser;
        kolkataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Kolkata";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);
                intent.putExtra("currUser", finalCurrUser4);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });

        String finalCurrUser5 = currUser;
        jaipurCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = "Jaipur";
                Intent intent=new Intent(CheckoutActivity.this, ThankYouActivity.class);
                intent.putExtra("currUser", finalCurrUser5);
                intent.putExtra("city", city);
                startActivity(intent);
                finish();
            }
        });


    }
}