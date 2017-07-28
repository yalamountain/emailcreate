package com.flying.email.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.flying.email.bean.Subject;

/**
 * auth:flying date:2017年7月27日
 **/
public class EmailContentHelper {

	/**
	 * 根据数据结果、邮件类型、邮件收件人名生成邮件内容
	 * 
	 * @param resultSet
	 *            邮件数据内容
	 * @param type
	 *            邮件类型 1:页面、2:附件、3:图片、4:页面加附件
	 * @param username
	 *            邮件收件人名
	 * @return 返回邮件内容或者是图片附件地址
	 */
	public static String getEmailContentByResultSet(ResultSet resultSet, Subject subject) {
		String resultstr = "";
		//// 当邮件内容为附件时，获取邮件存储地址
		if (subject.getEmailtype() == 2) {
			InputStream inputStream = (new Object()).getClass().getClassLoader()
					.getResourceAsStream("email.properties");
			Properties properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//// 获取附件存储文件夹
			String attchAddress = properties.getProperty("attchaddress");
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHiiss");
			String fileName = attchAddress + "/" + subject.getSubjectname() + simpleDateFormat.format(date);
			//// 将Result转化成Excel内容
			if (ExcelHelper.ResultSetToExcel(resultSet, fileName)) {
				return fileName;
			} else {
				return null;
			}
		} else if (subject.getEmailtype() == 1) {
			return getEmailHtml(resultSet, subject);
		}

		return resultstr;
	}

	/**
	 * 根据数据集生成邮件内容
	 * 
	 * @param resultSet
	 *            数据集
	 * @param subject
	 *            项目信息
	 * @return
	 */
	private static String getEmailHtml(ResultSet resultSet, Subject subject) {
		String htmlstr = "";
		try {
			htmlstr = "<table boder=1><tr>";
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columncount = resultSetMetaData.getColumnCount();
			for (int i = 0; i < columncount; i++) {
				htmlstr = htmlstr + "<th bgcolor=\"#f7ac24\">" + resultSetMetaData.getColumnName(i + 1) + "</th>";
			}

			htmlstr = htmlstr + "</tr>";

			while (resultSet.next()) {
				htmlstr = htmlstr + "<tr>";
				for (int i = 0; i < columncount; i++) {
					htmlstr = htmlstr + "<td>" + resultSet.getString(i + 1) + "</td>";
				}

				htmlstr = htmlstr + "</tr>";
			}

			htmlstr = htmlstr + "</table>";
			return htmlstr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
