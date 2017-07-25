package com.flying.email.service;

import com.flying.email.dao.ISubject;
import com.flying.email.daoimpl.SubjectImpl;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectService {

	private ISubject iSubject = null;

	/**
	 * 构造函数
	 */
	public SubjectService() {
		this.iSubject = new SubjectImpl();
	}
}
