package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemId")
public class Item {

    @Id
    @GeneratedValue
    private Long itemId;

    private String itemName;
    private String itemDescription;
    private double startingBid;
    private String image;           // image stores the location of image on disk

    @ManyToOne
    private State itemState;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "itemId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> itemCategories;

    @ManyToOne
    private User seller;

    @ManyToOne
    private Auction auction;

    @OneToMany(mappedBy = "item", targetEntity = Bid.class, cascade = CascadeType.REMOVE)
    private Set<Bid> bids;

    protected Item(){}

    public Item(Long itemId, String itemName, String itemDescription, double startingBid, String image) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startingBid = startingBid;
        this.image = image;
    }

    public Item(String itemName, String itemDescription, double startingBid, String image) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startingBid = startingBid;
        this.image = image;
    }

    public Set<Bid> getBids() {
        if (bids == null){
            bids = new HashSet<>();
        }
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public State getItemState() {
        return itemState;
    }

    public void setItemState(State itemState) {
        this.itemState = itemState;
    }

    public Set<Category> getItemCategories() {
        if (itemCategories == null){
            itemCategories = new HashSet<>();
        }
        return itemCategories;
    }

    public void setItemCategories(Set<Category> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
