package com.flying.email.bean;

import java.util.Date;

/**
 * auth:flying date:2017年7月14日
 **/
public class FuncInfo  implements java.io.Serializable {
	private Integer keyId;
	private String functionname;
	private String functioninfo;
	private int isforbidden;
	private int isdelete;
	private Date createTime;
	private String modifyUser;
	private Date modifyTime;

	public FuncInfo() {
	}

	public FuncInfo(String functionname, String functioninfo, int isforbidden, int isdelete, String modifyUser,
			Date modifyTime) {
		this.functionname = functionname;
		this.functioninfo = functioninfo;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
	}

	public FuncInfo(String functionname, String functioninfo, int isforbidden, int isdelete, Date createTime,
			String modifyUser, Date modifyTime) {
		this.functionname = functionname;
		this.functioninfo = functioninfo;
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

	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getFunctioninfo() {
		return this.functioninfo;
	}

	public void setFunctioninfo(String functioninfo) {
		this.functioninfo = functioninfo;
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

}
