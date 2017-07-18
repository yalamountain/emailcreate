package com.flying.email.dao;

import java.sql.Connection;
import java.util.List;

import com.flying.email.bean.FuncInfo;
import com.flying.email.bean.MainSubject;

/**
 * auth:flying date:2017年7月18日
 **/
public interface IMainSubject {
	/**
	 * 根据条件获取项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public MainSubject getMainSubject(Connection connection, String condtion);

	/**
	 * 根据条件获取批量项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public List<MainSubject> getMainSubjectList(Connection connection, String condtion);

	/**
	 * 插入当个项目信息
	 * 
	 * @param connection
	 * @param listmainsubject
	 * @return
	 */
	public int insertIntoTable(Connection connection, MainSubject listmainsubject);

	/**
	 * 批量插入数据
	 * 
	 * @param connection
	 * @param listmainsubject
	 * @return
	 */
	public int insetIntoTbableList(Connection connection, List<MainSubject> listmainsubject);

	/**
	 * 更新主项目信息
	 * 
	 * @param connection
	 * @param mainsubject
	 * @return
	 */
	public int updateMainSubject(Connection connection, MainSubject mainsubject);

	/**
	 * 执行sql
	 * 
	 * @param connection
	 * @param sql
	 * @return
	 */
	public int executeSql(Connection connection, String sql);
}
