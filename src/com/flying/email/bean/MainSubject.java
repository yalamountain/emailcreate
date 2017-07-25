package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * auth:flying date:2017年7月14日
 **/
public class MainSubject implements java.io.Serializable {
	private Integer keyId;
	private String subjectname;
	private int isforbidden;
	private int isdelete;
	private Date createTime;
	private String modifyUser;

	public MainSubject() {
	}

	public MainSubject(String subjectname, int isforbidden, int isdelete, String modifyUser) {
		this.subjectname = subjectname;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
	}

	public MainSubject(String subjectname, int isforbidden, int isdelete, Date createTime, String modifyUser) {
		this.subjectname = subjectname;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
	}

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getIsforbidden() {
		return this.isforbidden;
	}

	public void setIsforbidden(int isforbidden) {
		this.isforbidden = isforbidden;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	/**
	 * 
	 * @param resultSet
	 * @return
	 */
	public static List<MainSubject> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				ArrayList<MainSubject> listmainsubject = new ArrayList<MainSubject>();
				while (resultSet.next()) {
					MainSubject mainSubject = new MainSubject();
					mainSubject.setKeyId(resultSet.getInt("keyid"));
					mainSubject.setSubjectname(resultSet.getString("subjectname"));
					mainSubject.setIsforbidden(resultSet.getInt("isforbidden"));
					mainSubject.setIsdelete(resultSet.getInt("isdelete"));
					mainSubject.setCreateTime(resultSet.getDate("createTime"));
					mainSubject.setModifyUser(resultSet.getString("modifyUser"));
					listmainsubject.add(mainSubject);
				}

				return listmainsubject;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
