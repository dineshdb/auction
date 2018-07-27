package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public List<Long> getAllItemIds(){
        List<Long> itemIds = new ArrayList<>();
        List<Item> items = getAllItems();
        for (Item item : items){
            itemIds.add(item.getItemId());
        }
        return itemIds;
    }

    public Item addItem(Item newItem){
        return itemRepository.save(newItem);
    }

    public Item updateItem(Item updatedItem){
        return itemRepository.save(updatedItem);
    }

    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

    public Item getItem(Long itemId){
        return itemRepository.findById(itemId).orElse(null);
    }
}
