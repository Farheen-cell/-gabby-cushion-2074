package com.masai.service;

import java.util.List;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentService {
	
public Student registerStudentInCourse(String cname,Student student)throws CourseException;

public List<Student> findStudentsByCname(String cname)throws CourseException;


}
