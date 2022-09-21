package com.example.auctionhouse;

public class Bidder {
    public static String Name;
    public String Address;
    public String Telephone;
    public String Email;

    public Bidder(String name, String address, String telephone, String email) {
        Name = name;
        Address = address;
        Telephone = telephone;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
