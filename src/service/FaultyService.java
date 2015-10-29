package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ArticleDao;
import repository.FaultyDao;
import repository.UserDao;
import vo.Article;
import vo.Faulty;
import vo.User;

@Component
public class FaultyService {
	private FaultyDao faultydao;
	private UserDao userdao;
	private ArticleDao articledao;

	@Autowired
	public void setFaultydao(FaultyDao faultydao) {
		this.faultydao = faultydao;
	}

	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Autowired
	public void setArticledao(ArticleDao articledao) {
		this.articledao = articledao;
	}

	public boolean writeFaulty(Faulty faulty, int accUserNum, int articleNo) {

		Date accDate = new Date();
		User accUser = userdao.select(accUserNum);
		Article accArticle = articledao.select(articleNo);

		faulty.setAccDate(accDate);
		faulty.setAccId(accUser.getUserId());
		faulty.setArticleNo(accArticle.getArticleNo());
		int faultyCheck = (accArticle.getFaultyCheck()) + 1;
		accArticle.setFaultyCheck(faultyCheck);

		if (faultydao.write(faulty) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean rewriteFaulty(Faulty faulty) {
		Faulty original = faultydao.read(faulty.getFaultyNo());
		if (original.getFaultyNo() == faulty.getFaultyNo()&&original.getAccId().equals(faulty.getAccId())) {
			faultydao.reWrite(faulty);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteFaulty(int faultyNo,int accUserNum) {
		Faulty testfaulty=faultydao.read(faultyNo);
		User testuser=userdao.select(accUserNum);
		if (faultydao.cancel(faultyNo) > 0 && testfaulty.getAccId().equals(testuser.getUserId())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public List<Faulty> listFaulty(int articleNo){
		return faultydao.listView(articleNo);
	}
	
	public Faulty readFaulty(int faultyNo){
		return faultydao.read(faultyNo);
	}
	
	public int numberFaulty(int articleNo){
		return faultydao.faultyNumber(articleNo);	
	}
}
