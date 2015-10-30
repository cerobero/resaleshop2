package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.ArticleService;
import vo.Article;

@Controller
public class ReadController {
	private ArticleService aservice;
	
	@Autowired
	public void setAservice(ArticleService aservice) {
		this.aservice = aservice;
	}
	
	
	@RequestMapping(value="a_update_form.do")
	public ModelAndView updateForm(int articleNo){
		System.out.println("업데이트 아티클넘버 : "+articleNo);
		Article original=aservice.readArticle(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("original",original);
		mv.setViewName("update_form");
		return mv;
	}
	
	@RequestMapping(value="a_update.do")
	public String update(Article article) {
		if(aservice.updateArticle(article)){
			return "update_success";
		}else{
			return "update_fail";
		}
	}
	
	@RequestMapping(value="a_delete.do")
	public String delete(int articleNo){
		if(aservice.deleteArticle(articleNo)){
			return "delete_success";
		}else{
			return "delete_fail";
		}
	}
	
	
	
}
