package mapper;

import java.util.List;
import java.util.Map;

import vo.Article;

public interface ArticleMapper
{
	public int insertArticle(Article article);
	public int updateArticle(Article article);
	public int deleteArticle(int articleNo);
	public Article selectArticle(int articleNo);
	public List<Article> selectArticleListAll(Map<String, Object> map);
	public List<Article> selectArticleListCategory(Map<String, Object> map);
	public List<Article> selectArticleListHot(Map<String, Object> map);
	public List<Article> selectArticleListPremium(Map<String, Object> map);
	public int selectArticleCountAll(Map<String, Object> map);
	public int selectArticleCountCategory(Map<String, Object> map);
	public int selectArticleCountHot(Map<String, Object> map);
	public int selectArticleCountPremium(Map<String, Object> map);
	public int articleCountAll();
	public int articleConuntHot();
	public int articleCountPremium();
}
