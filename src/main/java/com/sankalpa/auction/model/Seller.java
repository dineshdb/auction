package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "SELLER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class Seller extends User {

    // TODO: add relationships with items, events

    @OneToMany(mappedBy = "seller", targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Item> items;

    @OneToMany(mappedBy = "seller", targetEntity = Auction.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Auction> auctions;

    public Seller(){}

    public Seller(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    public Seller(Long userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
    }

    public Seller(String userEmail, String userPassword, String userName, String userPhone, String userAddress,
                  String image) {
        super(userEmail, userPassword, userName, userPhone, userAddress, image);
    }

    public Seller(Long userId, String userEmail, String userPassword, String userName, String userPhone,
                  String userAddress, String image) {
        super(userId, userEmail, userPassword, userName, userPhone, userAddress, image);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }
}
