package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ArticleDao;
import vo.Article;
import vo.ArticlePage;

@Component
public class IndexService {
	private ArticleDao dao;

	@Autowired
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	public ArticlePage getMainArticlePage() {
		final int CPP = 4;

		int articleTotalCount = dao.MainAllArticleCount();

		if (articleTotalCount == 0) {
			return new ArticlePage();
		}

		int startIndex = articleTotalCount - 4;

		if (startIndex <= 0)
			startIndex = 1;

		List<Article> MainAllArticleList = dao.selectAllMainArticle(startIndex, CPP);

		int totalPageEndPage = articleTotalCount / CPP;

		if (articleTotalCount % CPP != 0) {
			totalPageEndPage++;
		}

		return new ArticlePage(MainAllArticleList, totalPageEndPage, totalPageEndPage, totalPageEndPage,
				totalPageEndPage);

	}
	
	public ArticlePage getMainHotArticlePage() {
		final int CPP = 4;

		int articleTotalCount = dao.MainAllArticleCount();

		if (articleTotalCount == 0) {
			return new ArticlePage();
		}

		int startIndex = articleTotalCount - 4;

		if (startIndex <= 0)
			startIndex = 1;

		List<Article> MainHotArticleList = dao.selectHotMainArticle(startIndex, CPP);

		int totalPageEndPage = articleTotalCount / CPP;

		if (articleTotalCount % CPP != 0) {
			totalPageEndPage++;
		}

		return new ArticlePage(MainHotArticleList, totalPageEndPage, totalPageEndPage, totalPageEndPage,
				totalPageEndPage);

	}

	public ArticlePage getMainPremiumArticlePage() {
		final int CPP = 4;

		int articleTotalCount = dao.MainAllArticleCount();

		if (articleTotalCount == 0) {
			return new ArticlePage();
		}

		int startIndex = articleTotalCount - 4;

		if (startIndex <= 0)
			startIndex = 1;

		List<Article> MainPremiumArticleList = dao.selectPremiumMainArticle(startIndex, CPP);

		int totalPageEndPage = articleTotalCount / CPP;

		if (articleTotalCount % CPP != 0) {
			totalPageEndPage++;
		}

		return new ArticlePage(MainPremiumArticleList, totalPageEndPage, totalPageEndPage, totalPageEndPage,
				totalPageEndPage);

	}
	
	public Article readArticle(int articleNo){
		Article selectArticle=dao.select(articleNo);
		return selectArticle;
	}
	
}
