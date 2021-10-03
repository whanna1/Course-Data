package william.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCoursesByTopicID(String id){
		System.out.println("in CourseService getAllCourses start");
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		System.out.println("in CourseService getAllCourses end");
		//courseRepository.findAll().forEach(courses::add);
	return courses;
	}
	
	
	public Course getCourse(String id){
		return courseRepository.findOne(id);
	}

	
	public void addCourse(Course course){
		System.out.println("in CourseService addCourse");
		courseRepository.save(course);
		System.out.println("in CourseService finished courseRepository save call");
	}


	public void updateCourse(Course course) {
		courseRepository.save(course);
	}


	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
