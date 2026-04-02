package com.products.listing.controller;

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
    public ProductDetails getProductById(@PathVariable("productId") int id){
            return listingService.getProductById(id);
    }

    @PostMapping("/create/products")
    public List<ProductDetails> createProduct(@RequestBody List<ProductDetails> productDetails){
        return listingService.createProducts();
    }

    @PutMapping("/update/products/{productId}")
    public ProductDetails updateProduct(@PathVariable("productId") int id, @RequestBody List<ProductDetails> productDetails){
            return listingService.updateProduct();
    }

    @PutMapping("/bulkUpdate/Products")
    public List<ProductDetails> updateProduct( @RequestBody List<ProductDetails> productDetails){
       return listingService.updateProducts();
    }

    @DeleteMapping("/delete/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int id){
        listingService.deleteProduct(id);
    }

    @DeleteMapping("products/deleteAll")
    public void deleteAllProducts(){
        listingService.deleteAllProducts();
    }
}
