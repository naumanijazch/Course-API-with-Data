package io.javabrains.sprintbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // marks it as a business service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository
			.findAll()
			.forEach(t->topics.add(t));
		return topics;
	}

    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id ) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

	public void addTopics(List<Topic> topics) {
        topicRepository.saveAll(topics);
	}
	
}


