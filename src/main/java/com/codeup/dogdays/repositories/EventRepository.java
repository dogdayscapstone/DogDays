package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
