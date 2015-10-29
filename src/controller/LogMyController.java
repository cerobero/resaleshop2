package controller;

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
		int ck = service.isLogin(user);
		if (ck == 1) {
			session.setAttribute("id", user.getUserId());
			session.setAttribute("pw", user.getUserPw());
			session.setAttribute("age", user.getUserAge());
			mv = new ModelAndView("index");
		} else if (ck == 0) {
			mv = new ModelAndView("err", "errMsg", "占쏙옙橘占싫� 占쌉력울옙占쏙옙");
		} else {
			mv = new ModelAndView("err", "errMsg", "ID 占쌉력울옙占쏙옙");
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
			mv = new ModelAndView("login", "errMsg", "占싸깍옙占쏙옙 占쏙옙 占싱울옙帽占쏙옙求占�.");
		}
		return mv;
	}

	@RequestMapping("mypage.do")
	public ModelAndView myPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userId = (String) session.getAttribute("id");
		List<Article> articleList = service.myPage(userId);
//		for(Article a: articleList){
//			System.out.println(a);
//		}
		mv.addObject(articleList);
		mv.setViewName("mypage");
		return mv;
	}

	@RequestMapping("gongu.do")
	public ModelAndView gongu(HttpSession session) {
		ModelAndView mv = new ModelAndView();
//		String userId = (String) session.getAttribute("id");
//		List<Article> gonguList = service.myPage(userId);
//		mv.addObject(gonguList);
		mv.setViewName("gongu");
		return mv;
	}

	@RequestMapping("soldout.do")
	public String soldOut(int articleNo) {
//		int articleNo = article.getArticleNo();
		service.soldout(articleNo);
		return "mypage";
	}

	@RequestMapping("delete.do")
	public String delete(Article article) {
		int articleNo = article.getArticleNo();
		service.delArticle(articleNo);
		return "mypage";
	}
}
