package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.LogMyMapper;
import vo.Article;
import vo.User;

@Component
public class LogMyDao {
	private SqlSessionTemplate session;
	
	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	public User getUser(User user){
		LogMyMapper mapper = session.getMapper(LogMyMapper.class);
		return mapper.selectUser(user);
	}

	public List<Article> itemStatus(String userId){
		return session.getMapper(LogMyMapper.class).itemStatus(userId);
	}
	
	public int deleteArticle(int articleNo){
		return session.getMapper(LogMyMapper.class).deleteArticle(articleNo);
		
	}
	public int soldOut(int articleNo) {
		return session.getMapper(LogMyMapper.class).soldOut(articleNo);
	}

	public int writeUser(String userId) {
		System.out.println(userId);
		LogMyMapper mapper = session.getMapper(LogMyMapper.class);
		return mapper.writeUser(userId);
	}	
}
