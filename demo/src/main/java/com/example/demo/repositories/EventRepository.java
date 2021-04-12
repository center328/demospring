package com.example.demo.repositories;

import com.example.demo.models.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	@Query("SELECT ev.id, ev.title, ev.subTitle, ev.description, ev.evDate, ev.users FROM Event AS ev " +
			"INNER JOIN UserEvent AS uev ON uev.event.id = ev.id WHERE uev.user.email = :email")
	List<Event> getEventByUserEmail(String email, Pageable pageable);
}
