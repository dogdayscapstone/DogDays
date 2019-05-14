package com.codeup.dogdays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DogController {


    @GetMapping("/profile/mydogs")
    public String showDogsProfile() {
        return "users/mydogs";
    }


    @GetMapping("/users/{id}/mydogs/{dogId}/edit")
    public String getEditDogUserForm(@PathVariable int id, @PathVariable int dogId) {

        return "users/editDog";
    }

}
