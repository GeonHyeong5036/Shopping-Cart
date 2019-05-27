package com.sss.shoppingcart.Model;

public class Store {
    private String Name, Image, Description, PhoneNumber, Cook, Address;

    public Store() {
    }

    public Store(String name, String image, String description, String phoneNumber, String cook, String address) {
        Name = name;
        Image = image;
        Description = description;
        PhoneNumber = phoneNumber;
        Cook = cook;
        Address = address;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCook() {
        return Cook;
    }

    public void setCook(String cook) {
        Cook = cook;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
