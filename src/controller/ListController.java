package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ArticleService;

@Controller
public class ListController
{
	private ArticleService service;
	
	@Autowired
	public void setService(ArticleService service)
	{
		this.service = service;
	}
	
	@RequestMapping("list")
	public ModelAndView serviceList(@RequestParam(defaultValue="") String view,
									@RequestParam(defaultValue="") String search,
									@RequestParam(defaultValue="1") int categoryId,
									@RequestParam(defaultValue="1") int page)
	{
		ModelAndView modelAndView = new ModelAndView("category");
		
		if (view.equals(""))
		{
			modelAndView.addObject("articlePage", service.getArticlePage(search, categoryId, page));
		}
		else if (view.equals("hot"))
		{
			modelAndView.addObject("articlePage", service.getArticlePageHot(search, page));
		}
		else
		{
			modelAndView.addObject("articlePage", service.getArticlePagePremium(search, page));
		}
		
		return modelAndView;
	}
}
