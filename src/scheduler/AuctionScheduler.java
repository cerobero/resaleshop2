package scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import service.AuctionService;

@Component
public class AuctionScheduler
{
	private AuctionService service;
	
	@Autowired
	public void setService(AuctionService service)
	{
		this.service = service;
	}
	
	/*
	 * 5�ʿ� �ѹ��� �Ϸ���� ���� ��Ÿ� �˻�
	 * ����ð��� �Ϸ����� ��
	 * ���ǿ� �ش��ϴ� ��Ÿ� �����Ŵ (SOLDOUT=1)
	 */
	@Scheduled(fixedDelay=5000)
	public void expiredAuctionSchedule()
	{
		service.checkExpiredAuction();
	}
}