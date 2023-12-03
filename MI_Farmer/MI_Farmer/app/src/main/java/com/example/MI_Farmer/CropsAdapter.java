package com.example.MI_Farmer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mi_farmer.R;

import java.util.ArrayList;

public class CropsAdapter extends RecyclerView.Adapter<CropsAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<CropModal> cropModalArrayList;
    private Context context;

    public DBHandler dbHandler;

    // constructor
    public CropsAdapter(ArrayList<CropModal> cropModalArrayList,DBHandler dbHandler, Context context) {
        this.cropModalArrayList = cropModalArrayList;
        this.context = context;
        this.dbHandler= dbHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crop_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CropModal modal = cropModalArrayList.get(position);
        holder.cropNameCart.setText("Crop: "+ modal.getCropName());
        holder.priceCart.setText("Price: "+modal.getPrice());
        holder.subtotalCart.setText("Subtotal: "+modal.getSubtotal());
        holder.cropImage.setImageResource(Integer.valueOf(modal.getImgResource()));

        holder.numberOfItemsCart.setText("Amount: "+modal.getAmount());

        holder.cancelCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempID = String.valueOf(modal.getId());
                int deleted = dbHandler.deleteCrop(tempID);
                int dt = deleted;

                cropModalArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cropModalArrayList.size());
            }
        });

        int resource = Integer.parseInt(modal.getImgResource());
        holder.cropImage.setImageResource(resource);
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return cropModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Creating variables for our text views.
        private TextView cropNameCart, priceCart, subtotalCart, numberOfItemsCart;

        private ImageView cropImage;

        private ImageButton cancelCartItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            cropNameCart = itemView.findViewById(R.id.cropNameCart);
            priceCart = itemView.findViewById(R.id.priceCart);
            subtotalCart = itemView.findViewById(R.id.subtotalCart);
            numberOfItemsCart = itemView.findViewById(R.id.numItemsCart);

            cancelCartItem = itemView.findViewById(R.id.cancelCart);
            cropImage = itemView.findViewById(R.id.cropImage);
        }
    }
}

