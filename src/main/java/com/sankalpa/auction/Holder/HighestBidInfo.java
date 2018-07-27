package com.sankalpa.auction.Holder;

public class HighestBidInfo {

    private String highestBidderId;
    private String highestBidAmount;

    public HighestBidInfo(){}

    public HighestBidInfo(String highestBidderId, String highestBidAmount) {
        this.highestBidderId = highestBidderId;
        this.highestBidAmount = highestBidAmount;
    }

    public String getHighestBidderId() {
        return highestBidderId;
    }

    public void setHighestBidderId(String highestBidderId) {
        this.highestBidderId = highestBidderId;
    }

    public String getHighestBidAmount() {
        return highestBidAmount;
    }

    public void setHighestBidAmount(String highestBidAmount) {
        this.highestBidAmount = highestBidAmount;
    }
}
