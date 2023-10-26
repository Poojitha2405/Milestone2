package com.example.MI_Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mi_farmer.R;

public class MainActivity extends AppCompatActivity {

    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.a1, R.drawable.a5, R.drawable.logo3};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }
}