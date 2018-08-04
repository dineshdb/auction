package com.sankalpa.auction.Holder;

public class UserRating {
    private Long userId;
    private int rating;

    public UserRating(){}

    public UserRating(Long userId, int rating) {
        this.userId = userId;
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
