package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseDao;
import com.masai.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao sDao;
	
	@Autowired
	private CourseDao cDao;
	
	
	
	
	@Override
	public Student registerStudentInCourse(String cname, Student student) throws CourseException {
		
		Course course= cDao.findByCourseName(cname);
	
		if(course != null) {
			
			course.getStudents().add(student);
			student.getCourses().add(course);
			
			return sDao.save(student);
		}
		else
			throw new CourseException("Course not found with name "+cname);
	
	
	
	}




	@Override
	public List<Student> findStudentsByCname(String cname) throws CourseException {
		
		System.out.println("*****************");
		
		Set<Student> students= cDao.getStudentsByCname(cname);
		System.out.println("==============="+students);
		
		if(students.size() > 0)
		{
		
		List<Student> list=new ArrayList<>(students);
		
		return list;
		}
		else
			throw new CourseException("Course does not exist with name "+cname);
		
	}

	
	
	
	
}
