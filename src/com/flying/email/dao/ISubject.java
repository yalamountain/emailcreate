package com.flying.email.dao;

import java.sql.Connection;
import java.util.List;

import com.flying.email.bean.MainSubject;
import com.flying.email.bean.Subject;

/**
 * auth:flying date:2017年7月18日
 **/
public interface ISubject {
	/**
	 * 根据条件获取项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public Subject getSubject(Connection connection, String condtion);

	/**
	 * 根据条件获取批量项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public List<Subject> getSubjectList(Connection connection, String condtion);

	/**
	 * 插入单个项目信息
	 * 
	 * @param connection
	 * @param subject
	 * @return
	 */
	public int insertIntoTable(Connection connection, Subject subject);

	/**
	 * 批量插入数据
	 * 
	 * @param connection
	 * @param listsubject
	 * @return
	 */
	public int insetIntoTbableList(Connection connection, List<Subject> listsubject);

	/**
	 * 更改项目信息
	 * 
	 * @param connection
	 * @param subject
	 * @return
	 */
	public int updateSubject(Connection connection, Subject subject);

	/**
	 * 执行sql
	 * 
	 * @param connection
	 * @param sql
	 * @return
	 */
	public boolean executeSql(Connection connection, String sql);
}
