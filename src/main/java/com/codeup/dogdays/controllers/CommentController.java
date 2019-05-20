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
import java.util.ArrayList;
import java.util.List;

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

    public List<Comment> commentsByEvent(List<Comment> comments, Event event){
        List<Comment> filteredComments = new ArrayList<>();

        for(int i = 0; i < comments.size(); i++){
            if(comments.get(i).getEvents().getId() == event.getId()){
                filteredComments.add(comments.get(i));
            }
        }

        return filteredComments;
    }



    @PostMapping("/events/{id}/comment")
    public String saveComment(HttpServletRequest request, @ModelAttribute Comment comment, @PathVariable long id) {
        User user = (User)request.getSession().getAttribute("user");

        comment.setUser(user);
        comment.setEvents(eventRepo.findOne(id));

        List<Comment> allComments = (List<Comment>)commentRepo.findAll();
        long count = allComments.size();



        if(comment.getId() == comment.getId()){
            comment.setId((comment.getId()) + 1);
        } else {
            comment.setId(count);
        }

        commentRepo.save(comment);

        return "redirect:/events/" + id;
    }





}
