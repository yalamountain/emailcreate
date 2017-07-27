package com.flying.email.bean;

/**
 * 收件人姓名、邮箱地址 auth:flying date:2017年7月26日
 **/
@SuppressWarnings("serial")
public class EmailPerson implements java.io.Serializable {
	private String emailAddress = "";
	private String userName = "";

	/**
	 * 无参构造函数
	 */
	public EmailPerson() {
	}

	public EmailPerson(String email, String name) {
		this.emailAddress = email;
		this.userName = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
