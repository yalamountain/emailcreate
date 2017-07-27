package com.flying.email.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import com.flying.email.bean.ConnectInfo;
import com.flying.email.service.ConnectInfoService;

/**
 * auth:flying date:2017年7月27日
 **/
public class EmailDataHelper {

	/**
	 * 根据源参数转换SQL、获取数据库链接，查询获取ResultSet
	 * 
	 * @param param
	 *            sql参数和数据库链接信息(Sql：select * from
	 *            etlprograminfo|Connection:dwcfg_mysql_r)
	 * @return
	 */
	public static ResultSet getEmailData(String param, Date datadatetime) {
		//// 分割参数、获取Sql和数据库链接源
		String[] paStrings = param.replaceAll("：", ":").split("\\|");
		if (paStrings.length != 2) {
			return null;
		} else {
			String sqlStr = SubjectHelper.getSqlString(paStrings[0].replaceAll("Sql:", ""), datadatetime);
			String connectStr = paStrings[1].replaceAll("Connection:", paStrings[1]);
			return getResultByConnect(sqlStr, connectStr);
		}
	}

	/**
	 * 根据sql和数据链接名，获取数据查询结果
	 * 
	 * @param sqlstr
	 * @param connectstr
	 * @return
	 */
	private static ResultSet getResultByConnect(String sqlstr, String connectstr) {
		//// 当数据库链接不为空
		if (connectstr != null && connectstr != "") {
			ConnectInfoService connectInfoService = new ConnectInfoService();
			ConnectInfo connectInfo = connectInfoService.getConnectionInfoByAccount(connectstr.trim());
			String username = connectInfo.getUseraccount().trim();
			String password = Encrypt.aesDecrypt(connectInfo.getUserpassword().trim());
			String jdbcurl = "jdbc:mysql://" + connectInfo.getIpaddress() + ":3306";
			String drivercalss = "com.mysql.jdbc.Driver";
			Driver driver;
			Connection connection = null;
			PreparedStatement prep = null;
			ResultSet resultSet = null;
			try {
				driver = (Driver) Class.forName(drivercalss).newInstance();
				Properties dbinfo = new Properties();
				dbinfo.setProperty("user", username);
				dbinfo.setProperty("password", password);
				connection = driver.connect(jdbcurl, dbinfo);
				prep = connection.prepareStatement(sqlstr);
				resultSet = prep.executeQuery();
				return resultSet;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (!connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}
}
