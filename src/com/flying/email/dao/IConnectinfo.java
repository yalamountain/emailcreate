package com.flying.email.dao;

import java.sql.Connection;
import java.util.List;

import com.flying.email.bean.ConnectInfo;

/**
 * auth:flying date:2017年7月27日
 **/
public interface IConnectinfo {
	/**
	 * 根据条件获取数据库链接信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public ConnectInfo getConnectInfo(Connection connection, String condtion);

	/**
	 * 根据条件获取数据库链接信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public List<ConnectInfo> getConnectInfoList(Connection connection, String condtion);
}
