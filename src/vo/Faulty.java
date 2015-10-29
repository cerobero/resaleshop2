package vo;

import java.util.Date;

public class Faulty {
	private int faultyNo;// faulty_no
	private int articleNo;// article_no
	private String photo; // photo
	private String accId;// accuser_id
	private Date accDate;// accusation_date
	private String accTitle;// accusation_title
	private String accContent;// accusation_content
	////////////////////////////////////////////////

	public Faulty() {

	}

	public Faulty(int faultyNo, int articleNo, String photo, String accId,Date accDate, String accTitle, String accContent) {
		this.faultyNo = faultyNo;
		this.articleNo = articleNo;
		this.photo = photo;
		this.accId = accId;
		this.accDate = accDate;
		this.accTitle = accTitle;
		this.accContent = accContent;
	
	}
//////////////////////////////////////////////////////////////	

	public int getFaultyNo() {
		return faultyNo;
	}

	public void setFaultyNo(int faultyNo) {
		this.faultyNo = faultyNo;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	public String getAccTitle() {
		return accTitle;
	}

	public void setAccTitle(String accTitle) {
		this.accTitle = accTitle;
	}

	public String getAccContent() {
		return accContent;
	}

	public void setAccContent(String accContent) {
		this.accContent = accContent;
	}


	
	
}
