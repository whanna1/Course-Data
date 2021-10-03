package william;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseDataApplication.class, args);
		int a =7777;
		short s =5;
		s = (short)a;
	}
}


