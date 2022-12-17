package com.Shopping.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private int userId;
	private LocalDate localDate;
	private String uuid;
}
