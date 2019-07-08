package com.myfirstapirest.dao;

import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class HangarDaoImpl implements HangarDao {

    @Autowired
    private HangarRepository hangarRepository;

    @Override
    public List<Hangar> getAll() {
        return this.hangarRepository.findAll();
    }

    @Override
    public Optional<Hangar> getById(long id) {
        return this.hangarRepository.findById(id);
    }

    @Override
    public Optional<Hangar> getByName(String name) {
        return this.hangarRepository.findByName(name);
    }

    @Override
    public Hangar save(Hangar hangar) {
        return this.hangarRepository.save(hangar);
    }

    @Override
    public boolean existsById(long id) {
        return this.hangarRepository.existsById(id);
    }
}
