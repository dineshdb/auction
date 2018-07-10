package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public @ResponseBody List<Item> getAllItems(){
        return itemService.getAllItems();
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
}
