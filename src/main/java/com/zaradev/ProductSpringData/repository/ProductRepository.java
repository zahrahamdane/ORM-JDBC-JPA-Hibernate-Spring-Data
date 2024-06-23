package com.zaradev.ProductSpringData.repository;

import com.zaradev.ProductSpringData.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);


    @Query("SELECT p FROM Product p WHERE p.name LIKE :x")
    List<Product> search(@Param("x") String mc);

    @Query("SELECT p FROM Product p WHERE p.price > :y")
    List<Product> searchByPrice(@Param("y") Double price);


}
