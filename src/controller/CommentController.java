package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CommentService;
import vo.Comment;

@Controller
public class CommentController {

	private CommentService service;

	@Autowired
	public void setService(CommentService service) {
		this.service = service;
	}

/*	@RequestMapping("comment_view")
	public ModelAndView ArticleCommnetView(int articleNo) {
		List<Comment> commentList = service.commentListView(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("comment_view");
		mv.addObject("commentList", commentList);
		return mv;
	}*/

/*	@RequestMapping("/c_write_form.do")
	public String CommentWriteForm() {
		return "c_write_form";
	}*/

	@RequestMapping(value = "c_write.do", method = RequestMethod.POST)
	public String CommentWrite(Comment comment) {
		System.out.println("ÄÚ¸àÆ®.ÄÚ¸àÆ®ÄÁÅÙÆ® : "+comment.getCommentContent());
		if (service.writeComment(comment)) {
			
			String result=null;
			result="redirect:read.do?articleNo="+comment.getArticleNo();
			return result;
		} else {
			return "redirect:error.do";
		}
	}

	@RequestMapping(value = "c_rewrite_form.do")
	public ModelAndView reWriteCommentForm(int commentNo) {
		Comment originalComment = service.readComment(commentNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("c_rewrite_form");
		mv.addObject("originalComment", originalComment);
		return mv;
	}

	@RequestMapping(value = "c_rewrite.do")
	public String reWriteComment(int commentNo, String commentContent) {
		if (service.reWriteComment(commentNo, commentContent)) {
			int articleNo=service.readComment(commentNo).getArticleNo();
			String result="redirect:read.do?articleNo="+articleNo;
			return result;
		} else {
			return "redirect:error.do";
		}
	}

	@RequestMapping(value="c_delete.do")
	public String deleteComment(int commentNo) {
		int articleNo=service.readComment(commentNo).getArticleNo();
		if (service.deleteComment(commentNo)) {
			return "redirect:read.do?articleNo="+articleNo;
		} else {
			return "redirect:error.do";
		}
	}

}
