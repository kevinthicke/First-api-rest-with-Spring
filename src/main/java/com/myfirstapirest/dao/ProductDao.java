package com.myfirstapirest.dao;

import com.myfirstapirest.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> getAll();
    List<Product> getByFirstCharacter(char character);
    /*
    Optional<Product> getById(long id);
    boolean existsById(long id);
    boolean existsByName(String name);
    Product insert(Product product);
    Product update(Product product);
    Product deleteById(long id);
    */
}
