package mapper;

import java.util.List;

import vo.Comment;
import vo.User;

public interface UserMapper
{
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userNum);
	public User selectUser(int userNum);
	public List<User> selectUserList();
	
}