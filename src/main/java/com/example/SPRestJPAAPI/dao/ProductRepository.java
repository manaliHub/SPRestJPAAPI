package com.example.SPRestJPAAPI.dao;

import com.example.SPRestJPAAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findById(int id);
}
