package vo;

import java.util.Date;

public class Bid
{
	private int bidNo;
	private int auctionNo;
	private String bidder;
	private int bidPrice;
	private Date bidDate;
	
	public Bid()
	{
		// TODO Auto-generated constructor stub
	}

	public Bid(int bidNo, int auctionNo, String bidder, int bidPrice, Date bidDate)
	{
		super();
		this.bidNo = bidNo;
		this.auctionNo = auctionNo;
		this.bidder = bidder;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
	}

	public int getbidNo()
	{
		return bidNo;
	}

	public void setbidNo(int bidNo)
	{
		this.bidNo = bidNo;
	}

	public int getAuctionNo()
	{
		return auctionNo;
	}

	public void setAuctionNo(int auctionNo)
	{
		this.auctionNo = auctionNo;
	}

	public String getBidder()
	{
		return bidder;
	}

	public void setBidder(String bidder)
	{
		this.bidder = bidder;
	}

	public int getBidPrice()
	{
		return bidPrice;
	}

	public void setBidPrice(int bidPrice)
	{
		this.bidPrice = bidPrice;
	}

	public Date getBidDate()
	{
		return bidDate;
	}

	public void setBidDate(Date bidDate)
	{
		this.bidDate = bidDate;
	}

}
