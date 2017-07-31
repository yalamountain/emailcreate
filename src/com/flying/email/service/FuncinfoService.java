package com.flying.email.service;

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

	/**
	 * 构造函数
	 */
	public FuncinfoService() {
		this.iFuncInfo = new FuncInfoImpl();
	}

	//// 根据函数名称获取函数信息
	public FuncInfo getFuncInfoByFunctionName(String functionname) {
		String condtion = " functionname= '" + functionname + "'";
		return this.iFuncInfo.getFuncInfo(ConnectionFactory.getConnection(), condtion);
	}

}
