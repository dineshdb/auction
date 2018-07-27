package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "auctionId")
public class Auction {

    @Id
    @GeneratedValue
    private Long auctionId;

    private String auctionName;
    // TODO: deseralize LocalTime/LocalDate
    private LocalTime auctionTime;
    private LocalDate auctionDate;
    private String auctionDetails;
    private LocalTime auctionDuration;

    @ManyToOne
    private User seller;

    @OneToMany(mappedBy = "auction", targetEntity = Bid.class, cascade = CascadeType.REMOVE)
    private List<Bid> bids;

    @OneToMany(mappedBy = "auction", targetEntity = Item.class, cascade = CascadeType.REMOVE)
    private List<Item> items;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(joinColumns = @JoinColumn(name = "auction_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> bidders;

    public Auction(){}

    public Auction(Long auctionId, String auctionName, String auctionTime,
                   String auctionDate, String auctionDetails, String auctionDuration) {
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.auctionTime = LocalTime.parse(auctionTime);
        this.auctionDate = LocalDate.parse(auctionDate);
        this.auctionDetails = auctionDetails;
        this.auctionDuration = LocalTime.parse(auctionDuration);
    }

    public Auction(String auctionName, LocalTime auctionTime, LocalDate auctionDate, String auctionDetails,
                   LocalTime auctionDuration) {
        this.auctionName = auctionName;
        this.auctionTime = auctionTime;
        this.auctionDate = auctionDate;
        this.auctionDetails = auctionDetails;
        this.auctionDuration = auctionDuration;
    }

    public void setAuctionTime(LocalTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    public void setAuctionDate(LocalDate auctionDate) {
        this.auctionDate = auctionDate;
    }

    public void setAuctionDuration(LocalTime auctionDuration) {
        this.auctionDuration = auctionDuration;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<User> getBidders() {
        return bidders;
    }

    public void setBidders(List<User> bidders) {
        this.bidders = bidders;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getAuctionTime() {
        return auctionTime.toString();
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = LocalTime.parse(auctionTime);
    }

    public String getAuctionDate() {
        return auctionDate.toString();
    }

    public void setAuctionDate(String auctionDate) {
        this.auctionDate = LocalDate.parse(auctionDate);
    }

    public String getAuctionDetails() {
        return auctionDetails;
    }

    public void setAuctionDetails(String auctionDetails) {
        this.auctionDetails = auctionDetails;
    }

    public String getAuctionDuration() {
        return auctionDuration.toString();
    }

    public void setAuctionDuration(String auctionDuration) {
        this.auctionDuration = LocalTime.parse(auctionDuration);
    }
}
