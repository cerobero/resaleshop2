package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.RegisterService;
import vo.User;

@Controller
public class RegisterController
{
	private RegisterService service;
	
	@Autowired
	public void setService(RegisterService service)
	{
		this.service = service;
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView getRegister()
	{
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView("register");
		
		return modelAndView;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView postRegister(RedirectAttributes redirectAttributes, User user)
	{
		ModelAndView modelAndView = null;
		
		if (service.registerUser(user))
		{
			modelAndView = new ModelAndView("redirect:registerDone");
			redirectAttributes.addFlashAttribute("redirected", Boolean.TRUE);
		}
		else
		{
			modelAndView = new ModelAndView("redirect:register");
			redirectAttributes.addFlashAttribute("errMsg", "입력값이 올바르지 않습니다.");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("registerDone")
	public ModelAndView serviceRegisterDone(Model model)
	{
		ModelAndView modelAndView = null;
		
		boolean redirected = false;
		
		if (!model.asMap().isEmpty())
		{
			redirected = (boolean)model.asMap().get("redirected");
		}
		
		if (redirected)
		{
			modelAndView = new ModelAndView("register_done");
		}
		else
		{
			modelAndView = new ModelAndView("redirect:/");
		}
		
		return modelAndView;
	}
}
