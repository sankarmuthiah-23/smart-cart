package com.products.listing.controller;

import com.products.listing.dto.ProductEntries;
import com.products.listing.model.ProductDetails;
import com.products.listing.service.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {

    private final Logger logger = LoggerFactory.getLogger(ListingController.class);

    @Autowired
    private ListingService listingService;

    @GetMapping("/products")
    public List<ProductDetails> getProducts(){
        return listingService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public ProductDetails getProductById(@PathVariable("productId") Long id){
            return listingService.getProductById(id);
    }

    @PostMapping("/create/products")
    public List<ProductDetails> createProduct(@RequestBody ProductEntries productDetailsList){
        return listingService.createProducts(productDetailsList);
    }


    @PutMapping("/bulkUpdate/Products")
    public List<ProductDetails> updateProduct( @RequestBody ProductEntries productDetails){
       return listingService.updateProducts(productDetails);
    }

    @DeleteMapping("/delete/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        listingService.deleteProduct(id);
    }

    @DeleteMapping("/products/deleteAll")
    public void deleteAllProducts(){
        listingService.deleteAllProducts();
    }
}
