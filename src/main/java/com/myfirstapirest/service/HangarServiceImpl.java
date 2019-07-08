package com.myfirstapirest.service;

import com.myfirstapirest.dao.HangarDao;
import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.Product;
import com.myfirstapirest.exception.HangarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class HangarServiceImpl implements HangarService {

    @Autowired
    private HangarDao hangardao;

    private boolean isEmpty(List<Hangar> hangars) {

        int numberOfHangarsWithFalseState = (int) hangars.stream()
                .filter(Hangar::isState)
                .count();

        return (hangars.isEmpty() || numberOfHangarsWithFalseState >= 0);

    }

    @Override
    public List<Hangar> getHangars() {

        List<Hangar> hangars = this.hangardao.getAll();

        if(this.isEmpty(hangars))
            throw new HangarException.NotFound();

        return hangars;
    }

    @Override
    public Hangar getHangarById(long id) {

        return this.hangardao
                .getById(id)
                .filter(Hangar::isState)
                .orElseThrow(() -> new HangarException.NotFound(id));
    }

    @Override
    public Hangar getHangarByName(String name) {

        return this.hangardao
                .getByName(name)
                .filter(Hangar::isState)
                .orElseThrow(() -> new HangarException.NotFound(name));

    }

    @Override
    public Hangar insertHangar(Hangar hangar) {

        String hangarName = hangar.getName();

        if (hangardao.getByName(hangarName).isPresent())
            throw new HangarException.AlreadyExists(hangarName);

        return this.hangardao.save(hangar);
    }

    @Override
    public Hangar insertProductInHangarById(long hangarId, Product product) {

        Hangar hangar = this.hangardao
                .getById(hangarId)
                .filter(Hangar::isState)
                .orElseThrow(() -> new HangarException.NotFound(hangarId));



        hangar.getProducts().add(product);

        return this.hangardao.save(hangar);

    }


}
