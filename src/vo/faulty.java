package vo;

import java.util.Date;

public class faulty {
	private int faultyNo;// faulty_no
	private int articleNo;// article_no
	private String photo; // photo
	private String accId;// accuser_id
	private String accName;// accuser_name
	private String accPhone;// accuser_phone
	private String accEmail;// accuser_email
	private Date accDate;// accusation_date
	private String accTitle;// accusation_title
	private String accContent;// accusation_content
	private int faultyCheck;// faulty_check
	////////////////////////////////////////////////

	public faulty() {

	}

	public faulty(int faultyNo, int articleNo, String photo, String accId, String accName, String accPhone,
			String accEmail, Date accDate, String accTitle, String accContent, int faultyCheck) {
		this.faultyNo = faultyNo;
		this.articleNo = articleNo;
		this.photo = photo;
		this.accId = accId;
		this.accName = accName;
		this.accPhone = accPhone;
		this.accEmail = accEmail;
		this.accDate = accDate;
		this.accTitle = accTitle;
		this.accContent = accContent;
		this.faultyCheck = faultyCheck;
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

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccPhone() {
		return accPhone;
	}

	public void setAccPhone(String accPhone) {
		this.accPhone = accPhone;
	}

	public String getAccEmail() {
		return accEmail;
	}

	public void setAccEmail(String accEmail) {
		this.accEmail = accEmail;
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

	public int getFaultyCheck() {
		return faultyCheck;
	}

	public void setFaultyCheck(int faultyCheck) {
		this.faultyCheck = faultyCheck;
	}
	
	
}
