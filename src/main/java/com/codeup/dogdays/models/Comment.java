package com.codeup.dogdays.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User comments;


    @ManyToOne
    @JoinColumn(name="event_id")
    private Event events;

    @Column(nullable = false, length = 550)
    private String comment;

    public Comment(){}

    public Comment(User user, Event event, String comment){
        this.comments = user;
        this.events = event;
        this.comment = comment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getComments() {
        return comments;
    }

    public void setComments(User comments) {
        this.comments = comments;
    }

    public Event getEvents() {
        return events;
    }

    public void setEvents(Event events) {
        this.events = events;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
