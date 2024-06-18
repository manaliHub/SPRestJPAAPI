package com.example.SPRestJPAAPI.controller;

import com.example.SPRestJPAAPI.RequesObject.LaptopData;
import com.example.SPRestJPAAPI.RequesObject.LaptopRequest;
import com.example.SPRestJPAAPI.ResponseObject.LaptopResponse;
import com.example.SPRestJPAAPI.ResponseObject.User;
import com.example.SPRestJPAAPI.appconfig.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * THis controller has REST endpoints which then call some public endpoint API USING restTemplate
 */
@RestController
public class LaptopController {

    @Autowired
    AppConfig appConfig;

    /**
     * This endpoint consume Free public API endpoint using RestTemplate.getForEntity
     * This free public GET endpoint. See the result by hitting this URL on browser.
     * It has no request body nor headers.It will have only response body
     * @return
     */
    @GetMapping("/callExternalAPI1")
    public User callExternalAPI1(){
        String url="https://jsonplaceholder.typicode.com/todos/1";
        //RestTemplate restTemplate = new RestTemplate();
        return appConfig.restTemplate().getForEntity(url, User.class).getBody();
    }

    /**
     * This endpoint consume Free public API endpoint using RestTemplate.exchange method
     * This free public GET endpoint. See the result by hitting this URL on browser.
     * It has request body .not headers.It will have response body
     * @return
     */
    @GetMapping("/callExternalAPI2")
    public LaptopResponse callExternalAPI2(){
        String url="https://api.restful-api.dev/objects";
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);*/
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("content_type", String.valueOf(MediaType.APPLICATION_JSON));
        //headers.add("msg","hi");

        LaptopData laptopData = new LaptopData();
        laptopData.setYear(2019);
        laptopData.setPrice(new BigDecimal(1849.99));
        laptopData.setCpuModel("Intel Core i9");
        laptopData.setHardDiscSize("1 TB");

        LaptopRequest laptopRequest = new LaptopRequest();
        laptopRequest.setName("Apple MacBook Pro 16");
        laptopRequest.setLaptopData(laptopData);

        HttpEntity<LaptopRequest> request = new HttpEntity<>(laptopRequest, headers);
        //Use below HttpEntity if you dont have request body
        // HttpEntity<Objects> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<LaptopResponse> response = appConfig.restTemplate()
                .exchange(url, HttpMethod.POST,request, LaptopResponse.class);

        System.out.println("Status code is :"+response.getStatusCode());
        System.out.println("Response headers code is :"+response.getHeaders());
        System.out.println("Response body code is :"+response.getBody());
        return response.getBody();
    }

    /**
     * This endpoint comsume the endpoint of this API ONLY (getDummyProduct method)
     * using restTemplate.getForEntity method
     * @return
     */
    @GetMapping("/callMyAPI")
    public String callMyAPI(){
        //This is one of the endpoint of this API only
        String url="http://localhost:8080/";
        //RestTemplate restTemplate = new RestTemplate();
        return String.valueOf(appConfig.restTemplate().getForEntity(url, String.class));
    }

    /**
     * This is just sample
     * @return
     */
    @GetMapping("/")
    public String getDummyProduct(){
        return "product";
    }
}