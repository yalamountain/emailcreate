package com.flying.email.service;

import java.util.List;
import com.flying.email.bean.MainSubject;
import com.flying.email.bean.Subject;
import com.flying.email.dao.IMainSubject;
import com.flying.email.daoimpl.MainSubjectImpl;
import com.flying.email.factory.ConnectionFactory;

/**
 * auth:flying date:2017年7月25日
 **/
public class MainSubjectService {

	//// 数据操作接口
	private IMainSubject iMainSubject = null;

	/**
	 * 构造函数
	 */
	public MainSubjectService() {
		this.iMainSubject = new MainSubjectImpl();
	}

	/**
	 * 获取当前所有有效的主项目
	 * 
	 * @return
	 */
	public List<MainSubject> GetAllMainSubjec() {
		return this.iMainSubject.getMainSubjectList(ConnectionFactory.getConnection(),
				" isforbidden=0  order by mainlevel desc ");
	}

	/**
	 * 执行主任务
	 * 
	 * @param mainSubject
	 * @return
	 */
	public boolean ExecuteMainsubject(MainSubject mainSubject) {
		boolean flag = false;
		if (mainSubject != null) {
			//// 获取项目的操作入口
			SubjectService subjectService = new SubjectService();
			List<Subject> listsubject = subjectService.getSubjectByMainSubjectId(mainSubject.getKeyId());
			if (listsubject != null && listsubject.size() > 0) {
				for (Subject subject : listsubject) {
					subjectService.executeSubject(subject);
				}
			}
		}

		return flag;
	}
}
