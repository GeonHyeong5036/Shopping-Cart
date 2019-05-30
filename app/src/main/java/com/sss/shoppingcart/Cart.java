package com.sss.shoppingcart;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sss.shoppingcart.Database.Database;
import com.sss.shoppingcart.Model.Select;
import com.sss.shoppingcart.ViewHolder.CartAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

//    FirebaseDatabase database;
//    DatabaseReference request;

    TextView txtTotalPrice;
    FButton btnPlace;

    List<Select> cart = new ArrayList<>();

    CartAdapter adapter;

    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        //Firebase
//        database = FirebaseDatabase.getInstance();
//        request = database.getReference("Requests");

        recyclerView = (RecyclerView) findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        txtTotalPrice = (TextView)findViewById(R.id.total);
        btnPlace = (FButton)findViewById(R.id.btnPlaceOrder);

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        loadListFood();
    }

    private void showAlertDialog(){
        AlertDialog.Builder alerDialog = new AlertDialog.Builder(Cart.this);
        alerDialog.setTitle("주문하겠습니까?");
        alerDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);
        alerDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Database(getBaseContext()).clearCart();
                finish();
            }
        });
        alerDialog.show();
    }

    private void loadListFood() {
        cart = new Database(this).getCart();
        adapter = new CartAdapter(cart, this);
        recyclerView.setAdapter(adapter);

        //Calculate total price
        int total = 0;
        for(Select select:cart)
            total += (Integer.parseInt(select.getPrice()))*(Integer.parseInt(select.getQuantity()));
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        setTotal(total);

        txtTotalPrice.setText(fmt.format(total));
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
