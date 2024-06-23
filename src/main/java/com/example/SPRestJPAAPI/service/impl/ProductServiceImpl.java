package com.example.SPRestJPAAPI.service.impl;

import com.example.SPRestJPAAPI.dao.ProductRepository;
import com.example.SPRestJPAAPI.exception.RecordNotFoundException;
import com.example.SPRestJPAAPI.model.Product;
import com.example.SPRestJPAAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//instead of service annotation u can use component annotation also
@Service
public class ProductServiceImpl implements ProductService {

   /* //This list consider as coming from database
    private static List<Product> productList = new ArrayList<>();
    static{
        productList.add(new Product(1,"name1","desc1",new BigDecimal(1.00)));
        productList.add(new Product(2,"name2","desc2",new BigDecimal(2.00)));
        productList.add(new Product(3,"name3","desc3",new BigDecimal(3.00)));
    }*/

    @Autowired
    private ProductRepository productRepository;

    //get all products : for GET call
    public List<Product> getAllProducts() {
        List<Product> productList= (List<Product>) productRepository.findAll();
        return productList;
    }

    //get product by Id : for GET call
    public Product getProduct(int id) {
        Product product = null;
        //try {
           // product = productList.stream().filter(e -> e.getId() == id).findFirst().get();
            product = productRepository.findById(id);
            if(product==null)
                throw new RecordNotFoundException("Given Product is not found.");
       /* }catch(Exception e){
            e.printStackTrace();
        }*/
       return product;
    }

    //create product : for POST call
    public Product createProduct(Product product) {
        //productList.add(product);
        Product p = productRepository.save(product);
        return p;
    }

    //delete product by Id : for DELETE call
    public void deleteProduct(int id) {
        //productList = productList.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
        try {
            productRepository.deleteById(id);
        }catch(Exception e) {
            System.out.println("id is not found for delete");
            throw new RecordNotFoundException("Given Id is not present");
        }
    }

    //update product by Id : for PUT call
    public void updateeProduct(Product product, int id) {
      /*  productList = productList.stream().map(e-> {
            if (e.getId() == id) {
                e.setDescription(product.getDescription());
                e.setName(product.getName());
                e.setPrice(product.getPrice());
            }
            return e;
        }).collect(Collectors.toList());*/
        //product.setId(id);
        productRepository.save(product);
    }

    //update product by Id : for PATCH call
    public void updateProduct(Product product, int id) {
        /*productList = productList.stream().map(e-> {
            if (e.getId() == id) {
                e.setDescription(product.getDescription());
                e.setName(product.getName());
                e.setPrice(product.getPrice());
            }
            return e;
        }).collect(Collectors.toList());*/
        //product.setId(id);
        productRepository.save(product);
    }
}
