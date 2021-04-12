package com.example.demo.web.rest.resources;

import com.example.demo.services.EventService;
import com.example.demo.web.rest.dto.EventDTO;
import com.example.demo.web.rest.dvo.EventDVO;
import com.example.demo.web.rest.dvo.ResponseDVO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventResource {

	private final EventService eventService;

	public EventResource(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping
	public ResponseDVO getEvents(@RequestParam @Email String email, Pageable pageable) {
		return eventService.getEvents(email, pageable);
	}

	@GetMapping
	public ResponseDVO getEvent(@RequestParam @NotNull Long id) {
		return eventService.getEvent(id);
	}

	@PostMapping
	@PutMapping
	public ResponseDVO saveEvent(@Valid EventDTO eventDTO) {
		return eventService.saveEvent(eventDTO);
	}

	@DeleteMapping
	public ResponseDVO removeEvent(@RequestParam @NotNull Long id) {
		return eventService.removeEvent(id);
	}
}
