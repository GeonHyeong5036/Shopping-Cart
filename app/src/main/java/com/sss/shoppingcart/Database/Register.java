package com.sss.shoppingcart.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.sss.shoppingcart.Model.LineItem;

import java.util.ArrayList;
import java.util.List;

public class Register extends SQLiteAssetHelper {
    private static final String DB_NAME = "EatItDB.db";

    private static final int DB_VER=1;

    public Register(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<LineItem> getOrderForm(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ProductId", "ProductName","Quantity","Price"};
        String sqlTable="selectDetail";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, null,null,null,null,null);

        final List<LineItem> result = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                result.add(new LineItem(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price"))
                        ));
            }while (c.moveToNext());
        }
        return result;
    }

    public void addToCart(LineItem lineItem){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO selectDetail(ProductId, ProductName, Quantity, Price) VALUES('%s', '%s', '%s', '%s');",
                lineItem.getFoodId(),
                lineItem.getFoodName(),
                lineItem.getQuantity(),
                lineItem.getPrice());
        db.execSQL(query);
    }

    public void clearCart(){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM selectDetail");
        db.execSQL(query);
    }
}
