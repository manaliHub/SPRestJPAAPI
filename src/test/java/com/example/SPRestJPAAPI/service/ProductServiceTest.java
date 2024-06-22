package com.example.SPRestJPAAPI.service;

import com.example.SPRestJPAAPI.dao.ProductRepository;
import com.example.SPRestJPAAPI.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    /**
     *   don't put autowire for this.otherwise repository is also autowire give actual data from db.
     *   We need to mock repository as we have already done unit tetsing of repository class
     */
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productService = new ProductService(this.productRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() {
        productService.getAllProducts();
        Mockito.verify(productRepository,Mockito.times(1)).findAll();
    }

    @Test
    void getProduct() {
        productService.getProduct(6);
        Mockito.verify(productRepository,Mockito.times(1)).findById(6);
    }

    @Test
    void createProduct() {
        Product p = new Product();
        p.setName("nm");
        productService.createProduct(p);
        Mockito.verify(productRepository,Mockito.times(1)).save(p);
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(6);
        Mockito.verify(productRepository,Mockito.times(1)).deleteById(6);
    }

    @Test
    void updateeProduct() {
    }

    @Test
    void updateProduct() {
    }
}