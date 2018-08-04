package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r FROM Rating r WHERE r.userId=:userId AND r.itemId=:itemId")
    Rating findByUserIdAndItemId(Long userId, Long itemId);

    @Query("SELECT r FROM Rating r WHERE r.userId=:userId")
    List<Rating> findAllByUserId(Long userId);

    @Query("SELECT r FROM Rating r WHERE r.itemId=:itemId")
    List<Rating> findAllByItemId(Long itemId);
}
