package mapper;

import java.util.List;
import java.util.Map;

import vo.Auction;

public interface AuctionMapper
{
	public int insertAuction(Auction auction);
	public int updateAuction(Auction auction);
	public int deleteAuction(int auctionNo);
	public Auction selectAuction(int auctionNo);
	public int selectAuctionCount(Map<String, Object> map);
	public List<Auction> selectAuctionList(Map<String, Object> map);
	public int updateAuctionReadCount(int auctionNo);
	public List<Auction> selectValidAuctionList();
	public int updateAuctionExpired(int auctionNo);
}
