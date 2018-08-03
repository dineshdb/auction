package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE upper(i.itemName) LIKE CONCAT('%', upper(:queryString), '%')")
    List<Item> findByitemName(String queryString);
}
