package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
