package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @GetMapping("/items")
//    public @ResponseBody Set<Long> getAllItemIds(Pageable pageable){
//        return itemService.getAllItemIds(pageable);
//    }

    @GetMapping("/items")
    public @ResponseBody Set<Long> getAllItemIds(){
      return itemService.getAllItemIds();
    }

    @GetMapping("/items/{itemId}")
    public @ResponseBody Item getItem(@PathVariable Long itemId){
        return itemService.getItem(itemId);
    }

    @PostMapping("/items")
    public @ResponseBody Item addItem(@RequestBody Item newItem){
        return itemService.addItem(newItem);
    }

    @PutMapping("/items")
    public @ResponseBody Item updateItem(@RequestBody Item updatedItem){
        return itemService.updateItem(updatedItem);
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
    }

    @GetMapping("/search/{queryString}")
    public Set<Long> searchItem(@PathVariable String queryString){
        return itemService.searchItem(queryString);
    }
}
