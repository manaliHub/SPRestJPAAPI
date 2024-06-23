package com.example.SPRestJPAAPI.service;

import com.example.SPRestJPAAPI.dao.ProductRepository;
import com.example.SPRestJPAAPI.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    List<Product> productList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Product p1 = new Product();
        p1.setName("name1");
        p1.setPrice(new BigDecimal(1.00));
        p1.setDescription("desc1");
        p1.setId(1);
        Product p2 = new Product();
        p2.setName("name2");
        p2.setPrice(new BigDecimal(2.00));
        p2.setDescription("desc2");
        p2.setId(2);
        productList.add(p1);
        productList.add(p2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() {
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> productList1 = productService.getAllProducts();
        assertEquals(2,productList1.size());
        assertEquals("name1",productList1.get(0).getName());
    }

    @Test
    void getProduct() {
        Mockito.when(productRepository.findById(1)).thenReturn(productList.get(0));
        Product p1 = productService.getProduct(1);
        assertEquals("desc1",p1.getDescription());
    }

    @Test
    void createProduct() {
        Product p = new Product();
        p.setName("nm");
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(p);
        //Mockito.when(productRepository.save(p)).thenReturn(p);
        productService.createProduct(p);
        assertEquals("nm",p.getName());
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