package com.flying.email.bean;

import java.util.Date;

/**
 * auth:flying date:2017年7月14日
 **/
public class SubjectItems {
	private Integer keyId;
	private int subjectid;
	private int execution;
	private String dataparam;
	private String functionname;
	private int isforbidden;
	private int isdelete;
	private Date createTime;
	private String modifyUser;
	private Date modifyTime;

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

	public void setExecution(byte execution) {
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

	public void setIsforbidden(byte isforbidden) {
		this.isforbidden = isforbidden;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(byte isdelete) {
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

}
