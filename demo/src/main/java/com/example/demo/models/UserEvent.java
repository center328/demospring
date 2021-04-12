package com.example.demo.models;

import com.example.demo.models.embeded.UserEventKeys;
import com.example.demo.models.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent extends BaseModel {
	@EmbeddedId
	private UserEventKeys keys;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn
	private User user;

	@ManyToOne
	@MapsId("eventId")
	@JoinColumn
	private Event event;

	@Enumerated
	private UserRole userRole;

	public UserEvent(User user, Event event, UserRole userRole) {
		this.user = user;
		this.event = event;
		this.userRole = userRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		UserEvent userEvent = (UserEvent) o;
		return user.equals(userEvent.user) && event.equals(userEvent.event);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), user, event);
	}
}
