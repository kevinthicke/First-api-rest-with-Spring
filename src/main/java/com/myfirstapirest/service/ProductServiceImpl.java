package com.myfirstapirest.service;

import com.myfirstapirest.dao.ProductDao;
import com.myfirstapirest.model.Product;
import com.myfirstapirest.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    private boolean isEmpty(List<Product> hangars) {

        int numberOfHangarsWithFalseState = (int) hangars.stream()
                .filter(Product::isState)
                .count();

        return (hangars.isEmpty() || numberOfHangarsWithFalseState >= 0);

    }

    @Override
    public Stream<Product> getProducts()  {

        List<Product> products = this.productDao.getAll();

        if(this.isEmpty(products))
            throw new ProductException.NotFound();

        return products.stream().filter(Product::isState);
    }

    @Override
    public Product getProductFilteringByNameLengthAndStartingWith(char character) {

        return this.productDao
                .getByFirstCharacter(character)
                .stream()
                .max(Comparator.comparing(product-> product.getName().length()))
                .map(product -> {
                    product.setName(product.getName().toUpperCase());
                    return product;
                })
                .orElseThrow(() -> new ProductException.ErrorComparingProductNames());
        }

}
