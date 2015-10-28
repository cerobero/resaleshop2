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
import vo.GoodsVo;
import vo.User;

@Controller
public class LogMyController {
	private LogMyService service;

	@Autowired
	public void setService(LogMyService service) {
		this.service = service;
	}

	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/loginCheck")
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mv = null;
		int ck = service.isLogin(user);
		if (ck == 1) {
			session.setAttribute("id", user.getUserId());
			session.setAttribute("pw", user.getUserPw());
			session.setAttribute("age", user.getUserAge());
			mv = new ModelAndView("index");
		} else if (ck == 0) {
			mv = new ModelAndView("err", "errMsg", "비밀번호 입력오류");
		} else {
			mv = new ModelAndView("err", "errMsg", "ID 입력오류");
		}
		return mv;
	}

	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = null;
		String userId = (String) session.getAttribute("id");
		if (userId != null) {
			mv = new ModelAndView("login");
			session.invalidate();
		} else {
			mv = new ModelAndView("login", "error_message", "로그인 후 이용바랍니다.");
		}
		return mv;
	}

	@RequestMapping("mypage")
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

	@RequestMapping("soldout")
	public String soldOut(int articleNo) {
//		int articleNo = article.getArticleNo();
		service.soldout(articleNo);
		return "mypage";
	}

	@RequestMapping("delete")
	public String delete(Article article) {
		int articleNo = article.getArticleNo();
		service.delArticle(articleNo);
		return "mypage";
	}
}
