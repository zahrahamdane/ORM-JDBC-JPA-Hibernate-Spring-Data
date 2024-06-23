package com.zaradev.ProductSpringData.repository;

import com.zaradev.ProductSpringData.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
