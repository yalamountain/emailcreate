package com.flying.email.bean;

import java.util.Date;

/**
 * auth:flying date:2017年7月14日
 **/
public class EmailContent implements java.io.Serializable {
	private Integer keyId;
	private int emailto;
	private byte ccto;
	private String emailsubject;
	private byte emailtype;
	private String attachment;
	private int subjectlevel;
	private byte issened;
	private byte islock;
	private Date locktime;
	private byte isdelete;
	private Date createTime;
	private String modifyUser;
	private Date modifyTime;

	public EmailContent() {
	}

	public EmailContent(int emailto, byte ccto, String emailsubject, byte emailtype, String attachment,
			int subjectlevel, byte issened, byte islock, Date locktime, byte isdelete, String modifyUser,
			Date modifyTime) {
		this.emailto = emailto;
		this.ccto = ccto;
		this.emailsubject = emailsubject;
		this.emailtype = emailtype;
		this.attachment = attachment;
		this.subjectlevel = subjectlevel;
		this.issened = issened;
		this.islock = islock;
		this.locktime = locktime;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
	}

	public EmailContent(int emailto, byte ccto, String emailsubject, byte emailtype, String attachment,
			int subjectlevel, byte issened, byte islock, Date locktime, byte isdelete, Date createTime,
			String modifyUser, Date modifyTime) {
		this.emailto = emailto;
		this.ccto = ccto;
		this.emailsubject = emailsubject;
		this.emailtype = emailtype;
		this.attachment = attachment;
		this.subjectlevel = subjectlevel;
		this.issened = issened;
		this.islock = islock;
		this.locktime = locktime;
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

	public int getEmailto() {
		return this.emailto;
	}

	public void setEmailto(int emailto) {
		this.emailto = emailto;
	}

	public byte getCcto() {
		return this.ccto;
	}

	public void setCcto(byte ccto) {
		this.ccto = ccto;
	}

	public String getEmailsubject() {
		return this.emailsubject;
	}

	public void setEmailsubject(String emailsubject) {
		this.emailsubject = emailsubject;
	}

	public byte getEmailtype() {
		return this.emailtype;
	}

	public void setEmailtype(byte emailtype) {
		this.emailtype = emailtype;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getSubjectlevel() {
		return this.subjectlevel;
	}

	public void setSubjectlevel(int subjectlevel) {
		this.subjectlevel = subjectlevel;
	}

	public byte getIssened() {
		return this.issened;
	}

	public void setIssened(byte issened) {
		this.issened = issened;
	}

	public byte getIslock() {
		return this.islock;
	}

	public void setIslock(byte islock) {
		this.islock = islock;
	}

	public Date getLocktime() {
		return this.locktime;
	}

	public void setLocktime(Date locktime) {
		this.locktime = locktime;
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
