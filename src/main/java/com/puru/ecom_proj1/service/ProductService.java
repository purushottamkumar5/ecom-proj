package com.puru.ecom_proj1.service;

import com.puru.ecom_proj1.model.Product;
import com.puru.ecom_proj1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product pro) {
        return repo.save(pro);
    }

    public Product updateProduct(Product pro) {
        return repo.save(pro);
    }

    public void deleteAllProduct() {
        repo.deleteAll();
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return repo.findByNameContains(name);
    }


    public List<Product> findByBrand(String brand) {
        return repo.find(brand);
    }
    public List<Product> findByGreaterPriceRange(int price)
    {
        return repo.findByGreaterThan(price);
    }
}
