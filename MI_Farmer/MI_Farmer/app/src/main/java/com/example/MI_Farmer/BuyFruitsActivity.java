package com.example.MI_Farmer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mi_farmer.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BuyFruitsActivity extends AppCompatActivity {

    private ArrayList<CropModal> cropModalArrayList;
    private DBHandler dbHandler;
    public double subTotal, cropPrice;
    public String finalSubTot, tempText;

    public ImageButton cartBTN;

    public CropModal modal;

    public String imgResource;

    private CropsAdapter cropRVAdapter;

    DecimalFormat df = new DecimalFormat("#.##");
    public int amountSet, numberOfItems, resource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_fruits);

        Intent intent = getIntent();

        String currUser = "";

        if (intent != null){

            currUser =  intent.getStringExtra("currUser");
        }

        TextView textView = findViewById(R.id.textView);

        textView.setText("User: "+currUser);

        TextView titleNumItems = findViewById(R.id.titleItems);

        TextView cartAmount = findViewById(R.id.cartAmount);

        numberOfItems = 0;
        EditText amountItems = findViewById(R.id.et_amount);

        TextView cropNamePopup = findViewById(R.id.cropNamePopup);
        TextView pricePopup = findViewById(R.id.pricePopup);
        TextView subtotalPopup = findViewById(R.id.subtotalPopup);

        LinearLayout linearLayout1 = findViewById(R.id.linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);

        CardView applesCard = findViewById(R.id.applesCard);
        CardView grapesCard = findViewById(R.id.grapesCard);
        CardView mangoesCard = findViewById(R.id.mangoesCard);
        CardView waterMelonCard = findViewById(R.id.waterMelonCard);
        CardView cartPopup = findViewById(R.id.adjustAmountLayout);

        ImageView cropImage = findViewById(R.id.cropImage);


        TextView applesName = findViewById(R.id.apples_name);
        TextView applesPriceAmount = findViewById(R.id.priceAmountApples);

        TextView grapesName = findViewById(R.id.grapes_name);
        TextView grapesPriceAmount = findViewById(R.id.priceAmountGrapes);

        TextView mangoesName = findViewById(R.id.mangoes_name);
        TextView mangoesPriceAmount = findViewById(R.id.priceAmountMangoes);

        TextView waterMelonName = findViewById(R.id.water_melon_name);
        TextView waterMelonPriceAmount = findViewById(R.id.priceAmountWaterMelon);

        ImageButton cancelBTNPopup = findViewById(R.id.cancelPopup);
        ImageButton backButton = findViewById(R.id.backA);
        ImageButton logOutButton = findViewById(R.id.logOutA);



        cropModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(BuyFruitsActivity.this);

        // getting our meals array
        // list from db handler class.
        cropModalArrayList = dbHandler.readCrops();
        String listSize = String.valueOf(cropModalArrayList.size());

        double total = 0;
        for (int i = 0; i < cropModalArrayList.size(); i++){
            double subtringTemp = Double.parseDouble(cropModalArrayList.get(i).getSubtotal());
            total = subtringTemp + total;

        }

        String totalString = df.format(total);;
        titleNumItems.setText("Total: $"+ totalString);

        cartAmount.setText(listSize);

        Button addToCart = findViewById(R.id.addCart);


        String finalCurrUser1 = currUser;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), BuyerLanding.class);
                goToLoginActivity.putExtra("currUser", finalCurrUser1);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(goToLoginActivity);
            }
        });

        applesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                cropPrice = Double.parseDouble(applesPriceAmount.getText().toString());


                cartPopup.setVisibility(View.VISIBLE);
                resource = R.drawable.apples;
                subTotal = amountSet * cropPrice;
                finalSubTot = String.valueOf(subTotal);
                cropNamePopup.setText(applesName.getText().toString());
                pricePopup.setText("$"+ applesPriceAmount.getText().toString()+ "/KG");
                subtotalPopup.setText("$"+finalSubTot+ " Subtotal");
                cropImage.setImageResource(resource);

                imgResource = String.valueOf(R.drawable.apples);
                amountItems.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!(amountItems.getText().toString().trim().equals(""))){

                            cropPrice = Double.parseDouble(applesPriceAmount.getText().toString());
                            amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                            subTotal = amountSet * cropPrice;
                            finalSubTot = df.format(subTotal);

                            subtotalPopup.setText("$"+finalSubTot+ " Subtotal");
                        }

                    }
                });

            }
        });



        grapesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                cropPrice = Double.parseDouble(grapesPriceAmount.getText().toString());

                cartPopup.setVisibility(View.VISIBLE);
                resource = R.drawable.grapes;
                subTotal = amountSet * cropPrice;
                finalSubTot = String.valueOf(subTotal);
                cropNamePopup.setText(grapesName.getText().toString());
                pricePopup.setText("$"+ grapesPriceAmount.getText().toString()+ "/KG");
                subtotalPopup.setText("$"+finalSubTot+ " Subtotal");
                cropImage.setImageResource(resource);

                imgResource = String.valueOf(R.drawable.grapes);
                amountItems.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!(amountItems.getText().toString().trim().equals(""))){

                            amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                            subTotal = amountSet * cropPrice;
                            finalSubTot = df.format(subTotal);

                            subtotalPopup.setText("$"+finalSubTot+ " Subtotal");
                        }

                    }
                });
            }
        });

        mangoesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                cropPrice = Double.parseDouble(mangoesPriceAmount.getText().toString());

                cartPopup.setVisibility(View.VISIBLE);
                resource = R.drawable.mangoes;
                subTotal = amountSet * cropPrice;
                finalSubTot = String.valueOf(subTotal);
                cropNamePopup.setText(mangoesName.getText().toString());
                pricePopup.setText("$"+ mangoesPriceAmount.getText().toString()+ "/KG");
                subtotalPopup.setText("$"+ finalSubTot + " Subtotal");
                cropImage.setImageResource(resource);

                imgResource = String.valueOf(R.drawable.mangoes);
                amountItems.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {


                        if (!(amountItems.getText().toString().trim().equals(""))){

                            amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                            subTotal = amountSet * cropPrice;
                            finalSubTot = df.format(subTotal);

                            subtotalPopup.setText("$"+ finalSubTot + " Subtotal");

                        }

                    }
                });


            }
        });

        waterMelonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                cropPrice = Double.parseDouble(waterMelonPriceAmount.getText().toString());

                cartPopup.setVisibility(View.VISIBLE);
                resource = R.drawable.water_melon;
                subTotal = amountSet * cropPrice;
                finalSubTot = String.valueOf(subTotal);
                cropNamePopup.setText(waterMelonName.getText().toString());
                pricePopup.setText("$"+ waterMelonPriceAmount.getText().toString()+ "/KG");
                subtotalPopup.setText("$"+finalSubTot+ " Subtotal");
                cropImage.setImageResource(resource);

                imgResource = String.valueOf(R.drawable.water_melon);
                amountItems.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {


                        if (!(amountItems.getText().toString().trim().equals(""))){

                            amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                            subTotal = amountSet * cropPrice;
                            finalSubTot = df.format(subTotal);

                            subtotalPopup.setText("$"+ finalSubTot + " Subtotal");
                        }

                    }
                });
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(amountItems.getText().toString().trim().equals(""))){

                    amountSet = (int) Double.parseDouble(amountItems.getText().toString());
                    if (amountSet > 0){
                        numberOfItems = cropModalArrayList.size();
                        numberOfItems = numberOfItems + 1;
                        String numberOfItemsText = String.valueOf(numberOfItems);
                        cartAmount.setText(numberOfItemsText);



                        // on below line we are calling a method to add new
                        dbHandler.addNewCourse(cropNamePopup.getText().toString(), pricePopup.getText().toString(), finalSubTot, amountItems.getText().toString(), imgResource);

                        cropModalArrayList = dbHandler.readCrops();
                        double total = 0.00;
                        for (int i = 0; i < cropModalArrayList.size(); i++){
                            double subtringTemp = Double.parseDouble(cropModalArrayList.get(i).getSubtotal());
                            total = subtringTemp + total;

                        }

                        String totalString = df.format(total);
                        titleNumItems.setText("Total: $"+ totalString);
                        // after adding the data we are displaying a toast message.
                        Toast.makeText(BuyFruitsActivity.this, "1 item has been added to the cart.", Toast.LENGTH_LONG).show();

                        amountItems.setText("1");
                        cartPopup.setVisibility(View.INVISIBLE);



                    }else {

                        Toast.makeText(BuyFruitsActivity.this, "Amount cannot be 0.", Toast.LENGTH_SHORT).show();
                    }
                }else{

                    Toast.makeText(BuyFruitsActivity.this, "Amount cannot be empty.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cancelBTNPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountItems.setText("1");
                cartPopup.setVisibility(View.INVISIBLE);
            }
        });



        cartBTN = findViewById(R.id.cartFruits);



        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(BuyFruitsActivity.this);
        // below line is to add on click listener for our add course button.

        String finalCurrUser = currUser;
        cartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                String cropType = "fruits";
                Intent goToLoginActivity = new Intent(v.getContext(), ViewCrops.class);
                goToLoginActivity.putExtra("crop_type", cropType);
                goToLoginActivity.putExtra("currUser", finalCurrUser);
                v.getContext().startActivity(goToLoginActivity);
            }
        });


    }
}