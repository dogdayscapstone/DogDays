package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Comment;
import com.codeup.dogdays.models.Event;

import com.codeup.dogdays.repositories.CommentRepository;

import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.EventRepository;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class EventController {

    private final EventRepository eventRepo;
    private final UserRepository userRepo;

    private final CommentRepository commentRepo;





    public EventController(EventRepository eventRepo, UserRepository userRepo, CommentRepository commentRepo) {
        this.eventRepo = eventRepo;
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
    }


    @GetMapping("/events")
    public String allEvents (Model model){
        model.addAttribute("events", eventRepo.findAll());

        return "events/events";
    }



    @GetMapping("/events/create")
    public String showPostForm (Model model){

        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/events/create")
    public String createPost (@ModelAttribute Event event, HttpServletRequest request) {


//        User user = (User)request.getSession().getAttribute("user");
//        User dbUser = userRepo.findOne(user.getId());
//        event.setUser(dbUser);

        eventRepo.save(event);
        return "redirect:/events";

    }


    @GetMapping("/events/{id}")
    public String getOneBook (Model model, @PathVariable Long id){
        Event event = eventRepo.findOne(id);
        model.addAttribute("event", event);
        model.addAttribute("commentA", new Comment());
        model.addAttribute("comments", commentRepo.findAll());
        return "events/show";
    }


    @GetMapping("/events/{id}/edit")
    public String editForm ( @PathVariable int id, Model model){
        Event event = eventRepo.findOne((long) id);
        model.addAttribute("event", event);
        return "events/edit";

    }

    @PostMapping("/events/{id}/edit")
    public String editPost (@ModelAttribute Event event){
        eventRepo.save(event);
        return "redirect:/events";
    }


    @GetMapping("/events/{id}/delete")
    public String deletePost (@PathVariable Long id, Model model){
        Event event = eventRepo.findOne(id);
        eventRepo.delete(event);
        return "redirect:/events";
    }




}