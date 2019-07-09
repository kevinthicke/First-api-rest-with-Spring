package com.myfirstapirest.controller;

import com.myfirstapirest.builder.HangarResponseBuilder;
import com.myfirstapirest.builder.HangarResponseResourceAssembler;
import com.myfirstapirest.builder.ProductResponseBuilder;
import com.myfirstapirest.model.*;
import com.myfirstapirest.service.HangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.BasicLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class HangarController {

    @Autowired
    private HangarService hangarService;

    @Autowired
    private HangarResponseResourceAssembler hangarResponseResourceAssembler;

    @GetMapping("/hangars")
    public ResponseEntity<?> loadHangars() {

        List<HangarResponse> hangarsResponse = new ArrayList<HangarResponse>();

        List<Resource> listHangarResponseResource = this.hangarService
                .getHangars()
                .stream()
                .map(hangar -> new HangarResponseBuilder(hangar).getHangarResponse())
                .map(hangarResponseResourceAssembler::toResource)
                .collect(Collectors.toList());

        return new ResponseEntity< List<Resource> >(
                listHangarResponseResource,
                HttpStatus.OK
        );

    }

    @GetMapping("/hangars/{id}")
    public ResponseEntity<?> loadHangarById(@PathVariable(value = "id") long id) {

        Hangar hangar = hangarService.getHangarById(id);
        List <Product> hangarProducts = hangar.getProducts();

        Resource hangarResponseResource = hangarResponseResourceAssembler
                .toResource(new HangarResponseBuilder(hangar).getHangarResponse());

        return new ResponseEntity<Resource> (
                hangarResponseResource,
                HttpStatus.OK
        );
    }

    @GetMapping("/hangars/search")
    ResponseEntity<?> loadHangarByName(@RequestParam String name) {

        Hangar hangar = this.hangarService.getHangarByName(name);

        Resource hangarResponseResource = hangarResponseResourceAssembler
                .toResource(new HangarResponseBuilder(hangar).getHangarResponse());

        return new ResponseEntity<Resource>(
                hangarResponseResource,
                HttpStatus.OK);
    }

    @PostMapping("/hangars")
    ResponseEntity<Resource> saveHangar(@Valid @RequestBody HangarRequest hangarRequest) {

        String hangarRequestName = hangarRequest.getName();
        Hangar hangar = this.hangarService.insertHangar(new Hangar(hangarRequestName));

        Resource hangarResponseResource = hangarResponseResourceAssembler
                .toResource(new HangarResponseBuilder(hangar).getHangarResponse());

        return new ResponseEntity<Resource>(
                hangarResponseResource,
                HttpStatus.CREATED);

    }

    @PostMapping("/hangars/{id}")
    ResponseEntity<Resource> saveProductInHangarById(@PathVariable("id") long id,
                                                           @RequestBody Product product) {

        Hangar hangar = this.hangarService.insertProductInHangarById(id, product);
        
        Resource hangarResponseResource = hangarResponseResourceAssembler
                .toResource(new HangarResponseBuilder(hangar).getHangarResponse());


        return new ResponseEntity<Resource>(
                hangarResponseResource,
                HttpStatus.CREATED
        );
    }
}
