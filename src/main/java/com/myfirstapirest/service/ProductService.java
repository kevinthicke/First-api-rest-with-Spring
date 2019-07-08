package com.myfirstapirest.service;

import com.myfirstapirest.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ProductService {

    Stream<Product> getProducts();
    Product getProductFilteringByNameLengthAndStartingWith(char character);
}
