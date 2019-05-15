//package com.codeup.dogdays.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "attendies")
//public class Attendees {
//
//    @Id
//    @GeneratedValue
//    @OneToOne
//    private Event event;
//
//
//
//    @OneToOne
//    private Dog dogs;
//
//
//    public Attendees(Dog dogs) {
//        this.dogs = dogs;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//
//    public Dog getDogs() {
//        return dogs;
//    }
//
//    public void setDogs(Dog dogs) {
//        this.dogs = dogs;
//    }
//}