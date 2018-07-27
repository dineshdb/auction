package com.sankalpa.auction.service;

import com.sankalpa.auction.Holder.AuctionHolder;
import com.sankalpa.auction.Holder.ItemHolder;
import com.sankalpa.auction.model.*;
import com.sankalpa.auction.repository.AuctionRepository;
import com.sankalpa.auction.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BidService bidService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    private static final Logger log = LoggerFactory.getLogger(AuctionService.class);


    // TODO: change all the lists into Set.
    public List<Auction> getAllAuctions(){
        List<Auction> auctions = new ArrayList<>();
        auctionRepository.findAll().forEach(auctions::add);
        return auctions;
    }


    public List<Auction> getAllAuctionOnDate(LocalDate today) {
        return auctionRepository.findAllByAuctionDate(today);
    }

    public List<Long> getAllAuctionIds(){
        List<Long> auctionIds = new ArrayList<>();
        List<Auction> auctions = getAllAuctions();
        for (Auction auction : auctions){
            auctionIds.add(auction.getAuctionId());
        }
        return auctionIds;
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

    public Auction createAuction(AuctionHolder auctionHolder) {
        // TODO: handle editing and deletion of auction

        log.info(auctionHolder.toString());

        String auctionName = auctionHolder.getAuctionName();
        LocalTime auctionTime = LocalTime.parse(auctionHolder.getAuctionTime());
        LocalDate auctionDate = LocalDate.parse(auctionHolder.getAuctionDate());
        String auctionDetails = auctionHolder.getAuctionDetails();
        LocalTime auctionDuration = LocalTime.parse(auctionHolder.getAuctionDuration());
        Auction auction = addAuction(new Auction(auctionName, auctionTime, auctionDate, auctionDetails,
                auctionDuration));

        Long seller = auctionHolder.getSeller();
        auction.setSeller(userService.getUser(seller));

        List<Long> bidders = auctionHolder.getBidders();
        for (Long id : bidders){
            User bidder = userService.getUser(id);
            auction.getBidders().add(bidder);
        }

        List<Long> bids = auctionHolder.getBids();
        for (Long id : bids){
            Bid bid = bidService.getBid(id);
            auction.getBids().add(bid);
        }

        List<ItemHolder> itemHolders = auctionHolder.getItemHolderList();
        List<Item> items = new ArrayList<>();

            for (ItemHolder itemHolder : itemHolders) {

                String itemName = itemHolder.getItemName();
                String itemDescription = itemHolder.getItemDescription();
                double startingBid = itemHolder.getStartingBid();
                String image = itemHolder.getImage();

                List<Long> itemCategories = itemHolder.getItemCategories();
                Long seller_item = itemHolder.getSeller();
                Long auction_item = itemHolder.getAuction();   // nope
                List<Long> bids_item = itemHolder.getBids();

                Item item = itemService.addItem(new Item(itemName, itemDescription, startingBid, image));
                item.setSeller(userService.getUser(seller_item));

                // add categories
                List<Category> categories = new ArrayList<>();
                for (Long cat : itemCategories) {
                    categories.add(categoryService.getCategory(cat));
                }
                item.setItemCategories(categories);

                // update the item finally
                item.setAuction(auction);
                item = itemService.updateItem(item);
//                auction.getItems().add(item);
                items.add(item);
            }

        // set items for auction
        auction.setItems(items);
        return updateAuction(auction);
    }
}
