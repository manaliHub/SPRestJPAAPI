package com.example.SPRestJPAAPI.service;

import com.example.SPRestJPAAPI.model.Product;
import java.util.List;

public interface ProductService {

    //get all products : for GET call
    public List<Product> getAllProducts() ;

    //get product by Id : for GET call
    public Product getProduct(int id) ;

    //create product : for POST call
    public Product createProduct(Product product) ;

    //delete product by Id : for DELETE call
    public void deleteProduct(int id) ;

    //update product by Id : for PUT call
    public void updateeProduct(Product product, int id);

    //update product by Id : for PATCH call
    public void updateProduct(Product product, int id) ;
}
