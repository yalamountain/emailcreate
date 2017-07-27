package com.flying.email.service;

import java.sql.Connection;

import com.flying.email.bean.ConnectInfo;
import com.flying.email.dao.IConnectinfo;
import com.flying.email.dao.IEmailContent;
import com.flying.email.daoimpl.ConnectInfoImpl;
import com.flying.email.daoimpl.EmailContentImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月27日
 **/
public class ConnectInfoService {

	//// 数据操作接口
	private IConnectinfo iConnectinfo = null;

	//// 数据库链接
	private Connection connection = null;

	/**
	 * 构造函数
	 */
	public ConnectInfoService() {
		this.iConnectinfo = new ConnectInfoImpl();
		try {
			this.connection = (new ConnectionFactory()).getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据数据库链接名，获取数据库链接信息
	 * 
	 * @param connectaccount
	 *            数据库链接名
	 * @return
	 */
	public ConnectInfo getConnectionInfoByAccount(String connectaccount) {
		String condtion = " connectaccount='" + connectaccount + "'";
		return this.iConnectinfo.getConnectInfo(this.connection, condtion);
	}
}
