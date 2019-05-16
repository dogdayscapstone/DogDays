package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Attendees;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository <Attendees, Long> {


}

