package com.sankalpa.auction.Holder;

public class AuctionWatchInfo {

    private String auctionId;
    private String action;

    public AuctionWatchInfo(){}

    public AuctionWatchInfo(String auctionId, String action) {
        this.auctionId = auctionId;
        this.action = action;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
