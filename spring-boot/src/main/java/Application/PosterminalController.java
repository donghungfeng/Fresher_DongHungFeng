package Application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.PosterminalService;

import entities.Posterminal;

@RestController
public class PosterminalController {
	@Autowired
	private PosterminalService posterminalService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/posterminal/getall")
	private List<Posterminal> getAll() {
		return posterminalService.getAll("");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/posterminal/searchbyname/{name}")
	private List<Posterminal> searchByName(@PathVariable String name) {
		return posterminalService.getAll(name);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/posterminal/getbyid")
	private Posterminal getById(@RequestBody Posterminal posterminal) {
		return posterminalService.getById(posterminal.getPosterminalid());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/posterminal/save")
	private int save(@RequestBody Posterminal posterminal) {
		return posterminalService.save(posterminal);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/posterminal/delete")
	private int delete(@RequestBody Posterminal posterminal) {
		return posterminalService.delete(posterminal);
		
	}

}
