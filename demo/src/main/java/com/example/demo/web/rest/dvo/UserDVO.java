package com.example.demo.web.rest.dvo;

import com.example.demo.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = {"role"})
@NoArgsConstructor
@AllArgsConstructor
public class UserDVO {

	private String email;

	private UserRole role;
}
