package amalgamos.service.rolldicegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import amalgamos.service.rolldicegenerator.domain.RollDice;
import amalgamos.service.rolldicegenerator.service.RollDiceService;

@Controller
public class RollDiceController {

	@Autowired
	private RollDiceService service;
	
	@MessageMapping("/roll")
	public RollDice greeting(RollDice roll) throws Exception {
		System.out.println(roll.toString());
		return service.generate(roll);
	}

}
