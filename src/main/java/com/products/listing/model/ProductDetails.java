package com.products.listing.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotBlank(message = "Product description is mandatory")
    private String description;
    @NotBlank(message = "Brand details is mandatory")
    private String brand;
    private String category;
    private String sku;
    private int quantity;
    private double price;
    private String currency;

    public void setName(String name) {
        this.name = name;
        createSku();
    }

    public void setBrand(String brand) {
        this.brand = brand;
        createSku();
    }

    public void setId(int id) {
        this.id = id;
        createSku();
    }

    public void createSku() {
        this.sku = this.name.substring(0, 3).toUpperCase() + "-" + this.brand.substring(0, 3).toUpperCase() + "-" + this.id;
    }
}
