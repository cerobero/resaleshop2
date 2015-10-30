package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.CommentDao;
import vo.Comment;

@Component
public class CommentService {
	private CommentDao dao;

	@Autowired
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}

	public boolean writeComment(Comment comment) {
		Date commentDate = new Date();
		comment.setCommentDate(commentDate);
		System.out.println("test commentService");
		if (dao.commentWrite(comment) > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public List<Comment> commentListView(int articleNo){
		return dao.commentListView(articleNo);
	}
	
	public boolean reWriteComment(int commentNo,String commentContent){
		if(dao.commentReWrite(commentNo, commentContent)>0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean deleteComment(int commentNo){
		if(dao.commentDelete(commentNo)>0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int commentCount(int articleNo){
		return dao.commnetCount(articleNo);
	}
	
	public Comment readComment(int commentNo){
		return dao.commentRead(commentNo);
	}
}
