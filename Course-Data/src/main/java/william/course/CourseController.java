package william.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import william.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	//2nd Commit git test
	//Added for git
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		System.out.println("in CourseController getAllCourses");
		return courseService.getCoursesByTopicID( id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String id) {
		System.out.println("in CourseController addCourse");
		course.setTopic(new Topic(id, "", ""));
		courseService.addCourse(course);
		
	}	

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		
	}	

}
