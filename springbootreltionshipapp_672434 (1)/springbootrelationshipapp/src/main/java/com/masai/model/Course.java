package com.masai.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data  // @Getter and @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Course {



	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private Integer fee;
	private String desc;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
	private Set<Student> students= new HashSet<>();

		
}
