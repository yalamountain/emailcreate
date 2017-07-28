package com.flying.email.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

/**
 * auth:flying date:2017年7月27日
 **/
@SuppressWarnings("serial")
public class ConnectInfo implements java.io.Serializable {
	private int keyid = 0;
	private String connectaccount = "";
	private String connectname = "";
	private String useraccount = "";
	private String userpassword = "";
	private String ipaddress = "";
	private String databasename = "";
	private Date createtime = new Date();
	private String modifyUser = "";

	/**
	 * 无参构造函数
	 */
	public ConnectInfo() {
	}

	public ConnectInfo(int keyid, String connectaccount, String connectname, String useraccount, String userpassword,
			String ipaddress, Date createtime, String modifyUser) {
		super();
		this.keyid = keyid;
		this.connectaccount = connectaccount;
		this.connectname = connectname;
		this.useraccount = useraccount;
		this.userpassword = userpassword;
		this.ipaddress = ipaddress;
		this.createtime = createtime;
		this.modifyUser = modifyUser;
	}

	public int getKeyid() {
		return keyid;
	}

	public void setKeyid(int keyid) {
		this.keyid = keyid;
	}

	public String getConnectaccount() {
		return connectaccount;
	}

	public void setConnectaccount(String connectaccount) {
		this.connectaccount = connectaccount;
	}

	public String getConnectname() {
		return connectname;
	}

	public void setConnectname(String connectname) {
		this.connectname = connectname;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getDataBaseName() {
		return databasename;
	}

	public void setDataBaseName(String databasename) {
		this.databasename = databasename;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getModifyUser() {
		return modifyUser;
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
	public static LinkedList<ConnectInfo> TransFormModelList(ResultSet resultSet) {
		try {
			if (resultSet.wasNull()) {
				return null;
			} else {
				LinkedList<ConnectInfo> listcontent = new LinkedList<ConnectInfo>();
				while (resultSet.next()) {
					ConnectInfo connectInfo = new ConnectInfo();
					connectInfo.setKeyid(resultSet.getInt("KeyID"));
					connectInfo.setConnectaccount(resultSet.getString("connectaccount"));
					connectInfo.setConnectname(resultSet.getString("connectname"));
					connectInfo.setUseraccount(resultSet.getString("useraccount"));
					connectInfo.setUserpassword(resultSet.getString("userpassword"));
					connectInfo.setIpaddress(resultSet.getString("ipaddress"));
					connectInfo.setDataBaseName(resultSet.getString("databasename"));
					connectInfo.setCreatetime(resultSet.getTimestamp("createTime"));
					connectInfo.setModifyUser(resultSet.getString("modifyUser"));
					listcontent.add(connectInfo);
				}

				return listcontent;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
