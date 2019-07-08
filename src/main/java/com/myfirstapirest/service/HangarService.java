package com.myfirstapirest.service;

import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.Product;

import java.util.List;
import java.util.stream.Stream;

public interface HangarService {

    List<Hangar> getHangars();
    Hangar getHangarById(long id);
    Hangar getHangarByName(String name);
    Hangar insertHangar(Hangar hangar);
    Hangar insertProductInHangarById(long hangarId, Product product);
}
