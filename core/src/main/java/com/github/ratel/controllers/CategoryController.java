package com.github.ratel.controllers;

import com.github.ratel.dto.CategoryDto;
import com.github.ratel.entity.Category;
import com.github.ratel.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return this.categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category findCategoryById(@PathVariable long categoryId) {
        return this.categoryService.findCategoryById(categoryId).orElseThrow(() -> new RuntimeException("Category not found!"));
    }

    @PostMapping
    public void createCategory(@PathVariable CategoryDto categoryDto) {
        this.categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{categoryId}")
    public Category updateCategoryInfo(@PathVariable long categoryId, @RequestBody CategoryDto categoryDto){
        return this.categoryService.updateCategoryInfo(categoryId, categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }
}
