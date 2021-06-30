package com.github.ratel.controllers;

import com.github.ratel.dto.CategoryDto;
import com.github.ratel.entity.Category;
import com.github.ratel.services.impl.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Api(value = "Category Controller")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ApiOperation(value = "Find all category in database")
    public List<Category> findAllCategories() {
        return this.categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    @ApiOperation(value = "Find category by id", response = Category.class)
    public Category findCategoryById(@PathVariable long categoryId) {
        return this.categoryService.findCategoryById(categoryId).orElseThrow(() -> new RuntimeException("Category not found!"));
    }

    @PostMapping
    @ApiOperation(value = "Create category")
    public void createCategory(@PathVariable CategoryDto categoryDto) {
        this.categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{categoryId}")
    @ApiOperation(value = "Update category", response = Category.class)
    public Category updateCategoryInfo(@PathVariable long categoryId, @RequestBody CategoryDto categoryDto){
        return this.categoryService.updateCategoryInfo(categoryId, categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    @ApiOperation(value = "Delete category")
    public void deleteCategory(@PathVariable long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }
}
