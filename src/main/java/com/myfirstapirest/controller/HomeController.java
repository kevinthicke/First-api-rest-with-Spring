package com.myfirstapirest.controller;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class HomeController {

    @GetMapping("/api")
    String showEndpoints() {
        String msg = "My Hangar API Rest";
        return msg;

    }
}
