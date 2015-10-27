package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.CommentMapper;
import vo.Comment;

@Component
public class CommentDao {
	private CommentMapper mapper;
	
	@Autowired
	public CommentDao(SqlSessionTemplate sessionTemplate){
		mapper=sessionTemplate.getMapper(CommentMapper.class);
	}
	
	public int commentWrite(Comment comment){
		return mapper.writeComment(comment);
	}
	
	public List<Comment> commentListView(int articleNo){
		return mapper.viewComments(articleNo);
	}
	
	public int commentReWrite(int commentNo,String commentContent){
		Map<String, Object> map = new HashMap<>();
		map.put("commentNo", commentNo);
		map.put("commentContent", commentContent);
		return mapper.reWriteComment(map);
	}
	
	public int commentDelete(int commentNo){
		return mapper.deleteComment(commentNo);
	}
	
	public int commnetCount(int articleNo){
		return mapper.commentCount(articleNo);
	}
	
	public Comment commentRead(int commentNo){
		return mapper.readComment(commentNo);
	}
}
