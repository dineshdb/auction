package com.sankalpa.auction.service;

import com.sankalpa.auction.Holder.HighestBidInfo;
import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Bid;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repository.BidRepository;
import com.sankalpa.auction.websocket.LiveUpdateController;
import com.sankalpa.auction.websocket.LiveUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private LiveUpdateController liveUpdateController;

    public Set<Bid> getAllBids(){
        Set<Bid> bids = new HashSet<>();
        bidRepository.findAll().forEach(bids::add);
        return bids;
    }

    public Bid addBid(Bid newBid){
        return bidRepository.save(newBid);
    }

    public Bid updateBid(Bid updatedBid){
        return bidRepository.save(updatedBid);
    }

    public void deleteBid(Long bidId){
        bidRepository.deleteById(bidId);
    }

    public Bid getBid(Long bidId){
        return bidRepository.findById(bidId).orElse(null);
    }

    public void saveBid(LiveUpdateMessage update) {

        String auctionId = update.getAuctionId();
        String bidderId = update.getBidderId();
        String itemId = update.getItemId();

        double bidAmount = Double.valueOf(update.getBidAmount());
        String bidDate = update.getBidDate();
        String bidTime = update.getBidTime();

        Auction auction = auctionService.getAuction(Long.valueOf(auctionId));
        User bidder = userService.getUser(Long.valueOf(bidderId));
        Item item = itemService.getItem(Long.valueOf(itemId));

        Bid bid = addBid(new Bid(bidAmount, bidTime, bidDate, ""));

        bid.setAuction(auction);
        auction.getBids().add(bid);

        bid.setBidder(bidder);
        bidder.getBids().add(bid);

        bid.setItem(item);
        item.getBids().add(bid);

        updateBid(bid);
        itemService.updateItem(item);
        userService.updateUser(bidder);
        auctionService.updateAuction(auction);

        // get the highest bid
        // TODO: make this shaZam cool
//        List<Bid> bids = item.getBids();
//        Bid highestBid = bids.get(0);
//        for (Bid b : bids){
//            if (b.getBidAmount() > highestBid.getBidAmount()){
//                highestBid = b;
//            }
//        }
//        User highestBidder = highestBid.getBidder();
//        liveUpdateController.sendHighestBid(auction.getAuctionId(),
//                item.getItemId().toString(),
//                highestBidder.getUserId().toString(),
//                highestBid.getBidId().toString(),
//                String.valueOf(highestBid.getBidAmount()));

        liveUpdateController.sendBid(Long.valueOf(auctionId), bidderId, String.valueOf(bidAmount));
    }
}
