package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Dog;
import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.repositories.DogRepository;
import com.codeup.dogdays.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogController {

    public DogController(DogRepository dogRepo) {
        this.dogRepo = dogRepo;
    }

    private final DogRepository dogRepo;


    @GetMapping("/profile/mydogs")
    public String showDogsProfile(Model model) {
        model.addAttribute("dogs", dogRepo.findAll());
        return "users/mydogs";
    }


    @GetMapping("/profile/mydogs/{dogId}/edit")
    public String getEditDogUserForm(@PathVariable int dogId, Model model) {
        Dog dog = dogRepo.findOne((long) dogId);
        model.addAttribute("dog", dog);
        return "users/editDog";
    }


    @PostMapping("/profile/mydogs/{dogId}/edit")
    public String editDog(@ModelAttribute Dog dog) {
        dogRepo.save(dog);
        return "redirect:/profile/mydogs";
    }



    @GetMapping("/profile/createDog")
    public String showCreateDogForm(Model model) {
        model.addAttribute("dog", new Dog());
        return "users/createDog";


    }

    @PostMapping("/profile/createDog")
    public String createDogPost(@ModelAttribute Dog dog) {


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