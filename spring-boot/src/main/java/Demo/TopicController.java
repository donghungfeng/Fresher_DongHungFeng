package Demo;

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
	@RequestMapping("/datasource/{db}")
	private String getGroupTopic(@PathVariable String db) {
		topicModel = new TopicModel(db);
		return "Switch to "+db;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/topics")
	private List<Topic> getAllTopics() {
		return topicModel.getAllTopics("");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/topics/searchbyname/{name}")
	private List<Topic> getAllTopics(@PathVariable String name) {
		return topicModel.getAllTopics(name);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topics/{id}")
	private Topic getTopic(@PathVariable String id) {
		return topicModel.getTopic(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topic/add")
	private String addTopic(@RequestBody Topic topic) {
		return topicModel.addTopic(topic);
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
		return "";
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/topic/getbygroupid/{id}")
	private List<Topic> getTopicByGroupId(@PathVariable int id) {
		if(id==0)
			return topicModel.getAllTopics("");
		return topicModel.getAllTopicByGroupId(id);
	}
}
