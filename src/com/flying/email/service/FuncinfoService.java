package com.flying.email.service;

import com.flying.email.bean.FuncInfo;
import com.flying.email.dao.*;
import com.flying.email.daoimpl.FuncInfoImpl;

/**
 * auth:flying date:2017年7月25日
 **/
public class FuncinfoService {

	private IFuncInfo iFuncInfo = null;

	/**
	 * 构造函数
	 */
	public FuncinfoService() {
		this.iFuncInfo = new FuncInfoImpl();
	}

}
