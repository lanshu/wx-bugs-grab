package cn.pigpi.grab.domain;

import cn.pigpi.grab.core.entity.BaseEntity;

public class Article extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String id;					//文章id(自增)
	private String groupId;				//文章分组ID
	private String biz;					//公众号id
	private String accountName;			//公众号名称
	private String appUni;				//访问客户端id
	private String title;				//文章名称
	private String digest;				//文章概述
	private String headImg;				//首图
	private String url;					//文章地址
	private String publishTime;			//发布时间
	private String idx;					//文章当天发布顺序
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBiz() {
		return biz;
	}
	public void setBiz(String biz) {
		this.biz = biz;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAppUni() {
		return appUni;
	}
	public void setAppUni(String appUni) {
		this.appUni = appUni;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", groupId=" + groupId + ", biz=" + biz + ", accountName=" + accountName
				+ ", appUni=" + appUni + ", title=" + title + ", digest=" + digest + ", headImg=" + headImg + ", url="
				+ url + ", publishTime=" + publishTime + ", idx=" + idx + "]";
	}
	
}
