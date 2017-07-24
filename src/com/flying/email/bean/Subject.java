package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * auth:flying date:2017年7月14日
 **/
public class Subject implements java.io.Serializable {
	private Integer keyId;
	private int mainsubjectid;
	private String subjectname;
	private int datacycle;
	private int emailtype;
	private Date delayTime;
	private Date dataDateTime;
	private int subjectlevel;
	private int isforbidden;
	private int isdelete;
	private Date createTime;
	private String modifyUser;

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
	public static List<Subject> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				ArrayList<Subject> listsubject = new ArrayList<Subject>();
				while (resultSet.next()) {
					Subject subject = new Subject();
					subject.setKeyId(resultSet.getInt("keyid"));
					subject.setMainsubjectid(resultSet.getInt("mainsubject"));
					subject.setSubjectname(resultSet.getString("subjectname"));
					subject.setSubjectlevel(resultSet.getInt("subjectlevel"));
					subject.setDatacycle(resultSet.getInt("datacycle"));
					subject.setDelayTime(resultSet.getDate("delayTime"));
					subject.setDataDateTime(resultSet.getDate("dataDateTime"));
					subject.setSubjectlevel(resultSet.getInt("subjectlevel"));
					subject.setIsforbidden(resultSet.getInt("isforbidden"));
					subject.setIsdelete(resultSet.getInt("isdelete"));
					subject.setCreateTime(resultSet.getDate("createTime"));
					subject.setModifyUser(resultSet.getString("modifyUser"));
					listsubject.add(subject);
				}

				return listsubject;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
