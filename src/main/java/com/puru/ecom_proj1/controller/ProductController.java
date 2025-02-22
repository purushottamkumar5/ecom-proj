package com.puru.ecom_proj1.controller;

import com.puru.ecom_proj1.model.Product;
import com.puru.ecom_proj1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController
{
    @Autowired
    ProductService service;
//    @GetMapping("/test")
//    public String testController()
//    {
//        return "running fine";
//    }
    @GetMapping("allProducts")
    public List<Product> getAllProducts()
    {
        return service.getAllProducts();
    }
    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable int id)
    {
        return service.getProductById(id);
    }

//    @PostMapping("addProduct")
//    public Product addProducut(@RequestBody Product pro)
//    {
//        return service.addProduct(pro);
//    }
    @PostMapping("addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product pro)
    {

        return new ResponseEntity<>(service.addProduct(pro), HttpStatus.OK);
    }
    @PutMapping("update")
    public Product updateProduct(@RequestBody Product pro)
    {
        return service.updateProduct(pro);
    }

    @DeleteMapping("deleteAll")
    public String deleteAllProduct()
    {
        service.deleteAllProduct();
        return "Deleted";
    }

    @DeleteMapping("{id}")
    public int deleteProduct(@PathVariable int id)
    {
        service.deleteById(id);
        return id;
    }

    @GetMapping("getByName/{name}")
    public List<Product> findByName(@PathVariable String name)
    {
        return service.findByName(name);
    }

    @GetMapping("getByBrand/{brand}")
    public List<Product> getBybrand(@PathVariable String brand)
    {
        return service.findByBrand(brand);
    }

    @GetMapping("findByGreaterPriceRange/{price}")
    public List<Product>getByPriceRange(@PathVariable int price)
    {
        return service.findByGreaterPriceRange(price);
    }
    @GetMapping("toCheckInStock/{id}")
    public boolean toCheckInStock(@PathVariable int id)
    {
        return service.checkInStock(id);
    }


}
