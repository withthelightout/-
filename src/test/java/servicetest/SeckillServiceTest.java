package servicetest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dto.Exposer;
import dto.SeckillExecution;
import entity.Seckill;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import service.SeckillService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 private SeckillService seckillService;

	 @Test
	 public void getSeckillList() throws Exception {
		 List<Seckill>list=seckillService.getSeckillList();
		 logger.info("list={}",list);
	 }
	
	 @Test
	 public void getById() throws Exception {
		 long id = 1000;
		 Seckill seckill=seckillService.getById(id);
		 logger.info("seckill={}",seckill);
	 }
	  
	 @Test//完整逻辑代码测试，注意可重复执行
	 public void testSeckillLogic() throws Exception {
		 long id = 1000;
		 Exposer exposer=seckillService.exportSeckillUrl(id);
		 if(exposer.isExposed()){
			 logger.info("exposer={}",exposer);
			 long phone=1234565459L;
			 String md5=exposer.getMd5();
			 try{
				 SeckillExecution execution=seckillService.executeSeckill(id, phone, md5);
				 logger.info("result={}",execution);
			 }catch(RepeatKillException e){
				 logger.error(e.getMessage());
			 }catch(SeckillCloseException e){
				 logger.error(e.getMessage());
			 }
		 }else{
			 logger.warn("exposer={}",exposer);
		 }
		 
	 }
	//exposer=Exposer [exposed=true, md5=42ad09b4e862d06ffc53b0906785692e, seckillId=1000, now=0, start=0, end=0]
	

//	 @Test
//	 public void executeSeckill() throws Exception {
//		 long id=1000;
//		 long phone=1234563459L;
//		 String md5="42ad09b4e862d06ffc53b0906785692e";
//		 SeckillExecution execution=seckillService.executeSeckill(id, phone, md5);
//		 logger.info("result={}",execution);
//	 }
	 // [seckillId=1000, state=1, stateInfo=秒杀成功, successKilled=SuccessKilled 
	 //[seckillId=1000, userPhone=1234563459, state=0, createTime=Mon Aug 21 08:43:57 CST 2017]]

	 @Test
	 public void testweb(){
		 List<Seckill>list=seckillService.getSeckillList();
		 for(Seckill seckill:list){
			 System.out.println(seckill.getName());
		 }
	 }
	
}
