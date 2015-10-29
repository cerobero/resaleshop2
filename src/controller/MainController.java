package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.CommentService;
import service.FaultyService;
import service.IndexService;
import vo.Article;
import vo.ArticlePage;
import vo.Comment;
import vo.Faulty;

@Controller
public class MainController {
	private IndexService service;
	private FaultyService fservice;
	private CommentService cservice;
	
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
	

	
	@RequestMapping("index.do")
	public ModelAndView MainAllList(){
		ArticlePage allNewPage=service.getMainArticlePage();
		ArticlePage hotNewPage=service.getMainHotArticlePage();
		ArticlePage premiumNewPage=service.getMainPremiumArticlePage();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("allNewPage",allNewPage);
		mv.addObject("hotNewPage",hotNewPage);
		mv.addObject("premiumNewPage",premiumNewPage);
		return mv;
	}
	
	@RequestMapping("read.do")
	public ModelAndView selectView(int articleNo){
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
