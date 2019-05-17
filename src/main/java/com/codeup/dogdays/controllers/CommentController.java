package com.codeup.dogdays.controllers;


import com.codeup.dogdays.models.Comment;
import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.CommentRepository;
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
public class CommentController {

    private final CommentRepository commentRepo;
    private final EventRepository eventRepo;
    private final UserRepository userRepo;


    public CommentController(CommentRepository commentRepo, EventRepository eventRepo, UserRepository userRepo) {
        this.commentRepo = commentRepo;
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
    }



    @PostMapping("/events/{id}/comment")
    public String saveComment(HttpServletRequest request, @ModelAttribute Comment comment, @PathVariable long id) {
        User user = (User)request.getSession().getAttribute("user");
        comment.setUser(user);
        comment.setEvents(eventRepo.findOne(id));
        commentRepo.save(comment);
        return "redirect:/events/" + id;
    }



}
