package com.myfirstapirest.builder;

import com.myfirstapirest.controller.HangarController;
import com.myfirstapirest.model.Hangar;
import com.myfirstapirest.model.HangarResponse;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class HangarResponseResourceAssembler implements ResourceAssembler<HangarResponse, Resource<HangarResponse>> {

    @Override
    public Resource<HangarResponse> toResource(HangarResponse hangarResponse) {

        return new Resource<HangarResponse>(
                hangarResponse,
                linkTo(methodOn(HangarController.class).loadHangars()).withSelfRel(),
                linkTo(methodOn(HangarController.class).loadHangarById(hangarResponse.getId())).withRel("/hangars"));
    }
}