package com.ibrahim.todolistpostgres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
