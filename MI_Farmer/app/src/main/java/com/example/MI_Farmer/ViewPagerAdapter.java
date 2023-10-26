package com.example.MI_Farmer;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mi_farmer.R;

import java.util.Objects;

class ViewPagerAdapter extends PagerAdapter {

    // Context object
    Context context;

    // Array of images
    int[] images;

    // Layout Inflater
    LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // return the number of images
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.item, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
        TextView textHead = (TextView) itemView.findViewById(R.id.headTitle);
        Button joinUs = (Button) itemView.findViewById(R.id.joinUs);
        // setting the image in the imageView
        imageView.setImageResource(images[position]);

        if (position == 0){
            textHead.setText("Homegrown & organic");
            joinUs.setVisibility(View.INVISIBLE);

        }else if (position == 1){
            textHead.setText("Mother Nature's gift to us all");
            joinUs.setVisibility(View.INVISIBLE);

        }else{

            textHead.setText("");
            joinUs.setVisibility(View.VISIBLE);

            joinUs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent joinUSIntent = new Intent(v.getContext(), LoginActivity.class);
                    v.getContext().startActivity(joinUSIntent);
                }
            });
        }

        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}

