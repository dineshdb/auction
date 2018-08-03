package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Category;
import com.sankalpa.auction.model.Item;
import com.sankalpa.auction.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Set<Category> getAllCategories(){
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public Category addCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }

    public Category updateCategory(Category updatedCategory){
        return categoryRepository.save(updatedCategory);
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public Category getCategory(Long categoryId){
        return categoryRepository.findById(categoryId).orElse(null);
    }

    // returns only the id of items in the given category
    public Set<Long> getItemsByCategory(Long categoryId) {

        Category category = getCategory(categoryId);
        Set<Item> items = category.getItems();

        Set<Long> itemIds = new HashSet<>();
        for (Item item : items){
            itemIds.add(item.getItemId());
        }

        return itemIds;
    }
}
