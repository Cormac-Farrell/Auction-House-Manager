package com.example.auctionhouse;

public class SoldItems {
    public static String ItemName;
    public String Information;

    public SoldItems(String itemName, String information) {
        ItemName = itemName;
        Information = information;
    }

    public static String getItemName() {
        return ItemName;
    }

    public static void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

}
