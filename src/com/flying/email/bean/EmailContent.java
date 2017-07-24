package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.ElementIterator;

/**
 * auth:flying date:2017年7月14日
 **/
@SuppressWarnings("serial")
public class EmailContent implements java.io.Serializable {
	private Integer keyId;
	private String emailto;
	private String ccto;
	private String emailsubject;
	private int emailtype;
	private String attachment;
	private int subjectlevel;
	private int issened;
	private int islock;
	private Date locktime;
	private int isdelete;
	private Date createTime;
	private String modifyUser;

	public EmailContent() {
	}

	public EmailContent(String emailto, String ccto, String emailsubject, int emailtype, String attachment,
			int subjectlevel, int issened, int islock, Date locktime, int isdelete, String modifyUser) {
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
	}

	public EmailContent(String emailto, String ccto, String emailsubject, int emailtype, String attachment,
			int subjectlevel, int issened, int islock, Date locktime, int isdelete, Date createTime,
			String modifyUser) {
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
	}

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public String getEmailto() {
		return this.emailto;
	}

	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}

	public String getCcto() {
		return this.ccto;
	}

	public void setCcto(String ccto) {
		this.ccto = ccto;
	}

	public String getEmailsubject() {
		return this.emailsubject;
	}

	public void setEmailsubject(String emailsubject) {
		this.emailsubject = emailsubject;
	}

	public int getEmailtype() {
		return this.emailtype;
	}

	public void setEmailtype(int emailtype) {
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

	public int getIssened() {
		return this.issened;
	}

	public void setIssened(int issened) {
		this.issened = issened;
	}

	public int getIslock() {
		return this.islock;
	}

	public void setIslock(int islock) {
		this.islock = islock;
	}

	public Date getLocktime() {
		return this.locktime;
	}

	public void setLocktime(Date locktime) {
		this.locktime = locktime;
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
	public static List<EmailContent> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				ArrayList<EmailContent> listcontent = new ArrayList<EmailContent>();
				while (resultSet.next()) {
					EmailContent emailContent = new EmailContent();
					emailContent.setKeyId(resultSet.getInt("keyid"));
					emailContent.setEmailto(resultSet.getString("emailto"));
					emailContent.setCcto(resultSet.getString("ccto"));
					emailContent.setEmailsubject(resultSet.getString("emailsubject"));
					emailContent.setEmailtype(resultSet.getInt("emailtype"));
					emailContent.setAttachment(resultSet.getString("attachment"));
					emailContent.setSubjectlevel(resultSet.getInt("subjectlevel"));
					emailContent.setIssened(resultSet.getInt("issend"));
					emailContent.setIslock(resultSet.getInt("islock"));
					emailContent.setIsdelete(resultSet.getInt("isdelete"));
					emailContent.setCreateTime(resultSet.getDate("createTime"));
					emailContent.setModifyUser(resultSet.getString("modifyUser"));
					listcontent.add(emailContent);
				}

				return listcontent;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
