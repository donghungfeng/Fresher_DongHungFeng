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

import com.api.CashierPosterminalService;

import entities.Cashier;
import entities.CashierPosterminal;

@RestController
public class CashierPosterminalController {
	@Autowired
	private CashierPosterminalService cashierPosterminalService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashierposterminal/getall")
	private List<CashierPosterminal> getAll() {
		return cashierPosterminalService.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashierposterminal/getbycashierid")
	private List<CashierPosterminal> getByCashierid(@RequestBody CashierPosterminal cashier) {
		return cashierPosterminalService.getByCashierid(cashier);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashierposterminal/getbypoterminalid")
	private List<CashierPosterminal> getByPosterminalid(@RequestBody CashierPosterminal cashier) {
		return cashierPosterminalService.getByPosterminalid(cashier);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/cashierposterminal/save")
	private int save(@RequestBody CashierPosterminal cashier) {
		return cashierPosterminalService.save(cashier);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/cashierposterminal/delete")
	private int delete(@RequestBody CashierPosterminal cashier) {
		return cashierPosterminalService.delete(cashier);
		
	}

}
