package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Dog;
import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.DogRepository;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DogController {



    private final DogRepository dogRepo;
    private final UserRepository userRepo;
    private EventController EC;

    public DogController(DogRepository dogRepo, UserRepository userRepo, EventController EC) {
        this.dogRepo = dogRepo;
        this.userRepo = userRepo;
        this.EC = EC;
    }




    @GetMapping("/profile/mydogs")
    public String showDogsProfile(Model model, HttpServletRequest request) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", sessionUser);
        model.addAttribute("dogs", EC.dogsByUser((List<Dog>)dogRepo.findAll(), userRepo.findOne(sessionUser.getId())));

        return "dogs/mydogs";
    }




    @GetMapping("/profile/mydogs/{id}/edit")
    public String getEditDogUserForm( Model model,@PathVariable Long id) {
        Dog dog = dogRepo.findOne(id);
        model.addAttribute("dog", dog);
        return "dogs/editDog";
    }


    @PostMapping("/profile/mydogs/{id}/edit")

    public String editDog(@ModelAttribute Dog dog,HttpServletRequest request) {

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        User user = (User)request.getSession().getAttribute("user");

        User dbUser = userRepo.findOne(sessionUser.getId());
        dog.setDogs(dbUser);
        dogRepo.save(dog);
        return "redirect:/profile";
    }




    @GetMapping("/profile/createDog")
    public String showCreateDogForm(Model model) {
        model.addAttribute("dog", new Dog());
        return "dogs/createDog";
    }

    @PostMapping("/profile/createDog")
    public String createDogPost(@ModelAttribute Dog dog,HttpServletRequest request) {

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User dbUser = userRepo.findOne(sessionUser.getId());

        dog.setDogs(dbUser);

        dogRepo.save(dog);

        return "redirect:/profile";
    }













    @GetMapping("/profile/mydogs/{id}/delete")
    public String deletePost(@PathVariable Long id) {

        Dog dog = dogRepo.findOne(id);

        dogRepo.delete(dog);


        return "redirect:/profile/mydogs";
    }




}
