package amalgamos.service.rolldicegenerator.service.queue;

import amalgamos.service.rolldicegenerator.domain.RollDice;

public interface QueueNotificationInterface {
	public void publishRoll(RollDice roll);
}
