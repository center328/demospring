package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Event extends BaseModel {
	private String title;
	private String subTitle;
	private String description;

	private Date evDate;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private Set<UserEvent> users;
}
