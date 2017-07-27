package com.flying.email.util;

import java.util.ArrayList;
import java.util.List;

import com.flying.email.bean.EmailPerson;

/**
 * auth:flying date:2017年7月26日
 **/
public class EmailPersonHelper {

	/**
	 * 从参数获取用户邮箱和姓名（Email:814071720@qq.com|AliasName:荒山野人）
	 * 
	 * @param param
	 * @return
	 */
	public List<EmailPerson> getEmailPerson(String param) {
		List<EmailPerson> listperson = new ArrayList<EmailPerson>();
		//// 替换中文逗号，并分割数组
		String[] pStrings = param.replaceAll("，", ",").replaceAll("：", ":").split("\\|");
		if (pStrings.length != 2) {
			return null;
		} else {
			//// 分割邮件收件人和邮箱地址
			String[] emails = pStrings[0].replaceAll("Email:", "").split(",");
			String[] persons = pStrings[1].replaceAll("AliasName:", "").split(",");

			int perscount = emails.length > persons.length ? persons.length : emails.length;
			for (int i = 0; i < perscount; i++) {
				EmailPerson emailPerson = new EmailPerson();
				emailPerson.setEmailAddress(emails[i]);
				emailPerson.setUserName(persons[i]);
				listperson.add(emailPerson);
			}
		}

		return listperson;
	}

}
