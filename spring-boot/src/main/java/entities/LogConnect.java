package entities;

public class LogConnect {
	
	private int id;
	private String type;
	private String createdate;
	private String sourceip;
	private String destinationip;
	private String metadata;

	public LogConnect() {
		// TODO Auto-generated constructor stub
	}

	public LogConnect(int id, String type, String createdate, String sourceip, String destinationip, String metadata) {
		super();
		this.id = id;
		this.type = type;
		this.createdate = createdate;
		this.sourceip = sourceip;
		this.destinationip = destinationip;
		this.metadata = metadata;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getSourceip() {
		return sourceip;
	}

	public void setSourceip(String sourceip) {
		this.sourceip = sourceip;
	}

	public String getDestinationip() {
		return destinationip;
	}

	public void setDestinationip(String destinationip) {
		this.destinationip = destinationip;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

}
