package com.sankalpa.auction.Holder;

public class ItemRating {
    private Long itemId;
    private int rating;

    public ItemRating(){}

    public ItemRating(Long itemId, int rating) {
        this.itemId = itemId;
        this.rating = rating;
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
