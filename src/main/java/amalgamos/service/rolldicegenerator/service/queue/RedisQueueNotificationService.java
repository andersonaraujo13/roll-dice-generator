package amalgamos.service.rolldicegenerator.service.queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import amalgamos.service.rolldicegenerator.model.RollDice;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.UnifiedJedis;

@Service
@Primary
public class RedisQueueNotificationService implements QueueNotificationInterface {
	
 	@Value("${application.redis.url}")
    private String url;

	private UnifiedJedis client;
	
	@Override
	public void publishRoll(RollDice roll) {
		try {
			UnifiedJedis jedis = getClient();
			ObjectMapper mapper = new ObjectMapper();
	        String transform = mapper.writeValueAsString(roll);
			jedis.publish("myChannel", transform);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private synchronized UnifiedJedis getClient() {
		if (client == null) {
			HostAndPort node = HostAndPort.from(url);
			JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().resp3().build();
			client = new UnifiedJedis(node, clientConfig);
			return client;
		}
		
		return client;
	}

}
