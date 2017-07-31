package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flying.email.bean.FuncInfo;
import com.flying.email.dao.IFuncInfo;

/**
 * auth:flying date:2017年7月25日
 **/
public class FuncInfoImpl implements IFuncInfo {

	@Override
	public FuncInfo getFuncInfo(Connection connection, String condtion) {
		String sql = "select * from funcinfo where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<FuncInfo> lisetresult = FuncInfo.TransFormModelList(resultSet);
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
	public List<FuncInfo> getFuncInfoList(Connection connection, String condtion) {
		String sql = "select * from funcinfo where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<FuncInfo> lisetresult = FuncInfo.TransFormModelList(resultSet);
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

				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertIntoTable(Connection connection, FuncInfo funcInfo) {
		String sql = " insert into funcinfo(functionname,functioninfo,isforbidden,isdelete,createTime) values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcInfo.getFunctionname());
			preparedStatement.setString(2, funcInfo.getFunctioninfo());
			preparedStatement.setInt(3, funcInfo.getIsforbidden());
			preparedStatement.setInt(4, funcInfo.getIsdelete());
			preparedStatement.setTimestamp(5, new java.sql.Timestamp(funcInfo.getCreateTime().getTime()));
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int insetIntoTbableList(Connection connection, List<FuncInfo> listfuncinfo) {
		String sql = " insert into funcinfo(functionname,functioninfo,isforbidden,isdelete,createTime) values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			for (FuncInfo funcInfo : listfuncinfo) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, funcInfo.getFunctionname());
				preparedStatement.setString(2, funcInfo.getFunctioninfo());
				preparedStatement.setInt(3, funcInfo.getIsforbidden());
				preparedStatement.setInt(4, funcInfo.getIsdelete());
				preparedStatement.setTimestamp(5, new java.sql.Timestamp(funcInfo.getCreateTime().getTime()));
				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch().length;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int updateMainSubject(Connection connection, FuncInfo funcInfo) {
		String sql = " update funcinfo set functionname=?,functioninfo=?,isforbidden=?,isdelete=?,createTime=?,modifytime=? where keyid=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, funcInfo.getFunctionname());
			preparedStatement.setString(2, funcInfo.getFunctioninfo());
			preparedStatement.setInt(3, funcInfo.getIsforbidden());
			preparedStatement.setInt(4, funcInfo.getIsdelete());
			preparedStatement.setTimestamp(5, new java.sql.Timestamp(funcInfo.getCreateTime().getTime()));
			preparedStatement.setString(6, funcInfo.getModifyUser());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public boolean executeSql(Connection connection, String sql) {
		if (sql == null || sql.isEmpty()) {
			return false;
		}

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			return preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}
}
