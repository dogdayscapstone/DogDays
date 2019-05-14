package com.codeup.dogdays.controllers;

import com.codeup.dogdays.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class EventController {

    private final EventRepository eventRepo;

    public EventController(EventRepository eventRepo){
        this.eventRepo = eventRepo;
    }

    @GetMapping("/events")
    public String allEvents(){
        return "events";
    }


    @GetMapping("/events/{id}")
    public String showEvent(@PathVariable int id){

        return "events/show";
    }



    @GetMapping("/events/{id}/edit")
    public String editEvent(@PathVariable int id){

        return "events/edit";
    }

}
