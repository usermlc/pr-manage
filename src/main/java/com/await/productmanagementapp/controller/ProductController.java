package com.await.productmanagementapp.controller;

import com.await.productmanagementapp.model.Product;
import com.await.productmanagementapp.service.ProductService;
import com.await.productmanagementapp.service.CategoryService;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    // Services for managing products and categories
    private final ProductService productService;
    private final CategoryService categoryService;

    // Constructor for dependency injection of ProductService and CategoryService
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    // Endpoint to display a paginated list of products with optional filters
    @GetMapping("/list")
    public String listProducts(@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) Long categoryId,
        @RequestParam(required = false) BigDecimal minPrice,
        @RequestParam(required = false) BigDecimal maxPrice,
        Model model) {
        Pageable pageable = PageRequest.of(page, size);  // Pagination setup

        // Retrieves filtered list of products based on optional category and price range
        Page<Product> productPage = productService.findFilteredProducts(categoryId, minPrice, maxPrice, pageable);

        // Adds the product list and category list to the model for the view
        model.addAttribute("page", productPage);
        model.addAttribute("categories", categoryService.findAll());

        return "productList";  // Returns the product list view
    }

    // Endpoint to display the form for adding a new product
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());  // Empty product object for the form
        model.addAttribute("categories", categoryService.findAll());  // List of categories for selection
        return "productForm";  // Navigates to product form view
    }

    // Endpoint to create a new product and redirect to the product list
    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.save(product);  // Saves new product to the database
        return "redirect:/products/list";  // Redirects to the list of products
    }

    // Endpoint to display the form for editing an existing product
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);

        // Adds product and category list to the model for editing
        model.addAttribute("product", productOptional.get());
        model.addAttribute("categories", categoryService.findAll());

        return "productForm";  // Reuses product form view for editing
    }

    // Endpoint to update an existing product
    @PostMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);  // Ensure product ID is set before saving
        productService.save(product);  // Updates product in the database
        return "redirect:/products/list";  // Redirects back to product list
    }

    // Endpoint to delete a product by its ID
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);  // Deletes the product with the specified ID
        return "redirect:/products/list";  // Redirects back to the list after deletion
    }
}
