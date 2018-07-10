package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Seller;
import com.sankalpa.auction.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellers")
    public @ResponseBody List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @GetMapping("/sellers/{sellerId}")
    public @ResponseBody Seller getSeller(@PathVariable Long sellerId){
        return sellerService.getSeller(sellerId);
    }

    @PostMapping("/sellers")
    public @ResponseBody Seller addSeller(@RequestBody Seller newSeller){
        return sellerService.addSeller(newSeller);
    }

    @PutMapping("/sellers")
    public @ResponseBody Seller updateSeller(@RequestBody Seller updatedSeller){
        return sellerService.updateSeller(updatedSeller);
    }

    @DeleteMapping("/sellers/{sellerId}")
    public void deleteSeller(@PathVariable Long sellerId){
        sellerService.deleteSeller(sellerId);
    }
}
