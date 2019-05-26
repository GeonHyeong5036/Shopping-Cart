package com.sss.shoppingcart.Model;

public class Food {
    private String Name, Image, Description, Price, Nutrient, MenuId;

    public Food() {
    }

    public Food(String name, String image, String description, String price, String nutrient, String menuId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Nutrient = nutrient;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNutrient() {
        return Nutrient;
    }

    public void setNutrient(String nutrient) {
        Nutrient = nutrient;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
