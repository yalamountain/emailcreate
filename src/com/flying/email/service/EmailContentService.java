package com.flying.email.service;
/**
 * auth:flying
 * date:2017年7月25日
 **/

import java.sql.Connection;
import java.sql.SQLException;
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

	//// 数据库操作链接
	private Connection connection = null;

	/**
	 * 构造函数
	 */
	@SuppressWarnings("static-access")
	public EmailContentService() {
		this.iEmailContent = new EmailContentImpl();
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return null;
	}

	/**
	 * 
	 * @param connection
	 * @param listemailcontent
	 * @return
	 */
	public boolean insertIntoTable(List<EmailContent> listemailcontent) {
		boolean flag = false;
		try {
			this.iEmailContent.insetIntoTbableList(this.connection, listemailcontent);
			flag = true;
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}
