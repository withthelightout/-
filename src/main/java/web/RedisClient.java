package web;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

	private Jedis jedis;// ����Ƭ��ͻ�������
	private JedisPool jedisPool;// ����Ƭ���ӳ�

	public RedisClient() {
		initialPool();

		jedis = jedisPool.getResource();
	}

	/**
	 * ��ʼ������Ƭ��
	 */
	private void initialPool() {
		// �ػ�������
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}

}
