package com.test.service.impl;

import com.test.dao.ProductDao;
import com.test.domain.Product;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product>findAll() throws Exception {
         return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
