package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.model.Seller;
import com.sankalpa.auction.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        List<Seller> sellers = new ArrayList<>();
        sellerRepository.findAll().forEach(sellers::add);
        return sellers;
    }

    public Seller addSeller(Seller newSeller){
        return sellerRepository.save(newSeller);
    }

    public Seller updateSeller(Seller updatedSeller){
        return sellerRepository.save(updatedSeller);
    }

    public void deleteSeller(Long sellerId){
        sellerRepository.deleteById(sellerId);
    }

    public Seller getSeller(Long sellerId){
        return sellerRepository.findById(sellerId).orElse(null);
    }
}
