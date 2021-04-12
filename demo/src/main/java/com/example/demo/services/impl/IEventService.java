package com.example.demo.services.impl;

import com.example.demo.models.Event;
import com.example.demo.models.UserEvent;
import com.example.demo.repositories.EventRepository;
import com.example.demo.services.EventService;
import com.example.demo.services.UserService;
import com.example.demo.web.rest.dto.EventDTO;
import com.example.demo.web.rest.dvo.EventDVO;
import com.example.demo.web.rest.dvo.ResponseDVO;
import com.example.demo.web.rest.dvo.UserDVO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IEventService implements EventService {
	private final EventRepository eventRepository;
	private final UserService userService;

	public IEventService(EventRepository eventRepository, UserService userService) {
		this.eventRepository = eventRepository;
		this.userService = userService;
	}

	@Override
	public ResponseDVO getEvents(String email, Pageable pageable) {
		return ResponseDVO.ok().data(eventRepository.getEventByUserEmail(email, pageable));
	}

	@Override
	public ResponseDVO getEvent(Long id) {
		Optional<Event> eventOpt = eventRepository.findById(id);
		if (eventOpt.isPresent()) {
			EventDVO evDVO = getEventDVO(eventOpt.get());

			return ResponseDVO.ok().data(evDVO);
		}
		return ResponseDVO.notFound();
	}

	@Override
	public ResponseDVO saveEvent(EventDTO eventDTO) {
		try {
			Event event = null;
			if (eventDTO.getId() != null && eventDTO.getId() > 0) {
				event = eventRepository.findById(eventDTO.getId()).orElse(null);
			}
			if (event == null)
				event = new Event();

			event.setDescription(eventDTO.getDescription());
			event.setSubTitle(eventDTO.getSubTitle());
			event.setTitle(eventDTO.getTitle());
			event.setEvDate(eventDTO.getEvDate());

			eventRepository.save(event);

			final Event finalEvent = event;
			Set<UserEvent> users = eventDTO.getUsers().stream()
					.map(u ->
							userService.getUser(u.getEmail())
									.map(user -> new UserEvent(user, finalEvent, u.getRole())).orElse(null)
					).filter(Objects::nonNull)
					.collect(Collectors.toSet());

			event.setUsers(users);

			return ResponseDVO.ok();
		} catch (Exception e) {
			return ResponseDVO.failed().message(e.getMessage());
		}
	}

	@Override
	public ResponseDVO removeEvent(Long id) {
		try {
			eventRepository.deleteById(id);
			return ResponseDVO.ok();
		} catch (Exception e) {
			return ResponseDVO.notFound().message(e.getMessage());
		}
	}

	private EventDVO getEventDVO(Event ev) {
		EventDVO evDVO = EventDVO.builder()
				.id(ev.getId())
				.title(ev.getTitle())
				.subTitle(ev.getSubTitle())
				.description(ev.getDescription())
				.users(
						ev.getUsers().stream()
								.map(uv -> new UserDVO(uv.getUser().getEmail(), uv.getUserRole()))
								.collect(Collectors.toList())
				).build();
		return evDVO;
	}

	private List<EventDVO> getEventDVOs(List<Event> events) {
		return events.stream().map(this::getEventDVO).collect(Collectors.toList());
	}

}
