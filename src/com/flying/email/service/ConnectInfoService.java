package com.flying.email.service;

import com.flying.email.bean.ConnectInfo;
import com.flying.email.dao.IConnectinfo;
import com.flying.email.daoimpl.ConnectInfoImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月27日
 **/
public class ConnectInfoService {

	//// 数据操作接口
	private IConnectinfo iConnectinfo = null;

	/**
	 * 构造函数
	 */
	public ConnectInfoService() {
		this.iConnectinfo = new ConnectInfoImpl();
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
		return this.iConnectinfo.getConnectInfo(ConnectionFactory.getConnection(), condtion);
	}
}
