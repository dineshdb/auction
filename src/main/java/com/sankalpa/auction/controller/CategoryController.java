package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.Category;
import com.sankalpa.auction.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public @ResponseBody Set<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public @ResponseBody Category getCategory(@PathVariable Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/categories")
    public @ResponseBody Category addCategory(@RequestBody Category newCategory){
        return categoryService.addCategory(newCategory);
    }

    @PutMapping("/categories")
    public @ResponseBody Category updateCategory(@RequestBody Category updatedCategory){
        return categoryService.updateCategory(updatedCategory);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/categories/{categoryId}/items")
    public @ResponseBody Set<Long> getItemsByCategory(@PathVariable Long categoryId){
        return categoryService.getItemsByCategory(categoryId);
    }
}
