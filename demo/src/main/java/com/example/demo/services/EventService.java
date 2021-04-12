package com.example.demo.services;

import com.example.demo.web.rest.dto.EventDTO;
import com.example.demo.web.rest.dvo.EventDVO;
import com.example.demo.web.rest.dvo.ResponseDVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
	ResponseDVO getEvents(String email, Pageable pageable);

	ResponseDVO getEvent(Long id);

	ResponseDVO saveEvent(EventDTO eventDTO);

	ResponseDVO removeEvent(Long id);
}
