package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog,Long> {

}
