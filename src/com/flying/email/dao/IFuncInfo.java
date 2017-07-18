package com.flying.email.dao;

import java.sql.Connection;
import java.util.List;

import com.flying.email.bean.EmailContent;
import com.flying.email.bean.FuncInfo;

/**
 * auth:flying date:2017年7月18日
 **/
public interface IFuncInfo {
	/**
	 * 根据条件函数信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public FuncInfo getFuncInfo(Connection connection, String condtion);

	/**
	 * 根据条件函数信息
	 * 
	 * @param connection
	 * @param condtion
	 * @return
	 */
	public List<FuncInfo> getFuncInfoList(Connection connection, String condtion);

	/**
	 * 插入单条邮件内容
	 * 
	 * @param connection
	 * @param funcInfo
	 * @return
	 */
	public int insertIntoTable(Connection connection, FuncInfo funcInfo);

	/**
	 * 批量插入数据
	 * 
	 * @param connection
	 * @param listfuncinfo
	 * @return
	 */
	public int insetIntoTbableList(Connection connection, List<FuncInfo> listfuncinfo);

	/**
	 * 更新函数信息
	 * 
	 * @param connection
	 * @param funcInfo
	 * @return
	 */
	public int updateMainSubject(Connection connection, FuncInfo funcInfo);

	/**
	 * 执行sql
	 * 
	 * @param connection
	 * @param sql
	 * @return
	 */
	public int executeSql(Connection connection, String sql);
}
