package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.EventRepository;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepo;
    private final EventRepository eventRepo;
    private EventController EC;

    public UserController(UserRepository userRepo, EventController EC, EventRepository eventRepo) {
        this.userRepo = userRepo;
        this.eventRepo = eventRepo;
        this.EC = EC;
    }


          
    @GetMapping("/register")
    public String showRegisterForm (Model viewModel){

        viewModel.addAttribute("user", new User());
        return "users/register";
    }



    @PostMapping("/register")
    public String saveUser (@ModelAttribute User user,
                            @RequestParam("confirmedPassword") String confirmedPassword){
        if(user.getPassword().equals(confirmedPassword)){
            user.setPicture("/images/person_default.png");
            userRepo.save(user);
        }
        return "redirect:/login";
    }





            @GetMapping("/login")
            public String showLoginForm () {
                return "users/login";
            }

            @PostMapping("/login")
            public String loginUser (HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
                User user = userRepo.findByUsername(username);
                

                if (password.equals(user.getPassword())) {
                    request.getSession().setAttribute("user", user);
                    return "redirect:/";
                } else {
                    return "redirect:/login";
                }
            }

            @GetMapping("/logout")
            public String logoutUser(HttpServletRequest request){
                request.getSession().removeAttribute("user");
                request.getSession().invalidate();
                return "redirect:/login";
            }

            @GetMapping("/profile")
            public String showProfilePage (HttpServletRequest request, Model vmodel) {

                if(request.getSession().getAttribute("user") == null){
                    return "redirect:/login";
                }

                User user = (User)request.getSession().getAttribute("user");
                vmodel.addAttribute("user", user);
                vmodel.addAttribute("events", EC.eventsByUser((List<Event>)eventRepo.findAll(), user));
                return "users/profile";
            }


            @GetMapping("/users/{id}/edit")
            public String getEditUserForm ( @PathVariable int id){

                return "users/editUser";
            }

            @PostMapping("/users/{id}/edit")
            public String EditUser ( @PathVariable int id){

                return "users/editUser";
            }


        }

