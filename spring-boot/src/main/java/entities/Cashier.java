package entities;

import org.springframework.stereotype.Component;

@Component
public class Cashier {
	private int cashierid;
	private String name;
	private String code;
	private String ipaddress;
	private int status;
	

	public int getCashierid() {
		return cashierid;
	}

	public void setCashierid(int cashierid) {
		this.cashierid = cashierid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cashier(int cashierid, String code,String name, String ipaddress, int status) {
		super();
		this.cashierid = cashierid;
		this.name = name;
		this.code = code;
		this.ipaddress = ipaddress;
		this.status = status;
	}
	public Cashier() {
		
	}


}
