package com.sankalpa.auction.controller;

import com.sankalpa.auction.Holder.AuctionHolder;
import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Bid;
import com.sankalpa.auction.model.User;
import com.sankalpa.auction.service.AuctionService;
import com.sankalpa.auction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public @ResponseBody Set<Long> getAllAuctionIds(){
        Set<Long> auctionIds = auctionService.getAllAuctionIds();
        return auctionIds;
    }

    @PostMapping("/")
    public @ResponseBody Auction addAuction(@RequestBody Auction newAuction){
        return auctionService.addAuction(newAuction);
    }

    @GetMapping("/{auctionId}")
    public @ResponseBody Auction getAuction(@PathVariable Long auctionId){
        return auctionService.getAuction(auctionId);
    }

    @PutMapping("/")
    public @ResponseBody Auction updateAuction(@RequestBody Auction updatedAuction){
        return auctionService.updateAuction(updatedAuction);
    }

    @DeleteMapping("/{auctionId}")
    public void deleteAuction(@PathVariable Long auctionId){
        auctionService.deleteAuction(auctionId);
    }

    @PostMapping("/createAuction")
    public Auction createAcution(@RequestBody AuctionHolder auctionHolder){
        Auction auction = auctionService.createAuction(auctionHolder);
        //auctionService.schedule(auction);
        return auction;
    }

    @Deprecated
    @GetMapping("/{auctionId}/participate")
    public void participate(@PathVariable("auctionId") Long auctionId, Authentication authentication){
        User user = userService.findbyEmail(authentication.getName());
        log.info("User with id " + user.getUserId() + " participates in auction " + auctionId);
        Long bidderId = user.getUserId();
        auctionService.participate(auctionId, bidderId);
    }

    @Deprecated
    @GetMapping("/{auctionId}/unsubscribe/{bidderId}")
    public void unsubscribe(@PathVariable("auctionId") Long auctionId, @PathVariable("bidderId") Long bidderId){
        auctionService.unsubscribe(auctionId, bidderId);
    }

    @GetMapping("/{auctionId}/bids")
    public Set<Bid> allBids(@PathVariable Long auctionId){
        return auctionService.allBids(auctionId);
    }

    @GetMapping("/{auctionId}/favorite")
    public void favorite(@PathVariable Long auctionId, Authentication authentication){
        User user = userService.findbyEmail(authentication.getName());
        log.info("User with id " + user.getUserId() + " participates in auction " + auctionId);
        auctionService.participate(auctionId, user.getUserId());
    }

    @GetMapping("/{auctionId}/unfavorite")
    public void unfavorite(@PathVariable Long auctionId, Authentication authentication){
        User user = userService.findbyEmail(authentication.getName());
        log.info("User with id " + user.getUserId() + " unsubscribes in auction " + auctionId);
        auctionService.unsubscribe(auctionId, user.getUserId());
    }
}
