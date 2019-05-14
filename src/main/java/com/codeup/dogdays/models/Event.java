package com.codeup.dogdays.models;

import javax.persistence.*;

@Entity @Table(name = "events")
public class Event {

    public Event (){}

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String location;

}
