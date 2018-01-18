package daotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.SuccessKilledDao;
import entity.SuccessKilled;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillsuccessTest {

	 @Autowired
	 private SuccessKilledDao successKillDao;
	
	 @Test
	 public void insertSuccessKilled() throws Exception {
      long id=1001L;
      long phone =13502181181L;
      int insertCount = successKillDao.insertSuccessKilled(id, phone);
      System.out.println("insertCount="+insertCount);
	       
	 }

	 @Test
	 public void queryByIdWithSeckill() throws Exception {
	   long id=1001L;
	   long phone=13502181181L;
	   SuccessKilled successKilled=successKillDao.queryByIdWithSeckill(id, phone);
	   System.out.println(successKilled);
	   System.out.println(successKilled.getSeckillId());

	 }
	
	
	
}
