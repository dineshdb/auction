package com.sankalpa.auction.controller;

import com.sankalpa.auction.Holder.AuctionHolder;
import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/auctions")
    public @ResponseBody List<Long> getAllAuctionIds(){
        return auctionService.getAllAuctionIds();
    }

    @GetMapping("/auctions/{auctionId}")
    public @ResponseBody Auction getAuction(@PathVariable Long auctionId){
        return auctionService.getAuction(auctionId);
    }

    @PostMapping("/auctions")
    public @ResponseBody Auction addAuction(@RequestBody Auction newAuction){
        return auctionService.addAuction(newAuction);
    }

    @PutMapping("/auctions")
    public @ResponseBody Auction updateAuction(@RequestBody Auction updatedAuction){
        return auctionService.updateAuction(updatedAuction);
    }

    @DeleteMapping("/auctions/{auctionId}")
    public void deleteAuction(@PathVariable Long auctionId){
        auctionService.deleteAuction(auctionId);
    }

    @PostMapping("/auctions/createAuction")
    public Auction createAcution(@RequestBody AuctionHolder auctionHolder){
        return auctionService.createAuction(auctionHolder);
    }

    @PostMapping("/auctions/participate/{bidderId}")
    public void participate(@PathVariable Long bidderId){
        // TODO: add the bidder to the auction
    }
}
