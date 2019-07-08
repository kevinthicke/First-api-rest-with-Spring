package com.myfirstapirest.dao;

import com.myfirstapirest.model.Hangar;

import java.util.List;
import java.util.Optional;

public interface HangarDao {

    List<Hangar> getAll();
    Optional<Hangar> getById(long id);
    Optional<Hangar> getByName(String name);
    Hangar save(Hangar hangar);
    boolean existsById(long id);
}
