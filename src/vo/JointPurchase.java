package vo;

public class JointPurchase {
	private int order_no;
	private String user_id;
	private int paid;
	private int sended;
	private int winner;
	private int awaiter;
	
	public JointPurchase(int order_no, String user_id, int paid, int sended, int winner, int awaiter) {
		super();
		this.order_no = order_no;
		this.user_id = user_id;
		this.paid = paid;
		this.sended = sended;
		this.winner = winner;
		this.awaiter = awaiter;
	}

	public JointPurchase(){}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getSended() {
		return sended;
	}

	public void setSended(int sended) {
		this.sended = sended;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public int getAwaiter() {
		return awaiter;
	}

	public void setAwaiter(int awaiter) {
		this.awaiter = awaiter;
	}
	
	
	
}
	