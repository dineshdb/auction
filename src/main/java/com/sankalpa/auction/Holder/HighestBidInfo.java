package com.sankalpa.auction.Holder;

public class HighestBidInfo {

    private String highestBidderId;
    private String highestBidAmount;
    private String highestBidId;

    private String itemId;
    private String auctionId;

    public HighestBidInfo(){}

    public HighestBidInfo(String highestBidderId, String highestBidAmount, String highestBidId,
                          String itemId, String auctionId) {
        this.highestBidderId = highestBidderId;
        this.highestBidAmount = highestBidAmount;
        this.highestBidId = highestBidId;
        this.itemId = itemId;
        this.auctionId = auctionId;
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

    public String getHighestBidId() {
        return highestBidId;
    }

    public void setHighestBidId(String highestBidId) {
        this.highestBidId = highestBidId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }
}
