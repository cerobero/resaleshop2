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
	 * 5초에 한번씩 완료되지 않은 경매를 검사
	 * 현재시간과 완료일을 비교
	 * 조건에 해당하는 경매를 종료시킴 (SOLDOUT=1)
	 */
	@Scheduled(fixedDelay=5000)
	public void expiredAuctionSchedule()
	{
		service.checkExpiredAuction();
	}
}