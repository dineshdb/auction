package com.sankalpa.auction.controller;

import com.sankalpa.auction.Holder.ItemRating;
import com.sankalpa.auction.Holder.UserRating;
import com.sankalpa.auction.model.Rating;
import com.sankalpa.auction.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RatingController {

    @Autowired
    RatingService ratingService;

    // save the rating in the database
    @GetMapping("/rate/user/{userId}/item/{itemId}/{rating}")
    public void rate(@PathVariable Long userId, @PathVariable Long itemId, @PathVariable int rating){
        ratingService.rate(userId, itemId, rating);
    }

    // returns the rating given by a user to a specific item
    @GetMapping("/rate/user/{userId}/item/{itemId}")
    public int ratingOfItemByUser(@PathVariable Long userId, @PathVariable Long itemId){
        Rating rating = ratingService.ratingOfItemByUser(userId, itemId);
        return rating.getRating();
    }

    // update the rating by a user to a specific item
    @GetMapping("/updateRating/user/{userId}/item/{itemId}/{rating}")
    public void updateRating(@PathVariable Long userId, @PathVariable Long itemId, @PathVariable int rating){
        Rating rating1 = ratingService.ratingOfItemByUser(userId, itemId);
        rating1.setRating(rating);
        ratingService.updateRating(rating1);
    }

    // returns the itemIds and the rating that a given user has rated
    @GetMapping("/getItems/user/{userId}")
    public Set<ItemRating> getItems(@PathVariable Long userId){
        return ratingService.getItems(userId);
    }

    // returns the userIds and the rating for a given item
    @GetMapping("/getUsers/item/{itemId}")
    public Set<UserRating> getUsers(@PathVariable Long itemId){
        return ratingService.getUsers(itemId);
    }
}
