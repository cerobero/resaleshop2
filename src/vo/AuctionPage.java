package vo;

import java.util.List;

public class AuctionPage
{
	private List<Auction> list;
	private int articleCount;
	private int pageArticleCount;
	private int currentPage;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;

	public AuctionPage()
	{
		// TODO Auto-generated constructor stub
	}
	
	public AuctionPage(List<Auction> list, int requestPage, int totalPageCount, int startPage, int endPage) {
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public AuctionPage(List<Auction> list, int articleCount, int pageArticleCount, int currentPage, int startPage, int endPage)
	{
		super();
		this.list = list;
		this.articleCount = articleCount;
		this.pageArticleCount = pageArticleCount;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<Auction> getList()
	{
		return list;
	}

	public void setList(List<Auction> list)
	{
		this.list = list;
	}

	public int getArticleCount()
	{
		return articleCount;
	}

	public void setArticleCount(int articleCount)
	{
		this.articleCount = articleCount;
	}

	public int getPageArticleCount()
	{
		return pageArticleCount;
	}

	public void setPageArticleCount(int pageArticleCount)
	{
		this.pageArticleCount = pageArticleCount;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getRequestPage()
	{
		return requestPage;
	}

	public void setRequestPage(int requestPage)
	{
		this.requestPage = requestPage;
	}

	public int getTotalPageCount()
	{
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public int getEndPage()
	{
		return endPage;
	}

	public void setEndPage(int endPage)
	{
		this.endPage = endPage;
	}

}
