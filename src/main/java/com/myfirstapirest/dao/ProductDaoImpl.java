package com.myfirstapirest.dao;

import com.myfirstapirest.repository.ProductRepository;
import com.myfirstapirest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productService;

    @Override
    public List<Product> getAll() {
        return this.productService.findAll();
    }

    @Override
    public List<Product> getByFirstCharacter(char character) {
        return this.productService.findByNameStartingWith(character);
    }
    /*
    @Override
    public Optional<Product> getById(long id) {
        return this.productService.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return this.productService.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return this.productService.existsByName(name);
    }

    @Override
    public Product insert(Product product) {
        return this.productService.save(product);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product deleteById(long id) {
        return null;
    }
    */
}