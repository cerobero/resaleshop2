package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repository.LogMyDao;
import service.LogMyService;
import vo.Article;
import vo.JointPurchase;
import vo.User;

@Controller
public class LogMyController {
	private LogMyService service;

	@Autowired
	public void setService(LogMyService service) {
		this.service = service;
	}

	@RequestMapping("login.do")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("loginCheck.do")
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mv = null;
		User lgUser = service.isLogin(user);
		if (lgUser != null) {
			String gpw = lgUser.getUserPw();
			if (user.getUserPw().equals(gpw)) {
				session.setAttribute("id", lgUser.getUserId());
				session.setAttribute("pw", lgUser.getUserPw());
				session.setAttribute("age", lgUser.getUserAge());
				mv = new ModelAndView("index");
			} else {
				mv = new ModelAndView("err", "errMsg", "패스워드 입력 오류");
			}
		} else {
			mv = new ModelAndView("err", "errMsg", "ID 입력 오류");
		}
		return mv;
	}

	@RequestMapping(value = "logout.do")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = null;
		String userId = (String) session.getAttribute("id");
		if (userId != null) {
			mv = new ModelAndView("login");
			session.invalidate();
		} else {
			mv = new ModelAndView("login");
		}
		return mv;
	}

	@RequestMapping("mypage.do")
	public ModelAndView myPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userId = (String) session.getAttribute("id");
		List<Article> articleList = service.myPage(userId);
		mv.addObject("articleList", articleList);
		mv.setViewName("mypage");
		return mv;
	}

	@RequestMapping("gonguView.do")
	public String gonguView() {
		return "gonguView";
	}
	
	@RequestMapping("gongu.do")
 	public ModelAndView gongu(HttpSession session) {
 		ModelAndView mv =null;
		String userId = (String) session.getAttribute("id");
		if (userId == null) {
			mv = new ModelAndView("redirect: login.do");
		}else {
			int rs=service.writeUser(userId);
			if(rs==1){
			mv = new ModelAndView("win", "winMsg", "공동구매 신청되었습니다!!!!!");
			}else {
				mv=new ModelAndView("gonguView");
			}
		}
		return mv;
	}

	@RequestMapping("winner.do")
	public ModelAndView winnerList() {
		ModelAndView mv = new ModelAndView();
		List<JointPurchase> winnerList = service.winnerList();
		mv.addObject("winnerList", winnerList);
		System.out.println(winnerList);
		mv.setViewName("gonguView");
		return mv;
	}

	@RequestMapping("soldout.do")
	public String soldOut(int articleNo) {
		service.soldout(articleNo);
		return "redirect: mypage.do";
	}

	@RequestMapping("delete.do")
	public String delete(Article article) {
		int articleNo = article.getArticleNo();
		service.delArticle(articleNo);
		return "redirect: mypage.do";
	}
}
