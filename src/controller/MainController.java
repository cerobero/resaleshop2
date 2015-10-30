package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.CommentService;
import service.FaultyService;
import service.IndexService;
import service.insertService;
import vo.Article;
import vo.ArticlePage;
import vo.Click;
import vo.Comment;
import vo.Faulty;

@Controller
public class MainController {
	private IndexService service;
	private FaultyService fservice;
	private CommentService cservice;
	private insertService i_service;

	@Autowired
	public void setService(IndexService service) {
		this.service = service;
	}

	@Autowired
	public void setCservice(CommentService cservice) {
		this.cservice = cservice;
	}

	@Autowired
	public void setFservice(FaultyService fservice) {
		this.fservice = fservice;
	}
	@Autowired
	public void setI_service(insertService i_service) {
		this.i_service = i_service;
	}


	@RequestMapping("index.do")
	public ModelAndView MainAllList(){
		int teenArticleNo = i_service.selectTeenMostClick();
		int twentyArticleNo = i_service.selectTwentyMostClick();
		int thirtyArticleNo = i_service.selectThirtyMostClick();
		ArticlePage allNewPage=service.getMainArticlePage();
		Article readTeenArticle=service.readArticle(teenArticleNo);
		Article readTwentyArticle=service.readArticle(twentyArticleNo);
		Article readThirtyArticle=service.readArticle(thirtyArticleNo);

		ArticlePage hotNewPage=service.getMainHotArticlePage();
		ArticlePage premiumNewPage=service.getMainPremiumArticlePage();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("allNewPage",allNewPage);
		mv.addObject("hotNewPage",hotNewPage);
		mv.addObject("premiumNewPage",premiumNewPage);
		mv.addObject("readTeenArticle", readTeenArticle);
		mv.addObject("readTwentyArticle", readTwentyArticle);
		mv.addObject("readThirtyArticle", readThirtyArticle);
		return mv;
	}

	@RequestMapping("read.do")
	public ModelAndView selectView(HttpSession session,int articleNo){
		Click click = new Click();
		click.setUserAge((int)session.getAttribute("age"));
		click.setArticleNo(articleNo);
		i_service.insertMostClick(click);
		Article readArticle=service.readArticle(articleNo);
		List<Comment> commentList=cservice.commentListView(articleNo);
		List<Faulty> faultyList=fservice.listFaulty(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("read");
		mv.addObject("readArticle", readArticle);
		mv.addObject("commentList", commentList);
		mv.addObject("faultyList",faultyList);
		return mv;
	}


}
