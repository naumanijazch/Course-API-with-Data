package io.javabrains.sprintbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // marks it as a business service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository
			.findByTopicId(id)
			.forEach(c->courses.add(c));
		return courses;
	}

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	public void addCourses(List<Course> course) {
        courseRepository.saveAll(course);
	}
	
	public void deleteCourses(List<String> ids) {
        ids.forEach(id -> courseRepository.deleteById(id));
        System.out.println("CourseService.deleteCourses() - ids: " + ids);
    }
	
}


