package repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.InsertMapper;
import vo.Article;
import vo.Click;

@Component
public class IsertDao {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	public int insertMostClick(Click click){
		return session.getMapper(InsertMapper.class).insertMostClick(click);
	}


}
