package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Dog;
import com.codeup.dogdays.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog,Long> {

    Dog findById(long id);
    Dog findOne(long id);
}


