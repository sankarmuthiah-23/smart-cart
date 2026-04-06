package com.products.listing.service;

import com.products.listing.dto.ProductEntries;
import com.products.listing.helper.ListingHelper;
import com.products.listing.model.ProductDetails;
import com.products.listing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ListingHelper listingHelper;


    public List<ProductDetails> createProducts(ProductEntries productDetailsList) {
        if(productDetailsList.getProductDetailsList().isEmpty()){
            return new ArrayList<ProductDetails>();
        }
        productDetailsList.getProductDetailsList().forEach(
                productDetails -> listingHelper.generateSku(productDetails)
        );
        List<ProductDetails> savedProducts = productRepository.saveAll(productDetailsList.getProductDetailsList());
        return savedProducts;
    }

    public ProductDetails getProductById(Long id) {
        Optional<ProductDetails> productDetails = productRepository.findById(id);
        return productDetails.isPresent() ? productDetails.get() : new ProductDetails();
    }

    public List<ProductDetails> getProducts() {
        List<ProductDetails> productDetailsList = productRepository.findAll();
        return productDetailsList;
    }

    public List<ProductDetails> updateProducts(ProductEntries productDetailsList) {
        if(productDetailsList.getProductDetailsList().isEmpty()){
            return new ArrayList<ProductDetails>();
        }
        List<ProductDetails> updatedProductDetails = new ArrayList<>();
        productDetailsList.getProductDetailsList().forEach(
                productDetails -> {
                    Optional<ProductDetails> existingProduct = productRepository.findById(productDetails.getId());
                    if (existingProduct.isPresent()) {
                        ProductDetails productToUpdate = existingProduct.get();
                        String name = productDetails.getName()!= null ? productDetails.getName() : productToUpdate.getName();
                        productToUpdate.setName(name);
                        String brand = productDetails.getBrand()!= null ? productDetails.getBrand() : productToUpdate.getBrand();
                        productToUpdate.setBrand(brand);
                        String description = productDetails.getDescription() != null ? productDetails.getDescription() : productToUpdate.getDescription();
                        productToUpdate.setDescription(description);
                        String category = productDetails.getCategory() != null ? productDetails.getCategory() : productToUpdate.getCategory();
                        productToUpdate.setCategory(category);
                        Double price = productDetails.getPrice() != null ? productDetails.getPrice() : productToUpdate.getPrice();
                        productToUpdate.setPrice(price);
                        Integer quantity = productDetails.getQuantity() != null ? productDetails.getQuantity() : productToUpdate.getQuantity();
                        productToUpdate.setQuantity(quantity);
                        updatedProductDetails.add(productToUpdate);
                    }
                }
        );
        List<ProductDetails> productDetails = productRepository.saveAll(updatedProductDetails);
        return productDetails;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
