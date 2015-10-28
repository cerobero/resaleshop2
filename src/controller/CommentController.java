package controller;

import java.util.List;

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

	@RequestMapping("/comment_view.do")
	public ModelAndView ArticleCommnetView(int articleNo) {
		List<Comment> commentList = service.commentListView(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("comment_view");
		mv.addObject("commentList", commentList);
		return mv;
	}

/*	@RequestMapping("/c_write_form.do")
	public String CommentWriteForm() {
		return "c_write_form";
	}*/

	@RequestMapping(value = "/c_write.do", method = RequestMethod.POST)
	public String CommentWrite(Comment comment) {
		if (service.writeComment(comment)) {
			return "c_write_success";
		} else {
			return "c_write_fail";
		}
	}

	@RequestMapping(value = "/c_rewrite_form.do")
	public ModelAndView reWriteCommentForm(int commentNo) {
		Comment originalComment = service.readComment(commentNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("c_rewrite_form");
		mv.addObject("originalComment", originalComment);
		return mv;
	}

	@RequestMapping(value = "/c_rewrite.do")
	public String reWriteComment(int commentNo, String commentContent) {
		if (service.reWriteComment(commentNo, commentContent)) {
			return "c_rewrite_scuccess";
		} else {
			return "c_rewrite_fail";
		}
	}

	@RequestMapping(value="/c_delete.do")
	public String deleteComment(int commentNo) {
		if (service.deleteComment(commentNo)) {
			return "c_delete_success";
		} else {
			return "c_delete_fail";
		}
	}

}
