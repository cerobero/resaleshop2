package vo;

import java.util.Date;

public class Comment {
	private int commentNo;
	private int articleNo;
	private String UserId;
	private Date commentDate;
	private String commentContent;
	
		public Comment(){
			
		}

		public Comment(int commentNo, int articleNo, String userId, Date commentDate, String commentContent) {
			this.commentNo = commentNo;
			this.articleNo = articleNo;
			UserId = userId;
			this.commentDate = commentDate;
			this.commentContent = commentContent;
		}

		public int getCommentNo() {
			return commentNo;
		}

		public void setCommentNo(int commentNo) {
			this.commentNo = commentNo;
		}

		public int getArticleNo() {
			return articleNo;
		}

		public void setArticleNo(int articleNo) {
			this.articleNo = articleNo;
		}

		public String getUserId() {
			return UserId;
		}

		public void setUserId(String userId) {
			UserId = userId;
		}

		public Date getCommentDate() {
			return commentDate;
		}

		public void setCommentDate(Date commentDate) {
			this.commentDate = commentDate;
		}

		public String getCommentContent() {
			return commentContent;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}
		
		
		
}
