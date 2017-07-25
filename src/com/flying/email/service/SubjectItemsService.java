package com.flying.email.service;

import com.flying.email.dao.ISubjectItems;
import com.flying.email.daoimpl.SubjectImpl;
import com.flying.email.daoimpl.SubjectItemsImpl;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectItemsService {

	private ISubjectItems iSubjectItems = null;

	/**
	 * 构造函数
	 */
	public SubjectItemsService() {
		this.iSubjectItems = new SubjectItemsImpl();
	}
}
