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
import vo.JointPurchase;
import vo.User;

@Component
public class LogMyService {
	private LogMyDao dao;

	@Autowired
	public void setDao(LogMyDao dao) {
		this.dao = dao;
	}

	public User isLogin(User user) {

		User lgUser = dao.getUser(user);
		return lgUser;
	}
	
	public List<Article> myPage(String userId) {
		return dao.itemStatus(userId);
	}

	public void soldout(int articleNo) {
		try{
			dao.soldOut(articleNo);
		}catch(Exception e){
		}
	}
		
	public void delArticle(int articleNo){
		try{
			dao.deleteArticle(articleNo);
		}catch(Exception e){
		}
	}

	public int writeUser(String userId) {
		try {
			if (dao.writeUser(userId) > 0) {
				return 1;
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public List<JointPurchase> winnerList() {
		return dao.winnerList();
	}
}