package com.sss.shoppingcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.sss.shoppingcart.Interface.ItemClickListener;
import com.sss.shoppingcart.Model.Food;
import com.sss.shoppingcart.ViewHolder.FoodViewHolder;

public class FoodCatalog extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference foodList;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String storeId="";

    FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Foods");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_food );
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent here
        if(getIntent() != null)
            storeId = getIntent().getStringExtra("StoreId");
        if(!storeId.isEmpty() && storeId != null){
            selectStore(storeId);
        }
    }

    private void selectStore(String storeId) {
        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,
                R.layout.food_item,
                FoodViewHolder.class,
                foodList.orderByChild("StoreId").equalTo(storeId)) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
                viewHolder.food_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.food_image);

                final Food local = model;

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent selectFood = new Intent(FoodCatalog.this, FoodDescription.class);
                        selectFood.putExtra("FoodId", adapter.getRef(position).getKey());
                        startActivity(selectFood);
                    }
                });
            }
        };

        //Set adapter
        recyclerView.setAdapter(adapter);
    }
}
