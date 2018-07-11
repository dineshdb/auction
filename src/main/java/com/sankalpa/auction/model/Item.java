package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    private State itemState;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "itemId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> itemCategories;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Auction auction;

    @OneToMany(mappedBy = "item", targetEntity = Bid.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bid> bids;

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

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public State getItemState() {
        return itemState;
    }

    public void setItemState(State itemState) {
        this.itemState = itemState;
    }

    public List<Category> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(List<Category> itemCategories) {
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
