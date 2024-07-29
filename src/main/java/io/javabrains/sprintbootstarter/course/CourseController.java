package io.javabrains.sprintbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.javabrains.sprintbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired // marks it as it needs dependency injections
	private CourseService courseService;
	
	// GET API - get call is the default
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	// GET API
	@GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }
	
	// POST API
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) { // gets pay load from the request body and saves it as topic object
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);	
	}
	
//	// POST API
//	@PostMapping("/courses/batch")
//    public void addCourses(@RequestBody List<Course> courses) {
//        courseService.addCourses(courses);
//    }
	
	// PUT API
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) { 
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);	
	}
	
	// DELETE API
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse( @PathVariable String id) { 
		courseService.deleteCourse(id);	
	}
	
	// DELETE API
	@DeleteMapping("/topics/{topicId}/courses")
	public void deleteCourses(@PathVariable String topicId, @RequestParam List<String> ids) {
	    courseService.deleteCourses(ids);
	}
}

