package com.myfirstapirest.controller;

import com.myfirstapirest.builder.HangarResponseBuilder;
import com.myfirstapirest.builder.ProductResponseBuilder;
import com.myfirstapirest.model.*;
import com.myfirstapirest.service.HangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
class HangarController {

    @Autowired
    private HangarService hangarService;

    @GetMapping("/hangars")
    ResponseEntity<List<HangarResponse>> loadHangars() {

        List<HangarResponse> hangarsResponse = new ArrayList<HangarResponse>();

        this.hangarService
                .getHangars()
                .forEach(hangar -> {
                    hangarsResponse.add((new HangarResponseBuilder(hangar)).getHangarResponse());
                });

        return new ResponseEntity<List<HangarResponse>>(
                hangarsResponse,
                HttpStatus.OK);
    }

    @GetMapping("/hangars/{id}")
    ResponseEntity<HangarResponse> loadHangarById(@PathVariable("id") long id) {

        Hangar hangar = hangarService.getHangarById(id);
        HangarResponse hangarResponse = (new HangarResponseBuilder(hangar)).getHangarResponse();

        return new ResponseEntity<HangarResponse>(
                hangarResponse,
                HttpStatus.OK);
    }

    @GetMapping("/hangars/search")
    ResponseEntity<HangarResponse> loadHangarByName(@RequestParam String name) {

        Hangar hangar = this.hangarService.getHangarByName(name);
        HangarResponse hangarResponse = (new HangarResponseBuilder(hangar)).getHangarResponse();

        return new ResponseEntity<HangarResponse>(
                hangarResponse,
                HttpStatus.OK);
    }

    @PostMapping("/hangars")
    ResponseEntity<HangarResponse> saveHangar(@Valid @RequestBody HangarRequest hangarRequest) {

        String hangarRequestName = hangarRequest.getName();

        Hangar hangar = this.hangarService.insertHangar(new Hangar(hangarRequestName));
        HangarResponse hangarResponse = (new HangarResponseBuilder(hangar)).getHangarResponse();

        return new ResponseEntity<HangarResponse>(
                hangarResponse,
                HttpStatus.CREATED);

    }

    @PostMapping("/hangars/{id}")
    ResponseEntity<HangarResponse> saveProductInHangarById(@PathVariable("id") long id,
                                                           @RequestBody Product product) {

        Hangar hangar = this.hangarService.insertProductInHangarById(id, product);
        HangarResponse hangarResponse = new HangarResponseBuilder(hangar).getHangarResponse();

        return new ResponseEntity<HangarResponse>(
                hangarResponse,
                HttpStatus.CREATED
        );
    }
}
