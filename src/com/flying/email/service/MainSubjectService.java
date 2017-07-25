package com.flying.email.service;

import java.sql.Connection;

import com.flying.email.dao.IMainSubject;
import com.flying.email.daoimpl.MainSubjectImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月25日
 **/
public class MainSubjectService {

	//// 数据操作接口
	private IMainSubject iMainSubject = null;

	//// 获取数据库链接
	private Connection connection = ConnectionFactory.getConnection();

	/**
	 * 构造函数
	 */
	public MainSubjectService() {
		this.iMainSubject = new MainSubjectImpl();
	}

}
