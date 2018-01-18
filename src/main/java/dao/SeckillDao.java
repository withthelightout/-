package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Seckill;

public interface SeckillDao {

    //  ��С���
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	
	//����id��ѯ��ɱ����
	Seckill queryById(long seckillId);
	
	//����ƫ������ѯ��ɱϵͳ�б�
	List<Seckill> queryAll(@Param("offset")int offet,@Param("limit")int limit);
	
	
	
}
