package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Page<Item> getAllItems(Pageable pageable){
//        List<Item> items = new ArrayList<>();
//        itemRepository.findAll().forEach(items::add);
//        return items;
        return itemRepository.findAll(pageable);
    }

    public Set<Long> getAllItemIds(Pageable pageable){
        Set<Long> itemIds = new HashSet<>();
        Page<Item> pages = getAllItems(pageable);
        List<Item> items = pages.getContent();

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

    public Set<Long> searchItem(String queryString) {
        List<Item> items = itemRepository.findByitemName(queryString);
        Set<Long> itemIds = new HashSet<>();
        for (Item item : items){
            itemIds.add(item.getItemId());
        }
        return itemIds;
    }
}
