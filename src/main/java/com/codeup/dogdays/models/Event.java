package com.codeup.dogdays.models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, length = 255)
    private java.sql.Date date;

    @Column(nullable = false, length = 255)
    private java.sql.Time time;

    @OneToOne
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private List<Comment> comments;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_id")
    )
    private List<Dog> dogAttendees = new ArrayList<>();



    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public Event (){}

    public Event(String title, String description, String location, java.sql.Date date, java.sql.Time time, User user){

        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.user = user;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dog> getDogAttendees() {
        return dogAttendees;
    }

    public void setDogAttendees(List<Dog> dogAttendee, Dog dog) {
        dogAttendee.add(dog);
        this.dogAttendees = dogAttendee;
    }
}
