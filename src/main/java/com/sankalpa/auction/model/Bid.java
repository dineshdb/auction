package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bidId")
public class Bid {

    @Id
    @GeneratedValue
    private Long bidId;

    private double bidAmount;
    private LocalTime bidTime;
    private LocalDate bidDate;
    private String description;

    @ManyToOne
    private Auction auction;

    @ManyToOne
    private Item item;

    @ManyToOne
    private User bidder;

    public Bid(){}

    public Bid(double bidAmount, String bidTime, String bidDate, String description) {
        this.bidAmount = bidAmount;
        this.bidTime = LocalTime.parse(bidTime);
        this.bidDate = LocalDate.parse(bidDate);
        this.description = description;
    }

    public Bid(Long bidId, double bidAmount, String bidTime, String bidDate, String description) {
        this.bidId = bidId;
        this.bidAmount = bidAmount;
        this.bidTime = LocalTime.parse(bidTime);
        this.bidDate = LocalDate.parse(bidDate);
        this.description = description;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidTime() {
        return bidTime.toString();
    }

    public void setBidTime(String bidTime) {
        this.bidTime = LocalTime.parse(bidTime);
    }

    public String getBidDate() {
        return bidDate.toString();
    }

    public void setBidDate(String bidDate) {
        this.bidDate = LocalDate.parse(bidDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
