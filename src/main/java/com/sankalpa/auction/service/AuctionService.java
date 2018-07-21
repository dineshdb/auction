package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Admin;
import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAllAuctions(){
        List<Auction> auctions = new ArrayList<>();
        auctionRepository.findAll().forEach(auctions::add);
        return auctions;
    }

    public Auction updateAuction(Auction updatedAuction){
        return auctionRepository.save(updatedAuction);
    }

    public Auction addAuction(Auction newAuction){
        return auctionRepository.save(newAuction);
    }

    public void deleteAuction(Long auctionId){
        auctionRepository.deleteById(auctionId);
    }

    public Auction getAuction(Long auctionId){
        return auctionRepository.findById(auctionId).orElse(null);
    }
}
