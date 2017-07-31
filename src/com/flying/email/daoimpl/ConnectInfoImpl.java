package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flying.email.bean.ConnectInfo;
import com.flying.email.dao.IConnectinfo;

/**
 * auth:flying date:2017年7月27日
 **/
public class ConnectInfoImpl implements IConnectinfo {

	public ConnectInfo getConnectInfo(Connection connection, String condtion) {
		String sql = "select * from connectioninfo where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<ConnectInfo> lisetresult = ConnectInfo.TransFormModelList(resultSet);
			if (lisetresult != null && lisetresult.size() > 0) {
				return lisetresult.get(0);
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (!resultSet.isClosed()) {
					resultSet.close();
				}

				if (!prep.isClosed()) {
					prep.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ConnectInfo> getConnectInfoList(Connection connection, String condtion) {
		String sql = "select * from connectioninfo where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<ConnectInfo> lisetresult = ConnectInfo.TransFormModelList(resultSet);
			if (lisetresult != null && lisetresult.size() > 0) {
				return lisetresult;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (!resultSet.isClosed()) {
					resultSet.close();
				}

				if (!prep.isClosed()) {
					prep.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
