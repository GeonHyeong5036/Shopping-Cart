package com.sss.shoppingcart.Model;

public class LineItem {
    private String FoodId;
    private String FoodName;
    private String Quantity;
    private String Price;

    public LineItem() {
    }

    public LineItem(String foodId, String foodName, String quantity, String price) {
        FoodId = foodId;
        FoodName = foodName;
        Quantity = quantity;
        Price = price;
    }

    public String getFoodId() {
        return FoodId;
    }

    public void setFoodId(String foodId) {
        FoodId = foodId;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
