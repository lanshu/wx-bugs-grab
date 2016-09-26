package cn.pigpi.grab.domain;

import java.util.List;

/**
 * Json串中文章列表信息
 * @author zhushiwei
 *
 */
public class AppMsgExtInfoVo {
	private String title;
	private String digest;
	private String content;
	private String fileid;
	private String content_url;
	private String source_url;
	private String cover;
	private String subtype;
	private String is_multi;
	private List<AppMsgExtInfoVo> multi_app_msg_item_list;
	private String author;
	private String copyright_stat;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getContent_url() {
		return content_url;
	}
	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getIs_multi() {
		return is_multi;
	}
	public void setIs_multi(String is_multi) {
		this.is_multi = is_multi;
	}
	public List<AppMsgExtInfoVo> getMulti_app_msg_item_list() {
		return multi_app_msg_item_list;
	}
	public void setMulti_app_msg_item_list(List<AppMsgExtInfoVo> multi_app_msg_item_list) {
		this.multi_app_msg_item_list = multi_app_msg_item_list;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCopyright_stat() {
		return copyright_stat;
	}
	public void setCopyright_stat(String copyright_stat) {
		this.copyright_stat = copyright_stat;
	}
	@Override
	public String toString() {
		return "AppMsgExtInfoVo [title=" + title + ", digest=" + digest + ", content=" + content + ", fileid=" + fileid
				+ ", content_url=" + content_url + ", source_url=" + source_url + ", cover=" + cover + ", subtype="
				+ subtype + ", is_multi=" + is_multi + ", multi_app_msg_item_list=" + multi_app_msg_item_list
				+ ", author=" + author + ", copyright_stat=" + copyright_stat + "]";
	}
	
	
}
