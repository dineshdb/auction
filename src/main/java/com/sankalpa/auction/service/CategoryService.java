package com.sankalpa.auction.service;

import com.sankalpa.auction.model.Category;
import com.sankalpa.auction.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
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
}
