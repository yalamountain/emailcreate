package com.flying.email.service;
/**
 * auth:flying
 * date:2017年7月25日
 **/

import com.flying.email.dao.IEmailContent;
import com.flying.email.daoimpl.EmailContentImpl;

public class EmailContentService {

	private IEmailContent iEmailContent = null;

	/**
	 * 构造函数
	 */
	public EmailContentService() {
		this.iEmailContent = new EmailContentImpl();
	}
}
