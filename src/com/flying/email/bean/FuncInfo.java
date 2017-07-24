package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * auth:flying date:2017年7月14日
 **/
public class FuncInfo implements java.io.Serializable {
	private Integer keyId;
	private String functionname;
	private String functioninfo;
	private int isforbidden;
	private int isdelete;
	private Date createTime;
	private String modifyUser;

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
	private static List<FuncInfo> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				ArrayList<FuncInfo> listfuncinfo = new ArrayList<FuncInfo>();
				while (resultSet.next()) {
					FuncInfo fuInfo = new FuncInfo();
					fuInfo.setKeyId(resultSet.getInt("keyid"));
					fuInfo.setFunctionname(resultSet.getString("functionname"));
					fuInfo.setFunctioninfo(resultSet.getString("functioninfo"));
					fuInfo.setIsforbidden(resultSet.getInt("isforbidden"));
					fuInfo.setIsdelete(resultSet.getInt("isdelete"));
					fuInfo.setCreateTime(resultSet.getDate("createTime"));
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
