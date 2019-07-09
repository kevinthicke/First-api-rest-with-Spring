package com.myfirstapirest.model;

import java.util.ArrayList;
import java.util.List;

public class HangarResponse {

    private long id;
    private String name;
    private List<ProductResponse> products = new ArrayList<ProductResponse>();

    public HangarResponse() {}

    public HangarResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public HangarResponse(long id, String name, List<ProductResponse> products) {
        this(id, name);
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
