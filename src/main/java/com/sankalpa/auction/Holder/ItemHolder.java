package com.sankalpa.auction.Holder;

import java.util.List;

public class ItemHolder {

    private String itemName;
    private String itemDescription;
    private double startingBid;
    private String image;

    private List<Long> itemCategories;
    private Long seller;
    private Long auction;

    private List<Long> bids;

    public ItemHolder(){}


    // error because of constructor mismatch
    public ItemHolder(String itemName, String itemDescription, double startingBid, String image,
                      List<Long> itemCategories, Long seller, List<Long> bids) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startingBid = startingBid;
        this.image = image;
        this.itemCategories = itemCategories;
        this.seller = seller;
        this.bids = bids;
    }

    public List<Long> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(List<Long> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }

    public Long getAuction() {
        return auction;
    }

    public void setAuction(Long auction) {
        this.auction = auction;
    }

    public List<Long> getBids() {
        return bids;
    }

    public void setBids(List<Long> bids) {
        this.bids = bids;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
