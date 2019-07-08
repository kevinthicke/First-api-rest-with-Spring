package com.myfirstapirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class HomeController {

    private final String URIs =
            "load Hangars: /api/hangars" + "\n"
            + "search hangar by name: /api/hangars?name=My Hangar Name";

    @GetMapping("/api")
    String showURIs() {
        return this.URIs;
    }
}
