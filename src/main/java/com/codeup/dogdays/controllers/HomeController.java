package com.codeup.dogdays.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome(){
        return "home/home";
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "home/about";
    }

}

