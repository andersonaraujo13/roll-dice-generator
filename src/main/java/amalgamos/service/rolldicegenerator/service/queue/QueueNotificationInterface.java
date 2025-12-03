package amalgamos.service.rolldicegenerator.service.queue;

import amalgamos.service.rolldicegenerator.model.RollDice;

public interface QueueNotificationInterface {
	public void publishRoll(RollDice roll);
}
