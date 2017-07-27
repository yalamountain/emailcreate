package com.flying.email.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flying.email.bean.EmailPerson;
import com.flying.email.bean.FuncInfo;
import com.flying.email.bean.SubjectItems;
import com.flying.email.dao.ISubjectItems;
import com.flying.email.daoimpl.SubjectItemsImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectItemsService {

	//// 操作接口
	private ISubjectItems iSubjectItems = null;

	//// 获取数据库链接
	private Connection connection = null;

	/**
	 * 构造函数
	 */
	public SubjectItemsService() {
		this.iSubjectItems = new SubjectItemsImpl();
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据项目ID获取子选项 按执行顺序
	 * 
	 * @param subjectid
	 * @return
	 */
	public List<SubjectItems> getSubjectItemsBySubjectId(int subjectid) {
		String condition = "  subjectid=" + subjectid + " order by execution asc ";
		List<SubjectItems> lItems = this.iSubjectItems.getSubjectItemsList(this.connection, condition);

		try {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}

			return lItems;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//// 根据内容获取邮件收件人
	public List<EmailPerson> getEmailPerson(String functionname, String param) {
		List<EmailPerson> listperson = new ArrayList<EmailPerson>();
		FuncInfo funcInfo = (new FuncinfoService()).getFuncInfoByFunctionName(functionname);
		if (funcInfo == null) {
			return null;
		} else {
			try {
				//// 反射映射出需要分析的类
				Class classtemp = Class.forName(funcInfo.getClassName().trim());
				Method method = classtemp.getMethod(funcInfo.getFunctionname(), String.class);
				listperson = (List<EmailPerson>) method.invoke(classtemp.newInstance(), param);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listperson;
	}
}
