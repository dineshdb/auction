package com.sankalpa.auction.websocket;

public class LiveUpdateMessage {
    public String auctionId;
    public String bidderId;
    public String itemId;

    public String bidAmount;
    public String bidDate;
    public String bidTime;

    public LiveUpdateMessage(String auctionId){
    	this.auctionId = auctionId;
    }

    public LiveUpdateMessage(){}

    public LiveUpdateMessage(String auctionId, String bidderId, String itemId, String bidAmount,
                             String bidDate, String bidTime) {
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.itemId = itemId;
        this.bidAmount = bidAmount;
        this.bidDate = bidDate;
        this.bidTime = bidTime;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidDate() {
        return bidDate;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }

    public String getBidTime() {
        return bidTime;
    }

    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }
}
