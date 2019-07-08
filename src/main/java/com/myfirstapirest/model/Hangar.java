package com.myfirstapirest.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hangar {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private @Column(name = "NAME") String name;
    private @Column(name = "STATE") boolean state;
    private @Column(name = "DESCRIPTION") String description;

    private @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products = new ArrayList<Product>();

    public Hangar() {
        this.state = true;
    }

    public Hangar(String name) {
        this();
        this.name = name;
    }

    public Hangar(String name, String description) {
        this(name);
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
