package com.flying.email.action;

import java.util.List;
import com.flying.email.bean.MainSubject;
import com.flying.email.service.MainSubjectService;

/**
 * auth:flying date:2017年7月25日
 **/
public class MainExecute {

	/**
	 * 主函数,执行入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Begin Analysis");
		while (true) {
			MainSubjectService mainSubjectService = new MainSubjectService();
			List<MainSubject> listmainsubject = mainSubjectService.GetAllMainSubjec();
			if (listmainsubject == null || listmainsubject.size() == 0) {
				//// 如果当前没有需要分析的项目，则休眠10S
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				//// 依次遍历每一个主项目
				for (MainSubject mainSubject : listmainsubject) {
					mainSubjectService.ExecuteMainsubject(mainSubject);
				}
			}
		}
	}
}
