package com.myfirstapirest.model;

public class ProductResponse {

    private String name;
    private String price;
    //private HangarResponse hangarResponse;

    public ProductResponse() {}

    public ProductResponse(String name, String price) {
        this.name = name;
        this.price = price;
    //    this.hangarResponse = new HangarResponse(hangar.getId(), hangar.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /*
    public HangarResponse getHangarResponse() {
        return hangarResponse;
    }

    public void setHangarResponse(Hangar hangar) {
        this.hangarResponse = new HangarResponse(hangar.getId(), hangar.getName());
    }
    */
}
