package amalgamos.service.rolldicegenerator.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dice {

	private String jogada;
	private Integer face;
	private Integer quantidade;
	private Integer total;
	private List<Integer> valores;
}
