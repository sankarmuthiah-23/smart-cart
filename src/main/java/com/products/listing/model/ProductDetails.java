package com.products.listing.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotBlank(message = "Product description is mandatory")
    @Column(length = 2000)
    private String description;
    @NotBlank(message = "Brand details is mandatory")
    private String brand;
    private String category;
    private String sku;
    private Integer quantity;
    private Double price;
    private String currency;
}
