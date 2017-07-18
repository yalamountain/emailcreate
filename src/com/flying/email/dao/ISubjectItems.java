package com.flying.email.dao;

import java.sql.Connection;
import java.util.List;

import com.flying.email.bean.MainSubject;
import com.flying.email.bean.Subject;
import com.flying.email.bean.SubjectItems;

/**
 * auth:flying
 * date:2017年7月18日
 **/
public interface ISubjectItems {
	/**
	 * 根据条件获取项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public SubjectItems getSubjectItems(Connection connection, String condtion);

	/**
	 * 根据条件获取批量项目信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public List<SubjectItems> getSubjectItemsList(Connection connection, String condtion);

	/**
	 * 插入单个项目信息
	 * 
	 * @param connection
	 * @param subjectitems
	 * @return
	 */
	public int insertIntoTable(Connection connection, SubjectItems subjectitems);

	/**
	 * 批量插入数据
	 * 
	 * @param connection
	 * @param listsubjectitems
	 * @return
	 */
	public int insetIntoTbableList(Connection connection, List<SubjectItems> listsubjectitems);

	/**
	 * 更改项目信息
	 * 
	 * @param connection
	 * @param subjectitems
	 * @return
	 */
	public int updateSubjectItems(Connection connection, SubjectItems subjectitems);

	/**
	 * 执行sql
	 * 
	 * @param connection
	 * @param sql
	 * @return
	 */
	public int executeSql(Connection connection, String sql);
}
