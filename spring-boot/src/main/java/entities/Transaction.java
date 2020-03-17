package entities;

public class Transaction {
	
	private int transactionid;
	private int cashierid;
	private int posterminalid;
	private String amount;
	private String posrequestdate;
	private String posresponsedate;
	private String token;
	private String req_metadata;
	private String resp_metadata;
	private String resp_code;
	private String resp_message;
	private int status;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionid, int cashierid, int posterminalid, String amount, String posrequestdate,
			String posresponsedate, String token, String req_metadata, String resp_metadata, String resp_code,
			String resp_message, int status) {
		super();
		this.transactionid = transactionid;
		this.cashierid = cashierid;
		this.posterminalid = posterminalid;
		this.amount = amount;
		this.posrequestdate = posrequestdate;
		this.posresponsedate = posresponsedate;
		this.token = token;
		this.req_metadata = req_metadata;
		this.resp_metadata = resp_metadata;
		this.resp_code = resp_code;
		this.resp_message = resp_message;
		this.status = status;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPosrequestdate() {
		return posrequestdate;
	}

	public void setPosrequestdate(String posrequestdate) {
		this.posrequestdate = posrequestdate;
	}

	public String getPosresponsedate() {
		return posresponsedate;
	}

	public void setPosresponsedate(String posresponsedate) {
		this.posresponsedate = posresponsedate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getReq_metadata() {
		return req_metadata;
	}

	public void setReq_metadata(String req_metadata) {
		this.req_metadata = req_metadata;
	}

	public String getResp_metadata() {
		return resp_metadata;
	}

	public void setResp_metadata(String resp_metadata) {
		this.resp_metadata = resp_metadata;
	}

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public String getResp_message() {
		return resp_message;
	}

	public void setResp_message(String resp_message) {
		this.resp_message = resp_message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
