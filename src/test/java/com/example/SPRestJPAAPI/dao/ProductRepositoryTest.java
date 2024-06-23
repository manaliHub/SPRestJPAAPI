package com.example.SPRestJPAAPI.dao;

import com.example.SPRestJPAAPI.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /**
     *  click atl+insert to add this method.
     *   This method will execute before each test method
     */
    @BeforeEach
    void setUp() {
        System.out.println("This is before each method");
        //if you want you can crete one entry in Product table just for testing and then delete that entry in after each test method
        //if you don't want to do this you can use already existed entry with id =7 in mysql db
    }

    /**
     *  click atl+insert to add this method.
     *   This method will execute after each test method
     */
    @AfterEach
    void tearDown() {
        System.out.println("This is after each method");
        //if you want you can crete one entry in Product table just for testing and then delete that entry in after each method
        //if you don't want to do this you can use already existed entry with id =7 in mysql db
    }

    @Test
    void findByIdSuccess() {
        //Db has already value
        Product p1 = productRepository.findById(7);
        assertEquals(7,p1.getId());
        assertEquals("name7",p1.getName());
    }

    @Test
    void findByIdNotPresent() {
        Product p2 = productRepository.findById(6);
        assertEquals(null,p2);
        Assert.isNull(p2);
    }
}