package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.UserMapper;
import vo.User;

@Component
public class UserDao
{
	private UserMapper mapper;
	
	@Autowired
	public UserDao(SqlSessionTemplate sessionTemplate)
	{
		mapper = sessionTemplate.getMapper(UserMapper.class);
	}
	
	public int insert(User user) throws Exception
	{
		return mapper.insertUser(user);
	}
	
	public int update(User user)
	{
		return mapper.updateUser(user);
	}
	
	public int delete(int userNum)
	{
		return mapper.deleteUser(userNum);
	}
	
	public User select(int userNum)
	{
		return mapper.selectUser(userNum);
	}
	
	public List<User> selectList()
	{
		return mapper.selectUserList();
	}
}
