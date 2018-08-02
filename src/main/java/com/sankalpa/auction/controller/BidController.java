package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Bid;
import com.sankalpa.auction.service.BidService;
import com.sankalpa.auction.websocket.LiveUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/bids")
    public @ResponseBody Set<Bid> getAllBids(){
        return bidService.getAllBids();
    }

    @GetMapping("/bids/{bidId}")
    public @ResponseBody Bid getBid(@PathVariable Long bidId){
        return bidService.getBid(bidId);
    }

    @PostMapping("/bids")
    public @ResponseBody Bid addBid(@RequestBody Bid newBid){
        return bidService.addBid(newBid);
    }

    @PutMapping("/bids")
    public @ResponseBody Bid updateBid(@RequestBody Bid updatedBid){
        return bidService.updateBid(updatedBid);
    }

    @DeleteMapping("/bids/{bidId}")
    public void deleteBid(@PathVariable Long bidId){
        bidService.deleteBid(bidId);
    }

    @PostMapping("/bids/saveBid")
    public void saveBid(@RequestBody LiveUpdateMessage update){
        bidService.saveBid(update);
    }
}
