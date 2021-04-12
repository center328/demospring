package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends BaseModel {

	@Column(unique = true)
	private String email;


	@OneToMany(mappedBy = "event", orphanRemoval = true)
	private Set<UserEvent> events;
}
