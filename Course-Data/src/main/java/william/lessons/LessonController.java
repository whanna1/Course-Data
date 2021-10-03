package william.lessons;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import william.course.Course;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id) {
		System.out.println("in LessonController getAllLessons");
		return lessonService.getLessonsByCourseID( id);
	}
	
	@RequestMapping("/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		
		return lessonService.getLesson(id);
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/courses/{id}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String id) {
		System.out.println("in LessonController addLesson");
		lesson.setCourse(new Course(id, "", "",""));
		lessonService.addLesson(lesson);
		
	}	

	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String id) {
		lesson.setCourse(new Course(courseId, "", "",""));
		lessonService.updateLesson(lesson);
		
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
		
	}	

}
