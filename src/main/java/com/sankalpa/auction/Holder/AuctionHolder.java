package com.sankalpa.auction.Holder;

import com.sankalpa.auction.model.Bid;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.model.User;

import java.util.List;

public class AuctionHolder {

    private String auctionName;
    private String auctionTime;
    private String auctionDate;
    private String auctionDetails;
    private String auctionDuration;

    private List<ItemHolder> itemHolderList;
    private Long seller;
    private List<Long> bids;
    private List<Long> bidders;

    public AuctionHolder() {
    }

    public AuctionHolder(String auctionName, String auctionTime, String auctionDate, String auctionDetails,
                         String auctionDuration, List<ItemHolder> itemHolderList, Long seller, List<Long> bids,
                         List<Long> bidders) {
        this.auctionName = auctionName;
        this.auctionTime = auctionTime;
        this.auctionDate = auctionDate;
        this.auctionDetails = auctionDetails;
        this.auctionDuration = auctionDuration;
        this.itemHolderList = itemHolderList;
        this.seller = seller;
        this.bids = bids;
        this.bidders = bidders;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Auction name " + auctionName);
        str.append("\nAuction date " + auctionDate);
        str.append("\nAuction time " + auctionTime);
        str.append("\nAuction details " + auctionDetails);
        return str.toString();
    }

    public List<ItemHolder> getItemHolderList() {
        return itemHolderList;
    }

    public void setItemHolderList(List<ItemHolder> itemHolderList) {
        this.itemHolderList = itemHolderList;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    public String getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(String auctionDate) {
        this.auctionDate = auctionDate;
    }

    public String getAuctionDetails() {
        return auctionDetails;
    }

    public void setAuctionDetails(String auctionDetails) {
        this.auctionDetails = auctionDetails;
    }

    public String getAuctionDuration() {
        return auctionDuration;
    }

    public void setAuctionDuration(String auctionDuration) {
        this.auctionDuration = auctionDuration;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }

    public List<Long> getBids() {
        return bids;
    }

    public void setBids(List<Long> bids) {
        this.bids = bids;
    }

    public List<Long> getBidders() {
        return bidders;
    }

    public void setBidders(List<Long> bidders) {
        this.bidders = bidders;
    }
}