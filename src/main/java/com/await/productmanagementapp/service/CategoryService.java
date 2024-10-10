package com.await.productmanagementapp.service;

import com.await.productmanagementapp.model.Category;
import com.await.productmanagementapp.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service  // Marks this class as a service component in Spring
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor for dependency injection of CategoryRepository
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Method to retrieve all categories from the repository
    public List<Category> findAll() {
        return categoryRepository.findAll();  // Returns a list of all categories
    }

    // Method to find a category by its ID
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);  // Returns an Optional of the found category
    }

    // Method to save a new or existing category
    public Category save(Category category) {
        return categoryRepository.save(category);  // Persists the category and returns the saved instance
    }

    // Method to delete a category by its ID
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);  // Removes the category from the repository
    }
}
