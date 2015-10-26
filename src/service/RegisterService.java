package service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.UserDao;
import vo.User;

@Component
public class RegisterService
{
	private UserDao dao;
	
	@Autowired
	public void setDao(UserDao dao)
	{
		this.dao = dao;
	}
	
	public boolean checkUserValidation(User user)
	{
		if (!Pattern.matches("^[A-Za-z]{1}[A-Za-z0-9]{3,11}$", user.getUserId()))
			return false;

		if (!Pattern.matches("^[A-Za-z0-9]{4,20}$", user.getUserPw()))
			return false;

		if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]{3,4}$", user.getUserName()))
			return false;

		if (!Pattern.matches("^01(?:0|1[6-9])\\-(?:\\d{3}|\\d{4})\\-\\d{4}$", user.getUserPhone()))
			return false;

		if (!Pattern.matches("^[a-z0-9_+.-]+@([a-z0-9-]+\\.)+[a-z0-9]{2,4}$", user.getUserEmail()))
			return false;
		
		if (!Pattern.matches("^[0-9]{1,2}$", Integer.toString(user.getUserAge())))
			return false;

		return true;
	}
	
	public boolean registerUser(User user)
	{
		boolean result = false;
		
		if (checkUserValidation(user))
		{
			try
			{
				if (dao.insert(user) > 0)
				{
					result = true;
				}
			}
			catch (Exception e)
			{
				/*
				 * keep result false
				 */
			}
		}
		
		return result;
	}
}
