package service;

import java.util.List;

import dto.Exposer;
import dto.SeckillExecution;
import entity.Seckill;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import exception.SeckillException;

public interface SeckillService {

	/*
	 * 查询所有秒杀记录
	 */
	List<Seckill>getSeckillList();
	
	/*
	 * 查询单个秒杀记录
	 */
	Seckill getById(long seckillId);
	
	/*
	 * 秒杀开启是输出秒杀地址
	 * 否者输出系统时间和秒杀时间
	 */
	
	Exposer exportSeckillUrl(long seckillId);
	
	/*
	 * 执行秒杀操作
	 */
	SeckillExecution executeSeckill(long seckilled,long userPhone,String md5) 
			throws SeckillException,RepeatKillException,SeckillCloseException;
}
