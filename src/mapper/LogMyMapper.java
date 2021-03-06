package mapper;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import vo.Article;
import vo.JointPurchase;
import vo.User;

public interface LogMyMapper {
	public User selectUser(User user);
	public List<Article> itemStatus(String userId);
	public int deleteArticle(int articleNo);
	public int soldOut(int articleNo);
	public int writeUser(String userId);
	public List<JointPurchase> winnerList();
}
