package cn.pigpi.grab.domain;

/**
 * 
 * @author zhushiwei
 *
 */
public class ImageMsgExtInfo {
	private String length;
	private String mediaid;
	private String fileid;
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getMediaid() {
		return mediaid;
	}
	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	@Override
	public String toString() {
		return "ImageMsgExtInfo [length=" + length + ", mediaid=" + mediaid + ", fileid=" + fileid + "]";
	}
	
}
