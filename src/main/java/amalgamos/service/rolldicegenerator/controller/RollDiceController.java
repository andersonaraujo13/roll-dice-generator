package amalgamos.service.rolldicegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import amalgamos.service.rolldicegenerator.model.RollDice;
import amalgamos.service.rolldicegenerator.service.RollDiceService;

@RestController
public class RollDiceController {

	@Autowired
	private RollDiceService service;
	
	@PostMapping("/roll")
	public RollDice roll(@RequestBody RollDice roll) throws Exception {
		return service.generate(roll);
	}
}
