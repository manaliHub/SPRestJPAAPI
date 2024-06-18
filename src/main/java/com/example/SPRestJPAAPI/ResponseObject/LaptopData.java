package com.example.SPRestJPAAPI.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class LaptopData {

    @JsonProperty("year")
    private int year;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("CPU model")
    private String cpuModel;

    @JsonProperty("Hard disc size")
    private String hardDiscSize;
}
