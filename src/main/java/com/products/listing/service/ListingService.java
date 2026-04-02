package com.products.listing.service;

import com.products.listing.model.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {


    public List<ProductDetails> createProducts() {
        // Logic to create a product
        return new ArrayList<ProductDetails>();
    }

    public ProductDetails getProductById(int id) {
        // Logic to get a product by ID
        return new ProductDetails();
    }

    public List<ProductDetails> getProducts() {
        // Logic to get all products
        return new ArrayList<ProductDetails>();
    }

    public List<ProductDetails> updateProducts() {
        // Logic to update a product
        return new ArrayList<ProductDetails>();
    }

    public ProductDetails updateProduct() {
        // Logic to update a product
        return new ProductDetails();
    }

    public void deleteProduct(int id) {
        // Logic to delete a product by ID
    }

    public void deleteAllProducts() {
        // Logic to delete all products
    }
}
