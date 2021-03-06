package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

/**
 * auth:flying date:2017年7月14日
 **/
@SuppressWarnings("serial")
public class SubjectItems implements java.io.Serializable {
	private Integer keyId = 0;
	private int subjectid = 0;
	private int execution = 0;
	private String dataparam = "";
	private String functionname = "";
	private int isforbidden = 0;
	private int isdelete = 0;
	private Date createTime = new Date(-2209017600000L);
	private String modifyUser = "";
	private Date modifyTime = new Date(-2209017600000L);

	public SubjectItems() {
	}

	public SubjectItems(int subjectid, int execution, String dataparam, String functionname, int isforbidden,
			int isdelete, String modifyUser, Date modifyTime) {
		this.subjectid = subjectid;
		this.execution = execution;
		this.dataparam = dataparam;
		this.functionname = functionname;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
	}

	public SubjectItems(int subjectid, int execution, String dataparam, String functionname, int isforbidden,
			int isdelete, Date createTime, String modifyUser, Date modifyTime) {
		this.subjectid = subjectid;
		this.execution = execution;
		this.dataparam = dataparam;
		this.functionname = functionname;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.createTime = createTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
	}

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public int getSubjectid() {
		return this.subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public int getExecution() {
		return this.execution;
	}

	public void setExecution(int execution) {
		this.execution = execution;
	}

	public String getDataparam() {
		return this.dataparam;
	}

	public void setDataparam(String dataparam) {
		this.dataparam = dataparam;
	}

	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
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

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 将数据结果转化为model
	 * 
	 * @param resultSet
	 * @return
	 */
	public static LinkedList<SubjectItems> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				LinkedList<SubjectItems> listsubjectitems = new LinkedList<SubjectItems>();
				while (resultSet.next()) {
					SubjectItems subjectitems = new SubjectItems();
					subjectitems.setKeyId(resultSet.getInt("keyid"));
					subjectitems.setSubjectid(resultSet.getInt("subjectid"));
					subjectitems.setExecution(resultSet.getInt("execution"));
					subjectitems.setDataparam(resultSet.getString("dataparam"));
					subjectitems.setFunctionname(resultSet.getString("functionname"));
					subjectitems.setIsforbidden(resultSet.getInt("isforbidden"));
					subjectitems.setIsdelete(resultSet.getInt("isdelete"));
					subjectitems.setCreateTime(resultSet.getTimestamp("createTime"));
					subjectitems.setModifyUser(resultSet.getString("modifyUser"));
					listsubjectitems.add(subjectitems);
				}

				return listsubjectitems;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
