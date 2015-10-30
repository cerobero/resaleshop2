package vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Auction
{
	private int auctionNo;
	private String userId;
	private String title;
	private int startPrice;
	private int binPrice;
	private int readCount;
	private Date postingDate;
	private Date endDate;
	private String photo;
	private String content;
	private int soldout;

	public int getAuctionNo()
	{
		return auctionNo;
	}

	public void setAuctionNo(int auctionNo)
	{
		this.auctionNo = auctionNo;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getStartPrice()
	{
		return startPrice;
	}

	public void setStartPrice(int startPrice)
	{
		this.startPrice = startPrice;
	}

	public int getBinPrice()
	{
		return binPrice;
	}

	public void setBinPrice(int binPrice)
	{
		this.binPrice = binPrice;
	}

	public int getReadCount()
	{
		return readCount;
	}

	public void setReadCount(int readCount)
	{
		this.readCount = readCount;
	}

	public Date getPostingDate()
	{
		return postingDate;
	}

	public void setPostingDate(Date postingDate)
	{
		this.postingDate = postingDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getSoldout()
	{
		return soldout;
	}

	public void setSoldout(int soldout)
	{
		this.soldout = soldout;
	}

}
