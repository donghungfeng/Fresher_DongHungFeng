package entities;

public class Transaction {
	
	private int requestid;
	private String transtype;
	private String cardno;
	private String amount;
	private String stan;
	private String time;
	private String expiredate;
	private String refno;
	private String approvalcode;
	private String returncode;
	private String tid;
	private String mid;
	private String currencycode;
	private String batchno;
	private String receiptno;
	private String cardtype;
	private String cardholder;
	private String cardinput;
	private String emvappname;
	private String emvaid;
	private String emvtc;
	private String posserial;
	private String transname;
	private String transstatus;
	private String clientid;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(int requestid, String transtype, String cardno, String amount, String stan, String time,
			String expiredate, String refno, String approvalcode, String returncode, String tid, String mid,
			String currencycode, String batchno, String receiptno, String cardtype, String cardholder, String cardinput,
			String emvappname, String emvaid, String emvtc, String posserial, String transname, String transstatus,
			String clientid) {
		super();
		this.requestid = requestid;
		this.transtype = transtype;
		this.cardno = cardno;
		this.amount = amount;
		this.stan = stan;
		this.time = time;
		this.expiredate = expiredate;
		this.refno = refno;
		this.approvalcode = approvalcode;
		this.returncode = returncode;
		this.tid = tid;
		this.mid = mid;
		this.currencycode = currencycode;
		this.batchno = batchno;
		this.receiptno = receiptno;
		this.cardtype = cardtype;
		this.cardholder = cardholder;
		this.cardinput = cardinput;
		this.emvappname = emvappname;
		this.emvaid = emvaid;
		this.emvtc = emvtc;
		this.posserial = posserial;
		this.transname = transname;
		this.transstatus = transstatus;
		this.clientid = clientid;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getApprovalcode() {
		return approvalcode;
	}

	public void setApprovalcode(String approvalcode) {
		this.approvalcode = approvalcode;
	}

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getReceiptno() {
		return receiptno;
	}

	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public String getCardinput() {
		return cardinput;
	}

	public void setCardinput(String cardinput) {
		this.cardinput = cardinput;
	}

	public String getEmvappname() {
		return emvappname;
	}

	public void setEmvappname(String emvappname) {
		this.emvappname = emvappname;
	}

	public String getEmvaid() {
		return emvaid;
	}

	public void setEmvaid(String emvaid) {
		this.emvaid = emvaid;
	}

	public String getEmvtc() {
		return emvtc;
	}

	public void setEmvtc(String emvtc) {
		this.emvtc = emvtc;
	}

	public String getPosserial() {
		return posserial;
	}

	public void setPosserial(String posserial) {
		this.posserial = posserial;
	}

	public String getTransname() {
		return transname;
	}

	public void setTransname(String transname) {
		this.transname = transname;
	}

	public String getTransstatus() {
		return transstatus;
	}

	public void setTransstatus(String transstatus) {
		this.transstatus = transstatus;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	

}
