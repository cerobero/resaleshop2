package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ArticleDao;

import vo.Article;


@Component
public class imdService {
	@Autowired
	private ArticleDao dao;

	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	public boolean insertArticle(Article article) {
		if (dao.insert(article)>0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyArticle(Article article) {
		if (dao.update(article)>0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteArticle(int articleNo) {
		if (dao.delete(articleNo)>0) {
			return true;
		} else {
			return false;
		}
	}
}
