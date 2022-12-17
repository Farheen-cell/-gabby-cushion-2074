package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Course;
import com.masai.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cService;
	
	/*
	
	{

		"courseName": "Java",
		"fee": 8500,
		"students": [

		    {
		        "name": "Ram",
		        "marks": 850,
		        "addr": {
		            "state": "WB",
		            "city": "kolkata",
		            "pincode": "787888"
		        }
		    },
		    {
		        "name": "Ramesh",
		        "marks": 820,
		        "addr": {
		            "state": "punjab",
		            "city": "mohali",
		            "pincode": "687888"
		        }
		    }

		]


		}
	
	
	*/
	
	
	@PostMapping("/courses")
	public ResponseEntity<Course> saveCourseHandler(@RequestBody Course course){
		
		Course savedCourse= cService.registerNewCourse(course);
		
		
		return new ResponseEntity<Course>(savedCourse,HttpStatus.CREATED);
	}
	
	
	
	
}
