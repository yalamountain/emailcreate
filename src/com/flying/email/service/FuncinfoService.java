package com.flying.email.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.flying.email.bean.FuncInfo;
import com.flying.email.dao.*;
import com.flying.email.daoimpl.FuncInfoImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月25日
 **/
public class FuncinfoService {

	//// 函数操作接口
	private IFuncInfo iFuncInfo = null;

	private Connection connection = null;

	/**
	 * 构造函数
	 */
	@SuppressWarnings("static-access")
	public FuncinfoService() {
		this.iFuncInfo = new FuncInfoImpl();
		try {
			this.connection = (new ConnectionFactory()).getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//// 根据函数名称获取函数信息
	public FuncInfo getFuncInfoByFunctionName(String functionname) {
		String condtion = " functionname= '" + functionname + "'";
		FuncInfo temp = new FuncInfo();
		temp = this.iFuncInfo.getFuncInfo(this.connection, condtion);

		try {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}

			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
