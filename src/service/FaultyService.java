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
		faulty.setAccName(accUser.getUserName());
		faulty.setAccPhone(accUser.getUserPhone());
		faulty.setArticleNo(accArticle.getArticleNo());
		int faultyCheck = (faulty.getFaultyCheck()) + 1;
		faulty.setFaultyCheck(faultyCheck);

		if (faultydao.write(faulty) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean rewriteFaulty(Faulty faulty) {
		Faulty original = faultydao.read(faulty.getFaultyNo());
		if (original.getFaultyNo() == faulty.getFaultyNo()&&original.getAccId().equals(faulty.getAccId())&&
				original.getAccName().equals(faulty.getAccName())&&original.getAccPhone().equals(faulty.getAccPhone())
				&& original.getAccEmail().equals(faulty.getAccEmail())) {
			faultydao.reWrite(faulty);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteFaulty(int faultyNo,int accUserNum) {
		Faulty testfaulty=faultydao.read(faultyNo);
		User testuser=userdao.select(accUserNum);
		if (faultydao.cancel(faultyNo) > 0 && testfaulty.getAccId().equals(testuser.getUserId())
				&& testfaulty.getAccName().equals(testuser.getUserName())
					&& testfaulty.getAccPhone().equals(testuser.getUserPhone())
						&& testfaulty.getAccEmail().equals(testuser.getUserEmail())) {
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
