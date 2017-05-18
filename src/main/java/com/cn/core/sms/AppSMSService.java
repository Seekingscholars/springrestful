package com.cn.core.sms;

import com.cn.core.sms.entity.AuthCode;

/**
 * 发送短信公开接口
 */
public interface AppSMSService {

	/**
	 * 获取流水号(无需流水号时返回null即可)
	 * @return
	 */
	public String getSerialNumber();
	
	/**
	 * 发送短信验证码
	 * @param authCode	短信验证码对象
	 * @return json格式的发送结果
	 */
	public String sendAuthCode(AuthCode authCode);
}
