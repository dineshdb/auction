package com.sankalpa.auction.controller;

import com.sankalpa.auction.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/rate/user/{userId}/item/{itemId}/{rating}")
    public void rate(@PathVariable Long userId, @PathVariable Long itemId, @PathVariable int rating){
        ratingService.rate(userId, itemId, rating);
    }
}
