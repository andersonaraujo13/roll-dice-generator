package amalgamos.service.rolldicegenerator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amalgamos.service.rolldicegenerator.model.Dice;
import amalgamos.service.rolldicegenerator.model.RollDice;
import amalgamos.service.rolldicegenerator.service.queue.QueueNotificationInterface;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class RollDiceService {

	@Autowired
	private QueueNotificationInterface queueService;
	
	public RollDice generate(RollDice roll) {
		roll.setJogadas(generateRolls(roll.getFormula()));
		roll.setFormulaAlterada(convertFormula(roll.getFormula(), roll.getJogadas()));
		roll.setResultadoFinal(parseValorFinal(roll.getFormulaAlterada()));
		queueService.publishRoll(roll);
		return roll;
	}
	
	private String convertFormula(String formula, List<Dice> jogadas) {
		String subFormula = formula;
		
        for(Dice dice : jogadas) {
        	CharSequence roll = dice.getJogada();
        	CharSequence total = dice.getTotal().toString();
        	subFormula = subFormula.replace(roll, total);
        }
        
        return subFormula;
	}
	
	private Integer parseValorFinal(String formula) {
		Expression e = new ExpressionBuilder(formula).build();
		return Double.valueOf(e.evaluate()).intValue();
	}
	
	private List<Dice> generateRolls(String formula){
        Pattern pattern = Pattern.compile("([0-9]+D[0-9]+)");
        Matcher matcher = pattern.matcher(formula.toUpperCase());
        List<Dice> jogadas = new ArrayList<Dice>();
        
        while (matcher.find()) {
        	jogadas.add(generateDiceValue(matcher.group()));
        }
		
        return jogadas;
	}

	private Dice generateDiceValue(String dice) {
		String[] split = dice.split("D");
		Random rng = new Random();
		Integer quantidade = Integer.parseInt(split[0]);
		Integer face = Integer.parseInt(split[1]);
		Integer valorFinal = 0;
		List<Integer> valores = new ArrayList<Integer>();
		
		for(int contador = 0; contador < quantidade; contador++) {
			Integer resultado = rng.nextInt(face) + 1;
			valores.add(resultado);
			valorFinal = valorFinal + resultado;
		}
		
		return new Dice(dice, face, quantidade, valorFinal, valores);
	}
}
