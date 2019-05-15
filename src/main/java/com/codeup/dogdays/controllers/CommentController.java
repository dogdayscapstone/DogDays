package com.codeup.dogdays.controllers;


import com.codeup.dogdays.models.Comment;
import com.codeup.dogdays.repositories.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private final CommentRepository commentRepo;


    public CommentController(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }



    @PostMapping("/events/{id}/comment")
    public String saveComment(@ModelAttribute Comment comment, @PathVariable Long id) {

        commentRepo.save(comment);
        return "events/" + id;
    }



}
