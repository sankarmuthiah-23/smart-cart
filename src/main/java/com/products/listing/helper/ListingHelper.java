package com.products.listing.helper;

import com.products.listing.model.ProductDetails;
import org.springframework.stereotype.Component;

@Component
public class ListingHelper {

    public void generateSku(ProductDetails productDetails) {
        if(productDetails.getName() != null && productDetails.getBrand() != null) {
            String namePart = productDetails.getName().length() >= 3 ? productDetails.getName().substring(0,3) : productDetails.getName();
            String brandPart = productDetails.getBrand().length() >= 3 ? productDetails.getBrand().substring(0,3) : productDetails.getBrand();
            long timestamp = System.currentTimeMillis();
            String sku = namePart.toUpperCase() + "-" +
                    brandPart.toUpperCase() + "-" +
                    timestamp;
            productDetails.setSku(sku);
        }
    }
}
