package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Bid;
import com.sankalpa.auction.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public List<Bid> getAllBids(){
        List<Bid> bids = new ArrayList<>();
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
}
