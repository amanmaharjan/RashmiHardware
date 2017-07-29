package com.example.aman.rashmihardware;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Aman on 7/25/2017.
 */

public class NailDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;

    // create constructor to initialize context and data sent from MainActivity
   public NailDetailAdapter(Context context, ArrayList<HashMap<String, String>> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }
    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.activity_nail_listview, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        myHolder.Category.setText(data.get(position).get("Category"));
        myHolder.Size.setText(data.get(position).get("Size"));
        myHolder.Qunntity.setText(data.get(position).get("Qunntity"));
        myHolder.ActuaPrice.setText(data.get(position).get("ActualPrice"));
        myHolder.SellingPrice.setText(data.get(position).get("SellingPrice"));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Category;
        TextView Size;
        TextView Qunntity;
        TextView ActuaPrice;
        TextView SellingPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Category= (TextView) itemView.findViewById(R.id.txt_nail_category);
            Size = (TextView) itemView.findViewById(R.id.txt_nail_Size);
            Qunntity = (TextView) itemView.findViewById(R.id.txt_nail_Quantity);
            ActuaPrice = (TextView) itemView.findViewById(R.id.txt_nail_ActualPrice);
            SellingPrice = (TextView) itemView.findViewById(R.id.txt_nail_SellingPrice);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();

        }

    }

}
