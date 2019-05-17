package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Comment;
import com.codeup.dogdays.models.Dog;
import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.DogRepository;
import com.codeup.dogdays.repositories.EventRepository;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DogController {



    private final DogRepository dogRepo;
    private final UserRepository userRepo;

    public DogController(DogRepository dogRepo, UserRepository userRepo) {
        this.dogRepo = dogRepo;
        this.userRepo = userRepo;
    }




    @GetMapping("/profile/mydogs")
    public String showDogsProfile(Model model) {
        model.addAttribute("dogs", dogRepo.findAll());
        return "users/mydogs";
    }




    @GetMapping("/profile/mydogs/{id}/edit")
    public String getEditDogUserForm( Model model,@PathVariable Long id) {
        Dog dog = dogRepo.findOne(id);
        model.addAttribute("dog", dog);
        return "users/editDog";
    }


    @PostMapping("/profile/mydogs/{id}/edit")
    public String editDog(@ModelAttribute Dog dog,HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        User dbUser = userRepo.findOne(user.getId());
        dog.setDogs(dbUser);
        dogRepo.save(dog);
        return "redirect:/profile/mydogs";
    }




    @GetMapping("/profile/createDog")
    public String showCreateDogForm(Model model) {
        model.addAttribute("dog", new Dog());
        return "users/createDog";
    }

    @PostMapping("/profile/createDog")
    public String createDogPost(@ModelAttribute Dog dog,HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        User dbUser = userRepo.findOne(user.getId());
        dog.setDogs(dbUser);
        dogRepo.save(dog);
        return "redirect:/profile/mydogs";
    }

    @GetMapping("/profile/mydogs/{id}/delete")
    public String deletePost(@PathVariable Long id, Model model) {
        Dog dog = dogRepo.findOne(id);
        dogRepo.delete(dog);
        return "redirect:/profile/mydogs";
    }




}
