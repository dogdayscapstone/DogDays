package com.codeup.dogdays.models;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false)
    private String breed;

    @Column(nullable=false,length=250)
    private String temperament;

    @Column(nullable=false,length=250)
    private String dob;

    @Column(nullable=false,length=5)
    private String gender;

    @Column(nullable=false,length=500)
    private String dogPicture;

    @Column(nullable=false,length=500)
    private String description;


    public Dog(String name, String breed, String temperament, String dob, String gender, String dogPicture, String description, User dogs) {
        this.name = name;
        this.breed = breed;
        this.temperament = temperament;
        this.dob = dob;
        this.gender = gender;
        this.dogPicture = dogPicture;
        this.description = description;
        this.dogs = dogs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @ManyToOne
    @JoinColumn(name="user_id")
    private User dogs;



    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDogPicture() {
        return dogPicture;
    }

    public void setDogPicture(String dogPicture) {
        this.dogPicture = dogPicture;
    }

    public User getDogs() {
        return dogs;
    }

    public void setDogs(User dogs) {
        this.dogs = dogs;
    }

}
