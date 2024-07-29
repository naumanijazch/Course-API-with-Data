package io.javabrains.sprintbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
	
	@Autowired // marks it as it needs dependency injections
	private TopicService topicService;
	
	// GET API
	@GetMapping("/")
	public String homepage() {
		return "Welcome to the Homepage";
	}
	
	// GET API - get call is the default
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	// GET API
	@GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }
	
	// POST API
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) { // gets pay load from the request body and saves it as topic object
		topicService.addTopic(topic);	
	}
	
	// POST API
	@PostMapping("/topics/batch")
    public void addTopics(@RequestBody List<Topic> topics) {
        topicService.addTopics(topics);
    }
	
	// PUT API
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { 
		topicService.updateTopic(topic, id);	
	}
	
	// DELETE API
	@DeleteMapping("/topics/{id}")
	public void deleteTopic( @PathVariable String id) { 
		topicService.deleteTopic(id);	
	}
}

