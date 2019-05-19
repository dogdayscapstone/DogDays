package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog,Long> {

//    List<Dog> findByBreedlike(String breed);


    List<Dog> findByBreedLike(String s);
}


