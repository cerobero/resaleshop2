package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ArticleDao;
import vo.Article;
import vo.ArticlePage;

@Component
public class ArticleService
{
	private ArticleDao dao;
	public static final int ARTICLE_PER_PAGE = 8;
	public static final int VIEW_PAGES = 10;
	
	@Autowired
	public void setDao(ArticleDao dao)
	{
		this.dao = dao;
	}
	
	public ArticlePage getArticlePage(String search, int categoryId, int selectPage)
	{
		List<Article> articleList = null;
		int articleCount = 0;
		int pageArticleCount = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		int totalPage = 1;
		search = search == null ? "" : search;
		System.out.println("°Ë»ö : " + search);

		articleCount = categoryId == 0 ? dao.selectCountAll(search)
		        : dao.selectCountCategory(search, categoryId);
		currentPage = selectPage > 0 ? selectPage : 1;
		totalPage = articleCount % ARTICLE_PER_PAGE != 0 ? articleCount / ARTICLE_PER_PAGE + 1
		        : articleCount / ARTICLE_PER_PAGE;
		startPage = currentPage > VIEW_PAGES / 2 ? currentPage - VIEW_PAGES / 2 + 1 : 1;
		endPage = totalPage > startPage + VIEW_PAGES - 1 ? startPage + VIEW_PAGES - 1 : totalPage;
		startPage = totalPage == endPage && endPage > ARTICLE_PER_PAGE && startPage > ARTICLE_PER_PAGE
		        ? endPage - ARTICLE_PER_PAGE + 1 : startPage;
		articleList = categoryId == 0
		        ? dao.selectListAll(search, (currentPage - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE)
		        : dao.selectListCategory(search, categoryId, (currentPage - 1) * ARTICLE_PER_PAGE,
		                ARTICLE_PER_PAGE);
		pageArticleCount = articleList.size();
		System.out.println("pageArticleCount = " + pageArticleCount);
		System.out.println(
		        String.format("startPage = %d, endPage = %d, currentPage = %d, selectPage = %d, totalPage = %d",
		                startPage, endPage, currentPage, selectPage, totalPage));

		return new ArticlePage(articleList, articleCount, pageArticleCount, currentPage, startPage, endPage);
	}
	
	public ArticlePage getArticlePageHot(String search, int selectPage)
	{
		List<Article> articleList = null;
		int articleCount = 0;
		int pageArticleCount = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		int totalPage = 1;
		search = search == null ? "" : search;

		articleCount = dao.selectCountHot(search);
		currentPage = selectPage > 0 ? selectPage : 1;
		totalPage = articleCount % ARTICLE_PER_PAGE != 0 ? articleCount / ARTICLE_PER_PAGE + 1
		        : articleCount / ARTICLE_PER_PAGE;
		startPage = currentPage > VIEW_PAGES / 2 ? currentPage - VIEW_PAGES / 2 + 1 : 1;
		endPage = totalPage > startPage + VIEW_PAGES - 1 ? startPage + VIEW_PAGES - 1 : totalPage;
		startPage = totalPage == endPage && endPage > ARTICLE_PER_PAGE && startPage > ARTICLE_PER_PAGE
		        ? endPage - ARTICLE_PER_PAGE + 1 : startPage;
		articleList = dao.selectListHot(search, (currentPage - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE);
		pageArticleCount = articleList.size();

		return new ArticlePage(articleList, articleCount, pageArticleCount, currentPage, startPage, endPage);
	}

	public ArticlePage getArticlePagePremium(String search, int selectPage)
	{
		List<Article> articleList = null;
		int articleCount = 0;
		int pageArticleCount = 0;
		int currentPage = 1;
		int startPage = 1;
		int endPage = 1;
		int totalPage = 1;
		search = search == null ? "" : search;

		articleCount = dao.selectCountPremium(search);
		currentPage = selectPage > 0 ? selectPage : 1;
		totalPage = articleCount % ARTICLE_PER_PAGE != 0 ? articleCount / ARTICLE_PER_PAGE + 1
		        : articleCount / ARTICLE_PER_PAGE;
		startPage = currentPage > VIEW_PAGES / 2 ? currentPage - VIEW_PAGES / 2 + 1 : 1;
		endPage = totalPage > startPage + VIEW_PAGES - 1 ? startPage + VIEW_PAGES - 1 : totalPage;
		startPage = totalPage == endPage && endPage > ARTICLE_PER_PAGE && startPage > ARTICLE_PER_PAGE
		        ? endPage - ARTICLE_PER_PAGE + 1 : startPage;
		articleList = dao.selectListPremium(search, (currentPage - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE);
		pageArticleCount = articleList.size();

		return new ArticlePage(articleList, articleCount, pageArticleCount, currentPage, startPage, endPage);
	}
	

}
