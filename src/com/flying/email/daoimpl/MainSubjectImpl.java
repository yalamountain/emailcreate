package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flying.email.bean.MainSubject;
import com.flying.email.dao.IMainSubject;

/**
 * auth:flying date:2017年7月25日
 **/
public class MainSubjectImpl implements IMainSubject {

	@Override
	public MainSubject getMainSubject(Connection connection, String condtion) {
		String sql = "select * from mainsubject where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<MainSubject> lisetresult = MainSubject.TransFormModelList(resultSet);
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
	public List<MainSubject> getMainSubjectList(Connection connection, String condtion) {
		String sql = "select * from mainsubject where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<MainSubject> lisetresult = MainSubject.TransFormModelList(resultSet);
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

	@Override
	public int insertIntoTable(Connection connection, MainSubject mainsubject) {
		String sql = " insert into mainsubject(subjectname,isforbidden,isdelete,createTime) values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mainsubject.getSubjectname());
			preparedStatement.setInt(2, mainsubject.getIsforbidden());
			preparedStatement.setInt(3, mainsubject.getIsdelete());
			preparedStatement.setTimestamp(4, new java.sql.Timestamp(mainsubject.getCreateTime().getTime()));
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
	public int insetIntoTbableList(Connection connection, List<MainSubject> listmainsubject) {
		String sql = " insert into mainsubject(subjectname,isforbidden,isdelete,createTime) values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			for (MainSubject mainsubject : listmainsubject) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, mainsubject.getSubjectname());
				preparedStatement.setInt(2, mainsubject.getIsforbidden());
				preparedStatement.setInt(3, mainsubject.getIsdelete());
				preparedStatement.setTimestamp(4, new java.sql.Timestamp(mainsubject.getCreateTime().getTime()));
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
	public int updateMainSubject(Connection connection, MainSubject mainsubject) {
		String sql = " update mainsubject set subjectname=?,isforbidden=?,isdelete=?,createTime=?,modifyUser=? where keyid=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mainsubject.getSubjectname());
			preparedStatement.setInt(2, mainsubject.getIsforbidden());
			preparedStatement.setInt(3, mainsubject.getIsdelete());
			preparedStatement.setTimestamp(4, new java.sql.Timestamp(mainsubject.getCreateTime().getTime()));
			preparedStatement.setString(5, mainsubject.getModifyUser());
			preparedStatement.setInt(6, mainsubject.getKeyId());
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
