wpackage com.masai.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Course;
import com.masai.model.Student;

public interface CourseDao extends JpaRepository<Course, Integer>{

	public Course findByCourseName(String cname);
	
	
	
	//@Query("from Course where courseName=?1")
	@Query("select c from Course c where c.courseName=?1")
	public Course getCourseByCname(String cname);
	
	@Query("select c.students from Course c where c.courseName=?1")
	public Set<Student> getStudentsByCname(String cname);
	
	
}




