package mapper;

import java.util.List;
import java.util.Map;

import vo.Comment;

public interface CommentMapper {
	public int writeComment(Comment comment);
	public List<Comment> viewComments(int articleNo);
	public int reWriteComment(Map<String, Object> map);
	public int deleteComment(int commentNo);
	public int commentCount(int articleNo);	
}
