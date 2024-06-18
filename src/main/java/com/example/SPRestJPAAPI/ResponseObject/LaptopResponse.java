package com.example.SPRestJPAAPI.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LaptopResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("data")
    private LaptopData laptopData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LaptopData getLaptopData() {
        return laptopData;
    }

    public void setLaptopData(LaptopData laptopData) {
        this.laptopData = laptopData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
