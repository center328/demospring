package com.example.demo.web.rest.dvo;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDVO {

	private Long id;

	private String title;
	private String subTitle;
	private String description;

	private Date evDate;

	private List<UserDVO> users;



//	public static EventDVOBuilder event(Event event) {
//
//	}
}
