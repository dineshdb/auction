package com.sankalpa.auction.service;

import com.sankalpa.auction.Holder.ItemRating;
import com.sankalpa.auction.Holder.UserRating;
import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Rating;
import com.sankalpa.auction.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }


    public Set<Long> getAllRatingIds(){

        List<Rating> ratings = getAllRatings();

        Set<Long> ratingIds = new HashSet<>();
        for (Rating rating : ratings){
            ratingIds.add(rating.getId());
        }

        return ratingIds;
    }

    public Rating updateRating(Rating updatedRating){
        return ratingRepository.save(updatedRating);
    }

    public Rating addRating(Rating newRating){
        return ratingRepository.save(newRating);
    }

    public void deleteRating(Long ratingId){
        ratingRepository.deleteById(ratingId);
    }

    public Rating getRating(Long ratingId){
        return ratingRepository.findById(ratingId).orElse(null);
    }

    public void rate(Long userId, Long itemId, int rating){
        addRating(new Rating(userId, itemId, rating));
    }

    public Rating ratingOfItemByUser(Long userId, Long itemId) {
        return ratingRepository.findByUserIdAndItemId(userId, itemId);
    }

    public Set<ItemRating> getItems(Long userId) {
        List<Rating> ratingList = ratingRepository.findAllByUserId(userId);
        Set<ItemRating> itemRatings = new HashSet<>();

        for (Rating rating : ratingList){
            itemRatings.add(new ItemRating(rating.getItemId(), rating.getRating()));
        }
        return itemRatings;
    }

    public Set<UserRating> getUsers(Long itemId) {
        List<Rating> ratingList = ratingRepository.findAllByItemId(itemId);
        Set<UserRating> userRatings = new HashSet<>();

        for (Rating rating : ratingList){
            userRatings.add(new UserRating(rating.getUserId(), rating.getRating()));
        }
        return userRatings;
    }
}
