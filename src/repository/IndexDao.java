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
public class IndexDao {
	private ArticleMapper mapper;
	
	@Autowired
	public IndexDao(SqlSessionTemplate sessionTemplate){
		mapper=sessionTemplate.getMapper(ArticleMapper.class);
	}
	
	public List<Article> allArticleList(int startIndex,int numOfIndex){
		Map<String, Object> map=new HashMap<>();
		map.put("startIndex",startIndex);
		map.put("numOfIndex",numOfIndex);
		return mapper.selectArticleListAll(map);
	}
	
	public List<Article> hotArticleList(int startIndex,int numOfIndex){
		Map<String, Object> map=new HashMap<>();
		map.put("startIndex",startIndex);
		map.put("numOfIndex",numOfIndex);
		return mapper.selectArticleListHot(map);
	}
	
	public List<Article> premiumArticleList(int startIndex,int numOfIndex){
		Map<String, Object> map=new HashMap<>();
		map.put("startIndex",startIndex);
		map.put("numOfIndex",numOfIndex);
		return mapper.selectArticleListPremium(map);
	}
	
	public Article select(int articleNo){
		return mapper.selectArticle(articleNo);
	}
	
	public int numberAll(){
		return mapper.articleCountAll();
	}
	
	public int numberHot(){
		return mapper.articleConuntHot();
	}
	
	public int numberPremium(){
		return mapper.articleCountPremium();
	}
	
}
