package com.flying.email.bean;

import java.util.Date;

/**
 * auth:flying
 * date:2017年7月14日
 **/
public class Subject {
	private Integer keyId;
	private int mainsubjectid;
	private String subjectname;
	private byte datacycle;
	private byte emailtype;
	private Date delayTime;
	private Date dataDateTime;
	private int subjectlevel;
	private byte isforbidden;
	private byte isdelete;
	private Date createTime;
	private String modifyUser;
	private Date modifyTime;

	public Subject() {
	}

	public Subject(int mainsubjectid, String subjectname, byte datacycle, byte emailtype, Date delayTime,
			Date dataDateTime, int subjectlevel, byte isforbidden, byte isdelete, String modifyUser, Date modifyTime) {
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
		this.modifyTime = modifyTime;
	}

	public Subject(int mainsubjectid, String subjectname, byte datacycle, byte emailtype, Date delayTime,
			Date dataDateTime, int subjectlevel, byte isforbidden, byte isdelete, Date createTime, String modifyUser,
			Date modifyTime) {
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
		this.modifyTime = modifyTime;
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

	public byte getDatacycle() {
		return this.datacycle;
	}

	public void setDatacycle(byte datacycle) {
		this.datacycle = datacycle;
	}

	public byte getEmailtype() {
		return this.emailtype;
	}

	public void setEmailtype(byte emailtype) {
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

	public byte getIsforbidden() {
		return this.isforbidden;
	}

	public void setIsforbidden(byte isforbidden) {
		this.isforbidden = isforbidden;
	}

	public byte getIsdelete() {
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
