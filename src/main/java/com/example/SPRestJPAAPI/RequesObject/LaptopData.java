package com.example.SPRestJPAAPI.RequesObject;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getHardDiscSize() {
        return hardDiscSize;
    }

    public void setHardDiscSize(String hardDiscSize) {
        this.hardDiscSize = hardDiscSize;
    }
}
