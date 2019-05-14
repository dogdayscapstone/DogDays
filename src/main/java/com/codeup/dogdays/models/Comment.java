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



}
