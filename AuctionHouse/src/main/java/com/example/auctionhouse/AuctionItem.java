package com.example.auctionhouse;

import java.time.LocalDate;

public class AuctionItem {
    public static String ItemName;
    public String Type;
    public String Description;
    public LocalDate OriginDate;
    public LocalDate SaleDate;
    public String SaleTime;
    public int AskingPrice;

    public AuctionItem(String itemName, String type, String description, LocalDate originDate, LocalDate saleDate, String saleTime, int askingPrice) {
        ItemName = itemName;
        Type = type;
        Description = description;
        OriginDate = originDate;
        SaleDate = saleDate;
        SaleTime = saleTime;
        AskingPrice = askingPrice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getOriginDate() {
        return OriginDate;
    }

    public void setOriginDate(LocalDate originDate) {
        OriginDate = originDate;
    }

    public LocalDate getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        SaleDate = saleDate;
    }

    public String getSaleTime() {
        return SaleTime;
    }

    public void setSaleTime(String saleTime) {
        SaleTime = saleTime;
    }

    public int getAskingPrice() {
        return AskingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        AskingPrice = askingPrice;
    }
    //public String Picture;


}
