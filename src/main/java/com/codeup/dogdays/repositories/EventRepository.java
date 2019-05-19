package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    Event findById(long id);

    @Query(nativeQuery = true, value="SELECT * FROM events WHERE location LIKE ?")
    List<Event> search(String q);
}
