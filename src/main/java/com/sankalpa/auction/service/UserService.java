package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(User updatedUser){
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User findbyEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    public List<Long> favorites(Long userId) {
        User user = getUser(userId);
        if (user != null) {
            List<Auction> auctions = user.getAuctionsParticipated();

            List<Long> auctionIds = new ArrayList<>();
            for (Auction auction : auctions) {
                auctionIds.add(auction.getAuctionId());
            }
            return auctionIds;
        } else {
            log.info("User Id is null in /users/{userId}/favorites");
            return new ArrayList<Long>();
        }
    }

}
