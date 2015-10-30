package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.AuctionMapper;
import vo.Auction;

@Component
public class AuctionDao
{
	private AuctionMapper mapper;
	
	@Autowired
	public AuctionDao(SqlSessionTemplate sessionTemplate)
	{
		mapper = sessionTemplate.getMapper(AuctionMapper.class);
	}
	
	public int insert(Auction auction)
	{
		return mapper.insertAuction(auction);
	}
	
	public int update(Auction auction)
	{
		return mapper.updateAuction(auction);
	}
	
	public int delete(int auctionNo)
	{
		return mapper.deleteAuction(auctionNo);
	}
	
	public Auction select(int auctionNo)
	{
		return mapper.selectAuction(auctionNo);
	}
	
	public int selectCount(String search)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		
		return mapper.selectAuctionCount(map);
	}
	
	public List<Auction> selectList(String search, int startIndex, int numOfIndex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		
		return mapper.selectAuctionList(map);
	}
	
	public int increseReadCount(int auctionNo)
	{
		return mapper.updateAuctionReadCount(auctionNo);
	}
	
	public List<Auction> selectValidList()
	{
		return mapper.selectValidAuctionList();
	}
	
	public int updateExpired(int auctionNo)
	{
		return mapper.updateAuctionExpired(auctionNo);
	}
}
