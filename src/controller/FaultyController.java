package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.FaultyService;
import vo.Faulty;

@Controller
public class FaultyController {
	private FaultyService service;

	@Autowired
	public void setService(FaultyService service) {
		this.service = service;
	}

	@RequestMapping("f_list")
	public ModelAndView ArticleFaultyList(int articleNo) {
		List<Faulty> faultylist = service.listFaulty(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("f_list");
		mv.addObject("faultylist", faultylist);
		return mv;
	}

	@RequestMapping(value = "write_form")
	public String FaultyWriteForm() {
		return "f_write_form";
	}

	@RequestMapping(value = "f_write", method = RequestMethod.POST)
	public String FaultyWrite(Faulty faulty, int accUserNum, int articleNo) {
		if (service.writeFaulty(faulty, accUserNum, articleNo)) {
			return "f_write_success";
		} else {
			return "f_write_fail";
		}
	}

	@RequestMapping(value = "f_rerwite_form")
	public ModelAndView reWriteFaultyForm(int faultyNo) {
		Faulty originalFaulty = service.readFaulty(faultyNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("originalFaulty", originalFaulty);
		mv.setViewName("f_rewrite_form");
		return mv;
	}

	@RequestMapping(value = "f_rewrite")
	public String reWriteFaulty(Faulty faulty) {
		if (service.rewriteFaulty(faulty)) {
			return "f_rewrite_success";
		} else {
			return "f_rewrite_fail";
		}

	}

/*	@RequestMapping("f_view.do")
	public ModelAndView articleFaultyView(int faultyNo) {
		Faulty articleFaulty = service.readFaulty(faultyNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("articleFaulty", articleFaulty);
		mv.setViewName("f_view");
		return mv;
	}*/

}
