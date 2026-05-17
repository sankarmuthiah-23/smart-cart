package com.products.listing.controller;

import com.products.listing.dto.ProductEntries;
import com.products.listing.model.ProductDetails;
import com.products.listing.service.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {

    private final Logger logger = LoggerFactory.getLogger(ListingController.class);

    @Autowired
    private ListingService listingService;

    @GetMapping("/products")
    public List<ProductDetails> getProducts() {
        return listingService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable("productId") Long id) {
        ProductDetails productDetails = listingService.getProductById(id);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    @PostMapping("/create/products")
    public ResponseEntity<List<ProductDetails>> createProduct(@RequestBody ProductEntries productDetailsList) {
        List<ProductDetails> productDetailList = listingService.createProducts(productDetailsList);
        return new ResponseEntity<>(productDetailList, HttpStatus.CREATED);
    }


    @PutMapping("/update/products")
    public ResponseEntity<List<ProductDetails>> updateProduct(@RequestBody ProductEntries productDetails) {
        List<ProductDetails> productDetailsList = listingService.updateProducts(productDetails);
        return new ResponseEntity<>(productDetailsList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/products/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long id) {

        listingService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/products/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllProducts() {
        listingService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
