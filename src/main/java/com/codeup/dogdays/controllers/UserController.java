package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserController {
    private final UserRepository userRepo;
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }




    @GetMapping("/signup")
    public String showRegisterForm() {
        return "users/signup";
    }



    @PostMapping("/signup")
    public String saveUser(){
        return "users/signup";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "users/profile";
    }





    @GetMapping("/users/{id}/edit")
    public String getEditUserForm(@PathVariable int id){

        return "users/editUser";
    }

    @PostMapping("/users/{id}/edit")
    public String EditUser(@PathVariable int id){

        return "users/editUser";
    }
}
