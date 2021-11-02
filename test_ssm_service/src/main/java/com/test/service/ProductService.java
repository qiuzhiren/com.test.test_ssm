package com.test.service;

import com.test.domain.Product;



import java.util.List;

public interface ProductService {

    public List<Product> findAll() throws Exception;

    public void save(Product product);
}
