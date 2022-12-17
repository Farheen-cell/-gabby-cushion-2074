package com.masai.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao cDao;
	
	
	@Override
	public Course registerNewCourse(Course course) {
	
		Set<Student> students= course.getStudents();
		
		for(Student student:students) {
			
			//associating each student with course
			student.getCourses().add(course);
			
		}
		
		
		
		return  cDao.save(course);
		
		
		
	}

}
