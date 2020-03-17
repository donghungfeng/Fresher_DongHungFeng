package entities;

public class CashierPosterminal {
	
	private int cashierid;
	private int posterminalid;

	public CashierPosterminal() {
		// TODO Auto-generated constructor stub
	}

	public CashierPosterminal(int cashierid, int posterminalid) {
		super();
		this.cashierid = cashierid;
		this.posterminalid = posterminalid;
	}

	public int getCashierid() {
		return cashierid;
	}

	public void setCashierid(int cashierid) {
		this.cashierid = cashierid;
	}

	public int getPosterminalid() {
		return posterminalid;
	}

	public void setPosterminalid(int posterminalid) {
		this.posterminalid = posterminalid;
	}
	
	

}
