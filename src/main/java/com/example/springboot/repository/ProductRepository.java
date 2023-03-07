package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //jpql query
    @Query("SELECT p FROM Product p WHERE "+
            "p.name LIKE CONCAT('%',:query,'%')"+
    "Or p.description Like CONCAT('%',:query,'%')")
    List<Product> searchProducts(String query);

    //native query
//    @Query(value = "SELECT * FROM Product p WHERE "+
//            "p.name LIKE CONCAT('%',:query,'%')"+
//            "Or p.description Like CONCAT('%',:query,'%')",nativeQuery = true)
//    List<Product> searchProductsSQL(String query);
}
