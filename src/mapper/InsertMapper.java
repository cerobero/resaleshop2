package mapper;

import java.util.List;
import java.util.Map;

import vo.Article;
import vo.Click;

public interface InsertMapper

{
	public int insertMostClick(Click click);
	public int selectTeenMostClick();
	public int selectTwentyMostClick();
	public int selectThirtyMostClick();


}
