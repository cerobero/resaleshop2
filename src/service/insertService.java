package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.IsertDao;
import vo.Article;
import vo.Click;

@Component
public class insertService {
	@Autowired
	private IsertDao dao;

	public void setDao(IsertDao dao) {
		this.dao = dao;
	}

	public boolean insertMostClick(Click click) {
		if (dao.insertMostClick(click) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int selectTeenMostClick() {

		return dao.selectTeenMostClick();
	}

	public int selectTwentyMostClick() {

		return dao.selectTwentyMostClick();
	}

	public int selectThirtyMostClick() {

		return dao.selectThirtyMostClick();
	}

}
