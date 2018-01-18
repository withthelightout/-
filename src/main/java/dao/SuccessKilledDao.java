package dao;

import org.apache.ibatis.annotations.Param;

import entity.SuccessKilled;

public interface SuccessKilledDao {

	
	
	//插入购买明细 可重复过滤
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	//根据id查询successkilled并携带秒杀产品对象实体
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
