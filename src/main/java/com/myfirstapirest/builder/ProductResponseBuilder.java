package com.myfirstapirest.builder;

import com.myfirstapirest.model.Product;
import com.myfirstapirest.model.ProductResponse;

public class ProductResponseBuilder {

    private ProductResponse productResponse;

    public ProductResponseBuilder(Product product) {
        String productName = product.getName();
        String productPrice = product.getPrice();

        this.productResponse = new ProductResponse(productName, productPrice);
    }

    public ProductResponse getProductResponse() {
        return productResponse;
    }
}
