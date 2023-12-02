package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mi_farmer.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class UploadInfoActivity extends AppCompatActivity {

    private final int SELECT_PHOTO = 1;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_info);

        ImageButton backButton = (ImageButton)findViewById(R.id.backB);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });

        CardView sellCard = (CardView) findViewById(R.id.sellCardInfo);
        Button uploadButton = (Button) findViewById(R.id.btn_upload_crop);

        imageView = (ImageView) findViewById(R.id.image_view23);
        sellCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginActivity = new Intent(v.getContext(), LandingActivity.class);
                v.getContext().startActivity(goToLoginActivity);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}