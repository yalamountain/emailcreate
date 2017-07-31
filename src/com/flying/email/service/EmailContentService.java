package com.flying.email.service;
/**
 * auth:flying
 * date:2017年7月25日
 **/

import java.util.Date;
import java.util.List;

import com.flying.email.bean.EmailContent;
import com.flying.email.bean.EmailPerson;
import com.flying.email.bean.Subject;
import com.flying.email.dao.IEmailContent;
import com.flying.email.daoimpl.EmailContentImpl;
import com.flying.email.factory.ConnectionFactory;

public class EmailContentService {

	//// 数据操作接口
	private IEmailContent iEmailContent = null;

	/**
	 * 构造函数
	 */
	public EmailContentService() {
		this.iEmailContent = new EmailContentImpl();
	}

	/**
	 * 根据收件人，项目信息，邮件内容生成邮箱信息，待发送
	 * 
	 * @param emailPerson
	 * @param subject
	 * @param content
	 * @return
	 */
	public EmailContent createEmailContent(EmailPerson emailPerson, Subject subject, String content) {
		EmailContent emailContent = new EmailContent();
		emailContent.setEmailto(emailPerson.getEmailAddress());
		emailContent.setEmailsubject(subject.getSubjectname());
		emailContent.setEmailtype(subject.getEmailtype());
		emailContent.setAttachment(subject.getEmailtype() == 2 ? content : "");
		emailContent.setSubjectlevel(subject.getSubjectlevel());
		emailContent.setCreateTime(new Date());
		emailContent.setEmailcontent(subject.getEmailtype() == 1 ? content : "");
		return emailContent;
	}

	/**
	 * 
	 * @param listemailcontent
	 * @return
	 */
	public boolean insertIntoTable(List<EmailContent> listemailcontent) {
		boolean flag = false;

		//// 插入数据大于0时才返回成功
		if (this.iEmailContent.insetIntoTbableList(ConnectionFactory.getConnection(), listemailcontent) > 0) {
			flag = true;
		}

		return flag;
	}
}
