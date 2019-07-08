package com.myfirstapirest.builder;

import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.HangarResponse;
import com.myfirstapirest.model.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class HangarResponseBuilder
{
    HangarResponse hangarResponse;

    public HangarResponseBuilder(Hangar hangar) {

        this.hangarResponse = new HangarResponse();
        this.hangarResponse.setId(hangar.getId());
        this.hangarResponse.setName(hangar.getName());
        this.hangarResponse.setDescription(hangar.getDescription());

        List<ProductResponse> productsResponse = new ArrayList<ProductResponse>();

        hangar.getProducts().forEach(product -> {
            ProductResponse productResponse = (new ProductResponseBuilder(product)).getProductResponse();
            productsResponse.add(productResponse);
        });

        this.hangarResponse.setProducts(productsResponse);
    }

    public HangarResponse getHangarResponse() {
        return hangarResponse;
    }
}
