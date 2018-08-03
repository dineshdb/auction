package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long itemId;
    private int rating;

    public Rating(){}

    public Rating(Long userId, Long itemId, int rating) {
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
    }

    public Rating(Long id, Long userId, Long itemId, int rating) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
