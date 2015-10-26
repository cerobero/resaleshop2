package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.IndexService;
import vo.Article;
import vo.ArticlePage;

@Controller
public class MainController {
	private IndexService service;
	
	@Autowired
	public void setService(IndexService service) {
		this.service = service;
	}
	
	@RequestMapping("/index.do")
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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("read");
		mv.addObject("readArticle", readArticle);
		return mv;
	}
	
	
}
