package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import service.imdService;
import vo.Article;

@Controller
public class InsertController {
	ModelAndView mv = new ModelAndView();
	private imdService service;
	@Autowired
	public void setService(imdService service){
		this.service = service;
	}

	@RequestMapping("writeForm.do")
	public String goWriteForm(){


		return "write";
	}


	@RequestMapping(value="/writedone.do",method=RequestMethod.POST)
	public String goWrite(Article article,HttpSession session){
		article.setUserId((String)session.getAttribute("id"));
		article.setPostingDate(new Date());
		article.setFaultyCheck(0);
		System.out.println("1");
		System.out.println(article);
		System.out.println(article.getMyfile());
		if (article.getMyfile()!= null) {

			String folderPath = "/upload";
			File dir = new File(folderPath);
			System.out.println("2");
			if (dir.exists() == false){
				dir.mkdir(); }

			String filePath = folderPath + "/" + new Random().nextInt(1000000);
			File savedFile = new File(filePath);
			System.out.println("3");
			try {
//				System.out.println("4占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙");
//				System.out.println(article);
//				System.out.println(article.getMyfile());
				article.getMyfile().transferTo(savedFile);// 占쏙옙占싸듸옙 占쏙옙占쏙옙



				article.setPhoto(savedFile.getAbsolutePath());
				String result;
				if(service.insertArticle(article)){
//					System.out.println("占쏙옙占싸듸옙 占싹뤄옙占�.");
					result = "redirect:index.do";
				} else {
					result = "redirect:error.do";
				}
				return result;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:error.do";
		} else {
			return "redirect:error.do";
		}
	}

}
