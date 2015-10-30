package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BidMapper;
import vo.Bid;

@Component
public class BidDao
{
	private BidMapper mapper;
	
	@Autowired
	public BidDao(SqlSessionTemplate sessionTemplate)
	{
		mapper = sessionTemplate.getMapper(BidMapper.class);
	}
	
	public int insert(Bid bid)
	{
		return mapper.insertBid(bid);
	}
	
	public Bid select(int bidNo)
	{
		return mapper.selectBid(bidNo);
	}
	
	public List<Bid> selectList(int auctionNo)
	{
		return mapper.selectBidList(auctionNo);
	}
	
	public Bid selectNewest(int auctionNo)
	{
		return mapper.selectNewestBid(auctionNo);
	}
	
	public List<Bid> selectNewest10(int auctionNo)
	{
		return mapper.selectNewest10Bid(auctionNo);
	}
}
