package com.flying.email.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.flying.email.bean.EmailContent;
import com.flying.email.bean.EmailPerson;
import com.flying.email.bean.Subject;
import com.flying.email.bean.SubjectItems;
import com.flying.email.dao.ISubject;
import com.flying.email.daoimpl.SubjectImpl;
import com.flying.email.factory.ConnectionFactory;
import com.flying.email.util.EmailContentHelper;
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
	 * @return 返回执行是否成功
	 */
	@SuppressWarnings("null")
	public boolean executeSubject(Subject subject) {
		if (calcSubjectToBeExecute(subject, new Date())) {
			List<EmailPerson> listperson = new ArrayList<EmailPerson>();
			String content = "";
			List<EmailContent> listemailcontent = new ArrayList<EmailContent>();
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
					content = EmailContentHelper
							.getEmailContentByResultSet(subjectItemsService.getDataSet(subjectItems.getFunctionname(),
									subjectItems.getDataparam(), subject.getDataDateTime()), subject);
				}
			}

			if (listperson != null || (!listperson.isEmpty())) {
				EmailContentService emailContentService = new EmailContentService();
				for (EmailPerson emailPerson : listperson) {
					//// 生成邮件内容
					listemailcontent.add(emailContentService.createEmailContent(emailPerson, subject, content));
				}

				if (emailContentService.insertIntoTable(listemailcontent)) {
					this.addCycleSubject(subject);
					if (this.updateSubject(subject)) {
						return true;
					}
				}
			}

		}

		return false;
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

	/**
	 * 当前项目加一周期
	 * 
	 * @param subject
	 *            添加一周期的项目
	 * @return 返回添加时间后的项目
	 */
	public Subject addCycleSubject(Subject subject) {
		if (subject != null) {
			Calendar cadata = Calendar.getInstance();
			cadata.setTime(subject.getDataDateTime());
			Calendar carun = Calendar.getInstance();
			carun.setTime(subject.getRunDateTime());
			switch (subject.getDatacycle()) {
			case 1:
				cadata.add(Calendar.SECOND, 3600);
				carun.add(Calendar.SECOND, 3600);
				break;
			case 2:
				cadata.add(Calendar.DAY_OF_MONTH, 1);
				carun.add(Calendar.DAY_OF_MONTH, 1);
				break;
			case 3:
				cadata.add(Calendar.WEEK_OF_YEAR, 1);
				carun.add(Calendar.WEEK_OF_YEAR, 1);
				break;
			case 4:
				cadata.add(Calendar.MONTH, 1);
				cadata.add(Calendar.MONTH, 1);
				break;
			case 5:
				cadata.add(Calendar.MONTH, 3);
				carun.add(Calendar.MONTH, 3);
				break;
			case 6:
				cadata.add(Calendar.YEAR, 1);
				carun.add(Calendar.YEAR, 1);
				break;
			default:
				cadata.add(Calendar.SECOND, 3600);
				carun.add(Calendar.SECOND, 3600);
				break;
			}

			subject.setDataDateTime(cadata.getTime());
			subject.setRunDateTime(carun.getTime());
			subject.setModifyUser("增加一周期" + (new Date()).toString());

		}

		return subject;
	}

	/**
	 * 更新项目信息
	 * 
	 * @param subject
	 *            需要更新的项目信息
	 * @return 返回更新结果
	 */
	public boolean updateSubject(Subject subject) {
		try {
			this.iSubject.updateSubject(this.connection, subject);
			if (this.connection.isClosed()) {
				this.connection.close();
			}

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
