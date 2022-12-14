package com.gabby.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {

	
	
	@Id
	@Column(unique = true)
	private Integer userId;
	
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	public Session findByuuid(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
