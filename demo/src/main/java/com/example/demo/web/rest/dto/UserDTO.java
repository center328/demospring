package com.example.demo.web.rest.dto;

import com.example.demo.models.enums.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"role"})
public class UserDTO {

	private String email;

	private UserRole role;
}
