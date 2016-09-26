package cn.pigpi.grab.domain;

import cn.pigpi.grab.core.entity.BaseEntity;


/**
 * 公众号账户
 * @author zhushiwei
 *
 */
public class OfficialAccount extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String biz;				//公众号id
	private String nickname;		//名称
	private String accountNo;		//微信号码
	private String qrCodePath;		//二维码图片地址
	private String descr;			//公众号介绍
	private int articleNum;			//文章总数

	public String getBiz() {
		return biz;
	}

	public void setBiz(String biz) {
		this.biz = biz;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getQrCodePath() {
		return qrCodePath;
	}

	public void setQrCodePath(String qrCodePath) {
		this.qrCodePath = qrCodePath;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
}
