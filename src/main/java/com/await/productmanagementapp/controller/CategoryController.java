package com.await.productmanagementapp.controller;

import com.await.productmanagementapp.model.Category;
import com.await.productmanagementapp.service.CategoryService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    // Service for category operations
    private final CategoryService categoryService;

    // Constructor for dependency injection of CategoryService
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Endpoint to display the list of all categories
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categoryList";  // Returns view with category list
    }

    // Endpoint to show the form for adding a new category
    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category()); // Preparing empty category object
        return "categoryForm";  // Navigates to the category form view
    }

    // Endpoint to create a new category and redirect to category list
    @PostMapping
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category);  // Saves the new category to database
        return "redirect:/categories";  // Redirects back to category listing
    }

    // Endpoint to show the form for editing an existing category
    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable Long id, Model model) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        model.addAttribute("category", categoryOptional.get());  // Adds category to the model for editing
        return "categoryForm";  // Reuses the same form view for editing
    }

    // Endpoint to delete a category by its ID
    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);  // Deletes the category with the specified ID
        return "redirect:/categories";  // Redirects back to category list after deletion
    }
}
