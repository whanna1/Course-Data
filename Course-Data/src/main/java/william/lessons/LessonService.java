package william.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getLessonsByCourseID(String id){
		System.out.println("in LessonService getAllLessons start");
		List<Lesson> lessons = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(id).forEach(lessons::add);
		System.out.println("in LessonService getAllLessons end");
		//lessonRepository.findAll().forEach(lessons::add);
	return lessons;
	}
	
	
	public Lesson getLesson(String id){
		return lessonRepository.findOne(id);
	}

	
	public void addLesson(Lesson lesson){
		System.out.println("in LessonService addLesson");
		lessonRepository.save(lesson);
		System.out.println("in LessonService finished lessonRepository save call");
	}


	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}


	public void deleteLesson(String id) {
		lessonRepository.delete(id);
	}
}
