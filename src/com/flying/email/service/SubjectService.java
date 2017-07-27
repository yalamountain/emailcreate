package com.flying.email.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.flying.email.bean.EmailPerson;
import com.flying.email.bean.Subject;
import com.flying.email.bean.SubjectItems;
import com.flying.email.dao.ISubject;
import com.flying.email.daoimpl.SubjectImpl;
import com.flying.email.factory.ConnectionFactory;
import com.flying.email.util.SubjectHelper;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectService {

	//// 数据操作接口
	private ISubject iSubject = null;

	//// 获取数据库链接
	private Connection connection = null;

	/**
	 * 构造函数
	 */
	@SuppressWarnings("static-access")
	public SubjectService() {
		this.iSubject = new SubjectImpl();
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据主项目ID、返回项目数据
	 * 
	 * @param mainsubjectid
	 * @return
	 */
	public LinkedList<Subject> getSubjectByMainSubjectId(int mainsubjectid) {
		String condition = " mainsubjectid=" + mainsubjectid + " and isforbidden=0 order by subjectlevel desc";
		LinkedList<Subject> linkedList = this.iSubject.getSubjectList(this.connection, condition);
		return linkedList;
	}

	/**
	 * 执行项目分析
	 * 
	 * @param subject
	 */
	public Object executeSubject(Subject subject) {
		if (calcSubjectToBeExecute(subject, new Date())) {
			List<EmailPerson> listperson = new ArrayList<EmailPerson>();
			SubjectItemsService subjectItemsService = new SubjectItemsService();
			//// 获取当前项目的所有子项目集合
			List<SubjectItems> lItems = subjectItemsService.getSubjectItemsBySubjectId(subject.getKeyId());
			Iterator<SubjectItems> iterable = lItems.iterator();
			while (iterable.hasNext()) {
				SubjectItems subjectItems = (SubjectItems) iterable.next();
				//// 获取邮件收件人
				if (subjectItems.getExecution() == 1) {
					listperson = subjectItemsService.getEmailPerson(subjectItems.getFunctionname(),
							subjectItems.getDataparam());
				}

				//// 获取邮件内容
				if (subjectItems.getExecution() == 2) {

				}
			}
		}

		return null;
	}

	/**
	 * 判断当前项目是否应该被执行
	 * 
	 * @param subject
	 *            需要分析的项目
	 * @param runtime
	 *            当前时间
	 * @return
	 */
	public boolean calcSubjectToBeExecute(Subject subject, Date runtime) {
		boolean flag = false;
		Date date = SubjectHelper.CalclateDelayTime(subject.getDelayTime(), subject.getRunDateTime());
		//// 当运行时间加上延迟时间的偏移量小于当前时间，则应该运行该内容
		if ((runtime.getTime() - date.getTime()) > 0) {
			flag = true;
		}

		return flag;
	}
}
