package service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Component;

import repository.AuctionDao;
import repository.BidDao;
import vo.Auction;
import vo.AuctionPage;
import vo.Bid;

@Component
public class AuctionService
{
	public static final int MINIMUN_BID_PRICE = 1000;
	public static final int AUCTION_PER_PAGE = 8;
	public static final int VIEW_PAGES = 10;
	
	private AuctionDao auctionDao;
	private BidDao bidDao;
	
	@Autowired
	public void setAuctionDao(AuctionDao auctionDao)
	{
		this.auctionDao = auctionDao;
	}
	
	@Autowired
	public void setBidDao(BidDao bidDao)
	{
		this.bidDao = bidDao;
	}
	
	public AuctionPage getAuctionPage(String search, int selectPage)
	{
		List<Auction> list = null;
		int articleCount = 0;
		int pageArticleCount = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		int totalPage = 1;
		search = search == null ? "" : search;
		System.out.println("°Ë»ö : " + search);

		articleCount = auctionDao.selectCount(search);
		currentPage = selectPage > 0 ? selectPage : 1;
		totalPage = articleCount % AUCTION_PER_PAGE != 0 ? articleCount / AUCTION_PER_PAGE + 1
		        : articleCount / AUCTION_PER_PAGE;
		startPage = currentPage > VIEW_PAGES / 2 ? currentPage - VIEW_PAGES / 2 + 1 : 1;
		endPage = totalPage > startPage + VIEW_PAGES - 1 ? startPage + VIEW_PAGES - 1 : totalPage;
		startPage = totalPage == endPage && endPage > VIEW_PAGES
		        ? endPage - VIEW_PAGES + 1 : startPage;
		list = auctionDao.selectList(search, (currentPage - 1) * AUCTION_PER_PAGE, AUCTION_PER_PAGE);
		pageArticleCount = list.size();
		System.out.println("pageArticleCount = " + pageArticleCount);
		System.out.println(
		        String.format("startPage = %d, endPage = %d, currentPage = %d, selectPage = %d, totalPage = %d",
		                startPage, endPage, currentPage, selectPage, totalPage));

		return new AuctionPage(list, articleCount, pageArticleCount, currentPage, startPage, endPage);
	}

	public Bid getNewestBid(int auctionNo)
	{
		return bidDao.selectNewest(auctionNo);
	}
	
	public List<Bid> getBidList(int auctionNo)
	{
		return bidDao.selectList(auctionNo);
	}
	
	public boolean biddingValidate(Bid bid)
	{
		boolean result = false;
		Auction auction = auctionDao.select(bid.getAuctionNo());
		Bid newestBid = getNewestBid(bid.getAuctionNo());
		
		if (auction.getSoldout() == 1)
		{
			return result;
		}
		
		if (bid.getBidPrice() % 100 != 0)
		{
			return result;
		}

		if (newestBid == null)
		{
			if (bid.getBidPrice() >= auction.getStartPrice() + MINIMUN_BID_PRICE)
			{
				result = true;
			}
		}
		else
		{
			if (bid.getBidPrice() >= newestBid.getBidPrice() + MINIMUN_BID_PRICE)
			{
				result = true;
			}
		}
		
		return result;
	}
	
	public boolean bidding(Bid bid)
	{
		boolean result = false;
		
		if (biddingValidate(bid))
		{
			if (bidDao.insert(bid) > 0)
			{
				result = true;
			}
		}
		
		return result;
	}
	
	public Map<String, Object> readAuction(int auctionNo)
	{
		Map<String, Object> map = new HashMap<>();

		auctionDao.increseReadCount(auctionNo);

		map.put("auction", auctionDao.select(auctionNo));
		map.put("newestBid", bidDao.selectNewest(auctionNo));
//		map.put("bidList", bidDao.selectNewest10(auctionNo));
		map.put("bidList", bidDao.selectList(auctionNo));
		map.put("minimunBidPrice", MINIMUN_BID_PRICE);
		
		return map;
	}
	
	public void checkExpiredAuction()
	{
		List<Auction> list = auctionDao.selectValidList();
		
		for (Auction auction: list)
		{
			if (auction.getEndDate().compareTo(new Date()) <= 0)
			{
				auctionDao.updateExpired(auction.getAuctionNo());
			}
		}
	}
	
	public boolean writeAuction(Auction auction)
	{
		boolean result = false;
		
		if (auctionDao.insert(auction) > 0)
		{
			result = true;
		}
		
		return result;
	}
}
