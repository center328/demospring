package com.example.demo.models.embeded;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class UserEventKeys implements Serializable {
	private Long userId;
	private Long eventId;
}
