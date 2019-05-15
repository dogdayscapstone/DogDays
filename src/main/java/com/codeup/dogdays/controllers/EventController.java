package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EventController {

    private final EventRepository eventRepo;

    public EventController(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @GetMapping("/events")
    public String allEvents(Model model) {
        model.addAttribute("events", eventRepo.findAll());

        return "/events/events";
    }

    @GetMapping("/events/create")
    public String createPost(Model model) {
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/events/create")
    public String createPost(@ModelAttribute Event event) {

        eventRepo.save(event);
        return "redirect:/events";


    }


    @GetMapping("/events/{id}")
    public String getOneBook(Model model, @PathVariable Long id) {
        Event event=eventRepo.findOne(id);
       model.addAttribute("event",event);
        return "events/show";
    }





    @GetMapping("/events/{id}/edit")
    public String editEvent(@PathVariable int id) {

        return "events/edit";
    }


    }
