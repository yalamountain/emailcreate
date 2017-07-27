package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.flying.email.bean.SubjectItems;
import com.flying.email.dao.ISubjectItems;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectItemsImpl implements ISubjectItems {

	@Override
	public SubjectItems getSubjectItems(Connection connection, String condtion) {
		String sql = "select * from subjectitems where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<SubjectItems> lisetresult = SubjectItems.TransFormModelList(resultSet);
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
	public List<SubjectItems> getSubjectItemsList(Connection connection, String condtion) {
		String sql = "select * from subjectitems where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<SubjectItems> lisetresult = SubjectItems.TransFormModelList(resultSet);
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
	public int insertIntoTable(Connection connection, SubjectItems subjectitems) {
		String sql = " insert into subjectitems(subjectid,execution,dataparam,functionname,isforbidden,isdelete,createtime) values(?,?,?,?"
				+ ",?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, subjectitems.getSubjectid());
			preparedStatement.setInt(2, subjectitems.getExecution());
			preparedStatement.setString(3, subjectitems.getDataparam());
			preparedStatement.setString(4, subjectitems.getFunctionname());
			preparedStatement.setInt(5, subjectitems.getIsforbidden());
			preparedStatement.setInt(6, subjectitems.getIsdelete());
			preparedStatement.setTimestamp(7, (Timestamp) subjectitems.getCreateTime());
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
	public int insetIntoTbableList(Connection connection, List<SubjectItems> listsubjectitems) {
		String sql = " insert into subjectitems(subjectid,execution,dataparam,functionname,isforbidden,isdelete,createtime) values(?,?,?,?"
				+ ",?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			for (SubjectItems subjectitems : listsubjectitems) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, subjectitems.getSubjectid());
				preparedStatement.setInt(2, subjectitems.getExecution());
				preparedStatement.setString(3, subjectitems.getDataparam());
				preparedStatement.setString(4, subjectitems.getFunctionname());
				preparedStatement.setInt(5, subjectitems.getIsforbidden());
				preparedStatement.setInt(6, subjectitems.getIsdelete());
				preparedStatement.setTimestamp(7, (Timestamp) subjectitems.getCreateTime());
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
	public int updateSubjectItems(Connection connection, SubjectItems subjectitems) {
		String sql = " update  subjectitems set subjectid=?,execution=?,dataparam=?,functionname=?,isforbidden=?,isdelete=?,createtime=?,modifyuser=? where keyid=? ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, subjectitems.getSubjectid());
			preparedStatement.setInt(2, subjectitems.getExecution());
			preparedStatement.setString(3, subjectitems.getDataparam());
			preparedStatement.setString(4, subjectitems.getFunctionname());
			preparedStatement.setInt(5, subjectitems.getIsforbidden());
			preparedStatement.setInt(6, subjectitems.getIsdelete());
			preparedStatement.setTimestamp(7, (Timestamp) subjectitems.getCreateTime());
			preparedStatement.setString(8, subjectitems.getModifyUser());
			preparedStatement.setInt(9, subjectitems.getKeyId());
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
