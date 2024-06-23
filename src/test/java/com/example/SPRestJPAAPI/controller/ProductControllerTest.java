package com.example.SPRestJPAAPI.controller;

import com.example.SPRestJPAAPI.exception.RecordNotFoundException;
import com.example.SPRestJPAAPI.model.Product;
import com.example.SPRestJPAAPI.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Autowired
    private ProductController controller;

    @BeforeEach
    void setUp() {
        controller = new ProductController(this.productService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void getAllProducts() {
        controller.getAllProducts();
        Mockito.verify(productService,Mockito.times(1)).getAllProducts();
    }

    //@Test
    void getProduct()  {
        controller.getProduct(1);
        Mockito.verify(productService,Mockito.times(1)).getProduct(1);
    }

    @Test
    void deleteProduct() {
        controller.deleteProduct(1);
        Mockito.verify(productService,Mockito.times(1)).deleteProduct(1);
    }

    @Test
    void updateeProduct() {
        Product p1 = new Product();
        p1.setName("name1");
        p1.setPrice(new BigDecimal(1.00));
        p1.setDescription("desc1");
        p1.setId(1);
        controller.updateeProduct(p1,1);
        Mockito.verify(productService,Mockito.times(1)).updateeProduct(p1,1);
    }

    @Test
    void updateProduct() {
        Product p1 = new Product();
        p1.setName("name1");
        p1.setPrice(new BigDecimal(1.00));
        p1.setDescription("desc1");
        p1.setId(1);
        controller.updateProduct(p1,1);
        Mockito.verify(productService,Mockito.times(1)).updateProduct(p1,1);
    }
}