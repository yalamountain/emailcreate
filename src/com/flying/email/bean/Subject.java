package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

/**
 * auth:flying date:2017年7月14日
 **/
@SuppressWarnings("serial")
public class Subject implements java.io.Serializable {
	private Integer keyId = 0;
	private int mainsubjectid = 0;
	private String subjectname = "";
	private int datacycle = 1;
	private int emailtype = 0;
	private Date delayTime = new Date(-2209017600000L);
	private Date dataDateTime = new Date(-2209017600000L);
	private Date runDateTime = new Date(-2209017600000L);
	private int subjectlevel = 0;
	private int isforbidden = 0;
	private int isdelete = 0;
	private Date createTime = new Date(-2209017600000L);
	private String modifyUser = "";

	public Subject() {
	}

	public Subject(int mainsubjectid, String subjectname, int datacycle, int emailtype, Date delayTime,
			Date dataDateTime, int subjectlevel, int isforbidden, int isdelete, String modifyUser) {
		this.mainsubjectid = mainsubjectid;
		this.subjectname = subjectname;
		this.datacycle = datacycle;
		this.emailtype = emailtype;
		this.delayTime = delayTime;
		this.dataDateTime = dataDateTime;
		this.subjectlevel = subjectlevel;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
	}

	public Subject(int mainsubjectid, String subjectname, int datacycle, int emailtype, Date delayTime,
			Date dataDateTime, int subjectlevel, int isforbidden, int isdelete, Date createTime, String modifyUser) {
		this.mainsubjectid = mainsubjectid;
		this.subjectname = subjectname;
		this.datacycle = datacycle;
		this.emailtype = emailtype;
		this.delayTime = delayTime;
		this.dataDateTime = dataDateTime;
		this.subjectlevel = subjectlevel;
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

	public int getMainsubjectid() {
		return this.mainsubjectid;
	}

	public void setMainsubjectid(int mainsubjectid) {
		this.mainsubjectid = mainsubjectid;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getDatacycle() {
		return this.datacycle;
	}

	public void setDatacycle(int datacycle) {
		this.datacycle = datacycle;
	}

	public int getEmailtype() {
		return this.emailtype;
	}

	public void setEmailtype(int emailtype) {
		this.emailtype = emailtype;
	}

	public Date getDelayTime() {
		return this.delayTime;
	}

	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
	}

	public Date getDataDateTime() {
		return this.dataDateTime;
	}

	public void setDataDateTime(Date dataDateTime) {
		this.dataDateTime = dataDateTime;
	}

	public Date getRunDateTime() {
		return this.runDateTime;
	}

	public void setRunDateTime(Date rundatetime) {
		this.runDateTime = rundatetime;
	}

	public int getSubjectlevel() {
		return this.subjectlevel;
	}

	public void setSubjectlevel(int subjectlevel) {
		this.subjectlevel = subjectlevel;
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
	 * 将数据结果转化为model
	 * 
	 * @param resultSet
	 * @return
	 */
	public static LinkedList<Subject> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				LinkedList<Subject> listsubject = new LinkedList<Subject>();
				while (resultSet.next()) {
					Subject subject = new Subject();
					subject.setKeyId(resultSet.getInt("keyid"));
					subject.setMainsubjectid(resultSet.getInt("mainsubjectid"));
					subject.setSubjectname(resultSet.getString("subjectname"));
					subject.setSubjectlevel(resultSet.getInt("subjectlevel"));
					subject.setDatacycle(resultSet.getInt("datacycle"));
					subject.setEmailtype(resultSet.getInt("emailtype"));
					subject.setDelayTime(resultSet.getTimestamp("delayTime"));
					subject.setDataDateTime(resultSet.getTimestamp("dataDateTime"));
					subject.setRunDateTime(resultSet.getTimestamp("rundatetime"));
					subject.setSubjectlevel(resultSet.getInt("subjectlevel"));
					subject.setIsforbidden(resultSet.getInt("isforbidden"));
					subject.setIsdelete(resultSet.getInt("isdelete"));
					subject.setCreateTime(resultSet.getTimestamp("createTime"));
					subject.setModifyUser(resultSet.getString("modifyUser"));
					listsubject.add(subject);
				}

				return listsubject;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
