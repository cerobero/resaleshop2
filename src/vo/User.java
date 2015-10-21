package vo;

public class User
{
	private int userNum; /* user_num */
	private String userId; /* user_id */
	private String userPw; /* user_pw */
	private String userName; /* user_name */
	private String userPhone; /* user_phone */
	private String userEmail; /* user_email */
	private int userAge; /* user_age */

	public User()
	{
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userPw, String userName, String userPhone, String userEmail, int userAge)
	{
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAge = userAge;
	}

	public User(int userNum, String userId, String userPw, String userName, String userPhone, String userEmail,
	        int userAge)
	{
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userAge = userAge;
	}

	public int getUserNum()
	{
		return userNum;
	}

	public void setUserNum(int userNum)
	{
		this.userNum = userNum;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public int getUserAge()
	{
		return userAge;
	}

	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
}
