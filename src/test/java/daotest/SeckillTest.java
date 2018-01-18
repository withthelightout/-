package daotest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.SeckillDao;
import entity.Seckill;

//spring junit����
//˳������ioc
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ�λ��
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillTest {
	
	
	//ע��Daoʵ������
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
    public void testQueryById() {
		long id=1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
    /*
     * Seckill [seckillId=1000, name=1000Ԫ��ɱiphone6, 
     * number=100, startTime=Sun Nov 01 00:00:00 CST 2015, 
     * endTime=Mon Nov 02 00:00:00 CST 2015, 
     * createTime=Tue Aug 15 17:04:53 CST 2017]
     */
	
	@Test
	public void testReduceNumber() {
		Date killTime=new Date();
		int updateCount=seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount="+updateCount);
		
	}
	
	
	
    @Test
	public void testQueryAll()  {
    	List<Seckill>seckills=seckillDao.queryAll(0, 100);
		for(Seckill seckill:seckills){
			System.out.println(seckill);
		}
    }
	/*
	 * Seckill [seckillId=1000, name=1000Ԫ��ɱiphone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Tue Aug 15 17:04:53 CST 2017]
        Seckill [seckillId=1001, name=500Ԫ��ɱiphone6, number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Tue Aug 15 17:04:53 CST 2017]
        Seckill [seckillId=1002, name=300Ԫ��ɱiphone6, number=300, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Tue Aug 15 17:04:53 CST 2017]
         Seckill [seckillId=1003, name=200Ԫ��ɱiphone6, number=400, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Tue Aug 15 17:04:53 CST 2017]
	 */
	 
    
    @Test
    public void testGetConnection() {}
    
    

    @Test
    public void testComboPooledDataSource() {}
	 
}
