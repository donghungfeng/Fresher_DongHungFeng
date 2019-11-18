package com.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicModel topicModel;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/topics")
	private List<Topic> getAllTopics() {
		return topicModel.getAllTopics();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topics/{id}")
	private Topic getTopic(@PathVariable String id) {
		return topicModel.getTopic(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topic/add")
	private String addTopic(@RequestBody Topic topic) {
		topicModel.addTopic(topic);
		return "Add success!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topic/update")
	private String updateTopic(@RequestBody Topic topic) {
		topicModel.updateTopic(topic);
		return "Update success!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topic/delete/{id}")
	private String deleteTopic(@PathVariable String id) {
		topicModel.deleteTopic(id);
		return "Delete success!";
	}
}
