package com.codeup.dogdays.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attendees")
public class Attendees implements Serializable {


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToOne
    private Dog dogs;

    public Attendees(){};

    public Attendees(Dog dogs) {
        this.dogs = dogs;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Dog getDogs() {
        return dogs;
    }

    public void setDogs(Dog dogs) {
        this.dogs = dogs;
    }
}
