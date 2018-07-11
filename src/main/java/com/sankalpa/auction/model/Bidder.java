package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "BIDDER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class Bidder extends User {

    @OneToMany(mappedBy = "bidder", targetEntity = Bid.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bid> bids;

    @ManyToMany(targetEntity = Auction.class)
    private List<Auction> auctions;

    public Bidder(){}

    public Bidder(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    public Bidder(Long userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
    }

    public Bidder(String userEmail, String userPassword, String userName, String userPhone, String userAddress, String image) {
        super(userEmail, userPassword, userName, userPhone, userAddress, image);
    }

    public Bidder(Long userId, String userEmail, String userPassword, String userName, String userPhone, String userAddress, String image) {
        super(userId, userEmail, userPassword, userName, userPhone, userAddress, image);
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }
}
