package com.example.SPRestJPAAPI.RequesObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LaptopRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private LaptopData laptopData;

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
}
