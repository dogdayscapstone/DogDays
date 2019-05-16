package com.codeup.dogdays.controllers;

import com.codeup.dogdays.models.Attendees;
import com.codeup.dogdays.models.Dog;
import com.codeup.dogdays.models.Event;
import com.codeup.dogdays.models.User;
import com.codeup.dogdays.repositories.AttendeeRepository;
import com.codeup.dogdays.repositories.DogRepository;
import com.codeup.dogdays.repositories.EventRepository;
import com.codeup.dogdays.repositories.UserRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AttendeeController {

    private final EventRepository eventRepo;
    private final DogRepository dogRepo;
    private final UserRepository userRepo;
    private final AttendeeRepository attendeeRepo;


    public AttendeeController(EventRepository eventRepo, DogRepository dogRepo, UserRepository userRepo,AttendeeRepository attendeeRepo){
        this.eventRepo = eventRepo;
        this.dogRepo = dogRepo;
        this.userRepo = userRepo;
        this.attendeeRepo = attendeeRepo;
    }


    @PostMapping("/events/{id}/add")
    public String addAttendee(HttpServletRequest request, @ModelAttribute Attendees attendee, @PathVariable long id){
        User user = (User) request.getSession().getAttribute("user");
        User dbUser = userRepo.findOne(user.getId());
        List<Dog> userDogs = user.getDogs();

        for(int i = 0; i < userDogs.size(); i ++){

            Dog dbDog = userDogs.get(i);
            attendee.setDogs(dbDog);

            Event dbEvent = eventRepo.findById(id);
            attendee.setEvent(dbEvent);

            attendeeRepo.save(attendee);
        }

        return "redirect:/events/" + id;
    }





}
