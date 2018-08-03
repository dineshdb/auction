package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "userRole")
@DiscriminatorValue(value = "USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User {

    @Id
    @GeneratedValue     // TODO: Tweak the generated value type
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    //@JsonIgnore
    private String userPassword;

    private String userName;
    private String userPhone;
    private String userAddress;
    private String image;

    @OneToMany(mappedBy = "seller", targetEntity = Item.class, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Item> items;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", targetEntity = Auction.class, cascade = CascadeType.REMOVE)
    private Set<Auction> auctionsCreated;

    @JsonIgnore
    @OneToMany(mappedBy = "bidder", targetEntity = Bid.class, cascade = CascadeType.REMOVE)
    private Set<Bid> bids;

    @JsonIgnore
    @ManyToMany(targetEntity = Auction.class)
    private Set<Auction> auctionsParticipated;

    protected User(){}

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(Long userId, String userEmail, String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(String userEmail, String userPassword, String userName, String userPhone, String userAddress, String image) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.image = image;
    }

    public User(Long userId, String userEmail, String userPassword, String userName, String userPhone, String userAddress, String image) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.image = image;
    }

    @Transient
    public String getRole(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? null : val.value();
    }

    public Set<Auction> getAuctionsCreated() {
        return auctionsCreated;
    }

    public void setAuctionsCreated(Set<Auction> auctionsCreated) {
        this.auctionsCreated = auctionsCreated;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Set<Auction> getAuctionsParticipated() {
        return auctionsParticipated;
    }

    public void setAuctionsParticipated(Set<Auction> auctionsParticipated) {
        this.auctionsParticipated = auctionsParticipated;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
