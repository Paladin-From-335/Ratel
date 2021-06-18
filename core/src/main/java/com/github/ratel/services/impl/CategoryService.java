package com.github.ratel.services.impl;

import com.github.ratel.dto.CategoryDto;
import com.github.ratel.entity.Category;
import com.github.ratel.repositories.CategoryRepository;
import com.github.ratel.utils.TransferObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(long id) {
        return this.categoryRepository.findById(id);
    }

    public void createCategory(CategoryDto categoryDto) {
        Category category = TransferObj.toCategory(categoryDto);
        doesCategoryExists(category.getCategoryId());
        this.categoryRepository.save(category);
    }

    public Category updateCategoryInfo(long categoryId, CategoryDto categoryDto) {
        findCategoryById(categoryId).orElseThrow(() -> new RuntimeException("category not found"));
        return this.categoryRepository.save(TransferObj.toCategory(categoryDto));
    }

    public void deleteCategory(long categoryId) {
        doesCategoryExists(categoryId);
        this.categoryRepository.deleteById(categoryId);
    }

    private void doesCategoryExists(long categoryId) {
        if (findCategoryById(categoryId).isPresent()) {
            throw new RuntimeException("This category already exists!");
        }
    }
}
