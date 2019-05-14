package com.codeup.dogdays.models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity @Table(name = "events")
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
    private String date;

    @Column(nullable = false, length = 5)
    private int time;

    @OneToOne
    private User user;

    public Event (){}

    public Event(String title, String description, String location, String date, int time, User user){

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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
}
