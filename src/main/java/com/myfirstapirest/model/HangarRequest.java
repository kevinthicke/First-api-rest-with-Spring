package com.myfirstapirest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HangarRequest {

    private @NotNull @Size(min = 3) String name;

    public HangarRequest() {}

    public HangarRequest( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
