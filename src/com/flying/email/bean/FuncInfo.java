package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

/**
 * auth:flying date:2017年7月14日
 **/
@SuppressWarnings("serial")
public class FuncInfo implements java.io.Serializable {
	private Integer keyId = 0;
	private String functionname = "";
	private String functioninfo = "";
	private String classname = "";
	private int isforbidden = 0;
	private int isdelete = 0;
	private Date createTime = new Date(-2209017600000L);
	private String modifyUser = "";

	public FuncInfo() {
	}

	public FuncInfo(String functionname, String functioninfo, int isforbidden, int isdelete, String modifyUser) {
		this.functionname = functionname;
		this.functioninfo = functioninfo;
		this.isforbidden = isforbidden;
		this.isdelete = isdelete;
		this.modifyUser = modifyUser;
	}

	public FuncInfo(String functionname, String functioninfo, int isforbidden, int isdelete, Date createTime,
			String modifyUser) {
		this.functionname = functionname;
		this.functioninfo = functioninfo;
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

	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getClassName() {
		return this.classname;
	}

	public void setClassName(String classname) {
		this.classname = classname;
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

	/**
	 * 
	 * @param resultSet
	 * @return
	 */
	public static LinkedList<FuncInfo> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				LinkedList<FuncInfo> listfuncinfo = new LinkedList<FuncInfo>();
				while (resultSet.next()) {
					FuncInfo fuInfo = new FuncInfo();
					fuInfo.setKeyId(resultSet.getInt("keyid"));
					fuInfo.setFunctionname(resultSet.getString("functionname"));
					fuInfo.setFunctioninfo(resultSet.getString("functioninfo"));
					fuInfo.setClassName(resultSet.getString("classname"));
					fuInfo.setIsforbidden(resultSet.getInt("isforbidden"));
					fuInfo.setIsdelete(resultSet.getInt("isdelete"));
					fuInfo.setCreateTime(resultSet.getTimestamp("createTime"));
					fuInfo.setModifyUser(resultSet.getString("modifyUser"));
					listfuncinfo.add(fuInfo);
				}

				return listfuncinfo;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
