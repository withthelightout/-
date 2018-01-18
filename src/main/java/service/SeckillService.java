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
	 * ��ѯ������ɱ��¼
	 */
	List<Seckill>getSeckillList();
	
	/*
	 * ��ѯ������ɱ��¼
	 */
	Seckill getById(long seckillId);
	
	/*
	 * ��ɱ�����������ɱ��ַ
	 * �������ϵͳʱ�����ɱʱ��
	 */
	
	Exposer exportSeckillUrl(long seckillId);
	
	/*
	 * ִ����ɱ����
	 */
	SeckillExecution executeSeckill(long seckilled,long userPhone,String md5) 
			throws SeckillException,RepeatKillException,SeckillCloseException;
}
