package com.example.demo.web.rest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class EventDTO {

	private Long id;

	@NotBlank
	private String title;
	private String subTitle;
	private String description;

	@NotNull
	private Date evDate;

	@Length(min=1)
	private Set<UserDTO> users;
}
