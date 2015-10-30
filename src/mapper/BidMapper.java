package mapper;

import java.util.List;

import vo.Bid;

public interface BidMapper
{
	public int insertBid(Bid bid);
	public Bid selectBid(int bidNo);
	public List<Bid> selectBidList(int auctionNo);
	public Bid selectNewestBid(int auctionNo);
	public List<Bid> selectNewest10Bid(int auctionNo);
}
