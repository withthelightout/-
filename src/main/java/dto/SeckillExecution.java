package dto;

import entity.SuccessKilled;
import enums.SeckillStatEnum;

public class SeckillExecution {
	
	private long seckillId;
	
	private int state;
	
	//����
	private String stateInfo;
	
	//��ɱ�ɹ�����
	private SuccessKilled successKilled;
	
	
	
	
	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successKilled=" + successKilled + "]";
	}

	//ʧ�������
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
		super();
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getInfo();
	}

	//�ɹ������
	public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getInfo();
		this.successKilled = successKilled;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	
	
	
	

}
