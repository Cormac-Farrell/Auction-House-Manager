package com.example.auctionhouse;

import java.time.LocalDate;

public class Bids {
    public static String Item;
    public String Bidder;
    public String BidTime;
    public LocalDate BidDate;
    public int Amount;


    public Bids(String item, String bidder, String bidTime, LocalDate bidDate, int amount) {
        Item = item;
        Bidder = bidder;
        BidTime = bidTime;
        BidDate = bidDate;
        Amount = amount;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getBidder() {
        return Bidder;
    }

    public void setBidder(String bidder) {
        Bidder = bidder;
    }

    public String getBidTime() {
        return BidTime;
    }

    public void setBidTime(String bidTime) {
        BidTime = bidTime;
    }

    public LocalDate getBidDate() {
        return BidDate;
    }

    public void setBidDate(LocalDate bidDate) {
        BidDate = bidDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
