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

import com.api.CashierService;

import entities.Cashier;

@RestController
public class CashierController {
	@Autowired
	private CashierService cashierService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashier/getall")
	private List<Cashier> getAll() {
		return cashierService.getAll("");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashier/searchbyname/{name}")
	private List<Cashier> searchByName(@PathVariable String name) {
		return cashierService.getAll(name);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/cashier/getbyid")
	private Cashier getById(@RequestBody Cashier cashier) {
		return cashierService.getById(cashier.getCashierid());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/cashier/save")
	private int save(@RequestBody Cashier cashier) {
		return cashierService.save(cashier);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/cashier/delete")
	private int delete(@RequestBody Cashier cashier) {
		return cashierService.delete(cashier);
		
	}

}
