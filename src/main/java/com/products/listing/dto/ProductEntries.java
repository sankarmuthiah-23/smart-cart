package com.products.listing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.products.listing.model.ProductDetails;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductEntries {

    @NotEmpty(message = "Product details list cannot be empty")
    @JsonProperty("entries")
    private List<ProductDetails> productDetailsList;



}
