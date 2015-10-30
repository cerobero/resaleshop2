package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.ArticleMapper;
import vo.Article;

@Component
public class ArticleDao
{
	private ArticleMapper mapper;
	
	@Autowired
	public ArticleDao(SqlSessionTemplate sessionTemplate)
	{
		mapper = sessionTemplate.getMapper(ArticleMapper.class);
	}
	
	public int insert(Article article)
	{
		return mapper.insertArticle(article);
	}
	
	public int update(Article article)
	{
		return mapper.updateArticle(article);
	}
	
	public int updateWithOutPhoto(Article article)
	{
		return mapper.updateArticleWithOutPhoto(article);
	}
	
	public int delete(int articleNo)
	{
		return mapper.deleteArticle(articleNo);
	}
	
	public Article select(int articleNo)
	{
		return mapper.selectArticle(articleNo);
	}
	
	public List<Article> selectListAll(String search, int startIndex, int numOfIndex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		
		return mapper.selectArticleListAll(map); 
	}
	
	public List<Article> selectListCategory(String search, int categoryId, int startIndex, int numOfIndex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("categoryId", categoryId);
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		
		return mapper.selectArticleListCategory(map); 
	}
	
	public List<Article> selectListHot(String search, int startIndex, int numOfIndex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		
		return mapper.selectArticleListHot(map); 
	}
	
	public List<Article> selectListPremium(String search, int startIndex, int numOfIndex)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		
		return mapper.selectArticleListPremium(map); 
	}
	
	public int selectCountAll(String search)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		
		return mapper.selectArticleCountAll(map);
	}
	
	public int selectCountCategory(String search, int categoryId)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		map.put("categoryId", categoryId);
		
		return mapper.selectArticleCountCategory(map);
	}
	
	public int selectCountHot(String search)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		
		return mapper.selectArticleCountHot(map);
	}
	
	public int selectCountPremium(String search)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("search", String.format("%%%s%%", search));
		
		return mapper.selectArticleCountPremium(map);
	}
	
	public List<Article> selectAllMainArticle(int startIndex, int numOfIndex){
		Map<String,Integer> map=new HashMap<>();
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		return mapper.selectMainArticleListAll(map);
	}
	
	public List<Article> selectHotMainArticle(int startIndex, int numOfIndex){
		Map<String,Integer> map=new HashMap<>();
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		return mapper.selectMainArticleListHot(map);
	}
	
	public List<Article> selectPremiumMainArticle(int startIndex, int numOfIndex){
		Map<String,Integer> map=new HashMap<>();
		map.put("startIndex", startIndex);
		map.put("numOfIndex", numOfIndex);
		return mapper.selectMainArticleListPremium(map);
	}
	
	public int MainAllArticleCount(){
		return mapper.articleCountAll();
	}
	
	public int MainHotArticleCount(){
		return mapper.articleConuntHot();
	}
	
	public int MainPremiumArticleCount(){
		return mapper.articleCountPremium();
	}
}
