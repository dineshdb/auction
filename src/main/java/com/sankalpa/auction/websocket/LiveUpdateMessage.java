package com.sankalpa.auction.websocket;

public class LiveUpdateMessage {
    public String auctionId;
    public int amount;
    public String username;
    public int userId;

    public LiveUpdateMessage(String id){
    	this.auctionId = id;
    }
}
