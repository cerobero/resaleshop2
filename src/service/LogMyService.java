package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import repository.LogMyDao;
import vo.Article;
import vo.User;

@Component
public class LogMyService {
	private LogMyDao dao;

	@Autowired
	public void setDao(LogMyDao dao) {
		this.dao = dao;
	}

	public int isLogin(User user) {

		if (dao.getUser(user) != null) {
			String gpw = dao.getUser(user).getUserPw();
			if (user.getUserPw().equals(gpw)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	public List<Article> myPage(String userId) {
		return dao.itemStatus(userId);
	}

	public void soldout(int articleNo) {
		dao.soldOut(articleNo);
	}

	public void delArticle(int articleNo) {
		dao.deleteArticle(articleNo);
	}
}
