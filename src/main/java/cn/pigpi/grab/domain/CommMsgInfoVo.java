package cn.pigpi.grab.domain;

public class CommMsgInfoVo {
	
	private String id;
	private String type;
	private String datetime;
	private String fakeid;
	private String status;
	private String content;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getFakeid() {
		return fakeid;
	}

	public void setFakeid(String fakeid) {
		this.fakeid = fakeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommMsgInfoVo [id=" + id + ", type=" + type + ", datetime=" + datetime + ", fakeid=" + fakeid
				+ ", status=" + status + ", content=" + content + "]";
	}
	
}
