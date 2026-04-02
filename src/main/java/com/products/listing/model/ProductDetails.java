package com.products.listing.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetails {

    private int id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private String sku;
    private String stockStatus;
    private double price;
    private String currency;
}
