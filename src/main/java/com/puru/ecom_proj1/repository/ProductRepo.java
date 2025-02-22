package com.puru.ecom_proj1.repository;

import com.puru.ecom_proj1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value="SELECT * FROM Product p WHERE brand=:abrand",nativeQuery = true)
    List<Product> find(@Param("abrand") String brand);


//    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
//    @Query(value="SELECT * FROM Product p WHERE name LIKE %:name%",nativeQuery = true)
@Query(value="SELECT * FROM Product p WHERE LOWER(name) like LOWER(CONCAT(:name,'%'))",nativeQuery = true)
    List<Product> findByNameContains(@Param("name") String name);

    @Query(value="SELECT * FROM Product p where p.price <:price",nativeQuery = true )
    List<Product> findByGreaterThan(@Param("price") int price);

    @Query(value="SELECT * FROM PRODUCT p WHERE p.id=:id && p.quantity>0",nativeQuery = true)
    boolean checkInStock(@Param("id") int id);
//    or
//    List<Product> findByNameContains(String name);

}
