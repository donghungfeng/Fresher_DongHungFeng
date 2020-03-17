package entities;

public class Posterminal {
	
	private int posterminalid;
	private String name;
	private String code;
	private String ipaddress;
	private int status;

	public int getPosterminalid() {
		return posterminalid;
	}

	public void setPosterminalid(int posterminalid) {
		this.posterminalid = posterminalid;
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

	public Posterminal(int posterminalid, String code,String name, String ipaddress, int status) {
		super();
		this.posterminalid = posterminalid;
		this.name = name;
		this.code = code;
		this.ipaddress = ipaddress;
		this.status = status;
	}

	public Posterminal() {
		// TODO Auto-generated constructor stub
	}

}
