package com.codeup.dogdays.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")

public class User {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private boolean isFlagged;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Event> events;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "dogs")
    private List<Dog> dogs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();


    public User(){}


    public User(String username, String email, String password, String picture){
        this. username = username;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.isAdmin = false;
        this.isFlagged = false;
    }

    public User(String username, String email, String password){
        this. username = username;
        this.email = email;
        this.password = password;
        this.picture = "/images/person_default.png";
        this.isAdmin = false;
        this.isFlagged = false;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        picture=copy.picture;
        isAdmin=copy.isAdmin;
        isFlagged=copy.isFlagged;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
