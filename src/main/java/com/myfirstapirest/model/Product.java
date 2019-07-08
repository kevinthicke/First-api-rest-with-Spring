package com.myfirstapirest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private @Column(name = "NAME") String name;
    private @Column(name = "PRICE") String price;

    private @Column(name = "STATE") boolean state;

    /*
    private @ManyToOne
    @JoinColumn(name = "hangar_id", foreignKey = @ForeignKey(name = "HANGAR_ID_FK"))
    Hangar hangar;
    */

    public Product() {
        this.state = true;
    //     this.hangar = new Hangar("Default Hangar");
    }

    public Product(String name, String price) {
        this();
        this.name = name;
        this.price = price;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    /*
    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }
    */
}
