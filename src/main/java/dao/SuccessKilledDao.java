package dao;

import org.apache.ibatis.annotations.Param;

import entity.SuccessKilled;

public interface SuccessKilledDao {

	
	
	//���빺����ϸ ���ظ�����
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	//����id��ѯsuccesskilled��Я����ɱ��Ʒ����ʵ��
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
