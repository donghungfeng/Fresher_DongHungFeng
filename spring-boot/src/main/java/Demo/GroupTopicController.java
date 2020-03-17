package Demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupTopicController {
	@Autowired
	private GroupTopicModel GroupTopicModel;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/grouptopics")
	private List<GroupTopic> getAllGroupTopics() {
		return GroupTopicModel.getAllGroupTopics();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/grouptopics/{id}")
	private GroupTopic getGroupTopic(@PathVariable int id) {
		return GroupTopicModel.getGroupTopic(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/grouptopic/add")
	private String addGroupTopic(@RequestBody GroupTopic GroupTopic) {
		GroupTopicModel.addGroupTopic(GroupTopic);
		return "Add success!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/groupyopic/update")
	private String updateGroupTopic(@RequestBody GroupTopic GroupTopic) {
		GroupTopicModel.updateGroupTopic(GroupTopic);
		return "Update success!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/grouptopic/delete/{id}")
	private String deleteGroupTopic(@PathVariable int id) {
		GroupTopicModel.deleteGroupTopic(id);
		return "Delete success!";
	}
}
