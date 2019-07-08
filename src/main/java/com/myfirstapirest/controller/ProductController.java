package com.myfirstapirest.controller;

import com.myfirstapirest.builder.ProductResponseBuilder;
import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.Product;
import com.myfirstapirest.model.ProductResponse;
import com.myfirstapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    ResponseEntity<List<ProductResponse>> loadProducts() {

        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();

        this.productService.getProducts().forEach(product -> {

            ProductResponse productResponse = (new ProductResponseBuilder(product)).getProductResponse();
            productResponses.add(productResponse);

        });

        return new ResponseEntity<List<ProductResponse>>(
                productResponses,
                HttpStatus.OK
        );
    }

    @GetMapping("/products/search-by-starting-with")
    ProductResponse loadProductStartingWithAndWithLongerName(@RequestParam char character) {

        Product product = this.productService.getProductFilteringByNameLengthAndStartingWith(character);

        String name = product.getName();
        String price = product.getPrice();


        return new ProductResponse(name, price);

    }
}
