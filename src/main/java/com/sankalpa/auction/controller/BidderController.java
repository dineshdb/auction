package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Bidder;
import com.sankalpa.auction.service.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BidderController {

    @Autowired
    private BidderService bidderService;

    @GetMapping("/bidders")
    public @ResponseBody List<Bidder> getAllBidders(){
        return bidderService.getAllBidders();
    }

    @GetMapping("/bidders/{bidderId}")
    public @ResponseBody Bidder getBidder(@PathVariable Long bidderId){
        return bidderService.getBidder(bidderId);
    }

    @PostMapping("/bidders")
    public @ResponseBody Bidder addBidder(@RequestBody Bidder newBidder){
        return bidderService.addBidder(newBidder);
    }

    @PutMapping("/bidders")
    public @ResponseBody Bidder updateBidder(@RequestBody Bidder updatedBidder){
        return bidderService.updateBidder(updatedBidder);
    }

    @DeleteMapping("/bidders/{bidderId}")
    public void deleteBidder(@PathVariable Long bidderId){
        bidderService.deleteBidder(bidderId);
    }
}
