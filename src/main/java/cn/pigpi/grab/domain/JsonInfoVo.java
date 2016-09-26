package cn.pigpi.grab.domain;

public class JsonInfoVo {
	
	private CommMsgInfoVo comm_msg_info;			//文章公共信息
	
	private AppMsgExtInfoVo app_msg_ext_info;		//文章详情
	
	private ImageMsgExtInfo image_msg_ext_info;		//文章图片信息， 当只有一张图时候不为null
	
	public ImageMsgExtInfo getImage_msg_ext_info() {
		return image_msg_ext_info;
	}

	public void setImage_msg_ext_info(ImageMsgExtInfo image_msg_ext_info) {
		this.image_msg_ext_info = image_msg_ext_info;
	}

	public CommMsgInfoVo getComm_msg_info() {
		return comm_msg_info;
	}

	public void setComm_msg_info(CommMsgInfoVo comm_msg_info) {
		this.comm_msg_info = comm_msg_info;
	}

	public AppMsgExtInfoVo getApp_msg_ext_info() {
		return app_msg_ext_info;
	}

	public void setApp_msg_ext_info(AppMsgExtInfoVo app_msg_ext_info) {
		this.app_msg_ext_info = app_msg_ext_info;
	}

	@Override
	public String toString() {
		return "JsonInfoVo [comm_msg_info=" + comm_msg_info + ", app_msg_ext_info=" + app_msg_ext_info
				+ ", image_msg_ext_info=" + image_msg_ext_info + "]";
	}
}
