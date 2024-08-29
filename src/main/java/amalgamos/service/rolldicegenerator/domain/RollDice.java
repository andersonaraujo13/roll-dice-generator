package amalgamos.service.rolldicegenerator.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RollDice {
	private String nomePlayer;
	private String tipo;
	private String nomePericia;
	private String formula;
	private String formulaAlterada;
	private Integer resultadoFinal;
	private List<Dice> jogadas;
}
