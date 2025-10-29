package amalgamos.service.rolldicegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"amalgamos.service.rolldicegenerator.service.*"}) 
public class RollDiceGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollDiceGeneratorApplication.class, args);
	}

}
