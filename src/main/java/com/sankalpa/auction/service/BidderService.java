package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Bidder;
import com.sankalpa.auction.repository.BidderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidderService {

    @Autowired
    private BidderRepository bidderRepository;

    public List<Bidder> getAllBidders(){
        List<Bidder> bidders = new ArrayList<>();
        bidderRepository.findAll().forEach(bidders::add);
        return bidders;
    }

    public Bidder addBidder(Bidder newBidder){
        return bidderRepository.save(newBidder);
    }

    public Bidder updateBidder(Bidder updatedBidder){
        return bidderRepository.save(updatedBidder);
    }

    public void deleteBidder(Long bidderId){
        bidderRepository.deleteById(bidderId);
    }

    public Bidder getBidder(Long bidderId){
        return bidderRepository.findById(bidderId).orElse(null);
    }
}
