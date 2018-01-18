package cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.SeckillDao;
import dao.cache.RedisDao;
import entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class RedisDaoTest {

	private long id = 1001;

	@Autowired
	private RedisDao redisDao;

	@Autowired
	private SeckillDao seckillDao;

	@Test
	public void testSeckill() throws Exception {
		// get and put
		long start = System.currentTimeMillis();
		Seckill seckill = redisDao.getSeckill(id);
		long end = System.currentTimeMillis();
		System.out.println("redis所用时间为" + (end - start) + "毫秒");
		long startFormysql = System.currentTimeMillis();
		seckill = seckillDao.queryById(id);
		long endFormysql = System.currentTimeMillis();
		System.out.println("mysql所用时间为" + (endFormysql - startFormysql) + "毫秒");
		System.out.println(seckill);
		if (seckill == null) {
			seckill = seckillDao.queryById(id);
			System.out.println(seckill);
			if (seckill != null) {
				String result = redisDao.putSeckill(seckill);
				System.out.println(result);

				seckill = redisDao.getSeckill(id);

				System.out.println(seckill);
			}
		}

	}

}
