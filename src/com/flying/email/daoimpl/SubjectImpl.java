package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flying.email.bean.MainSubject;
import com.flying.email.bean.Subject;
import com.flying.email.dao.ISubject;

/**
 * auth:flying date:2017年7月25日
 **/
public class SubjectImpl implements ISubject {

	@Override
	public Subject getSubject(Connection connection, String condtion) {
		String sql = "select * from subject where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<Subject> lisetresult = Subject.TransFormModelList(resultSet);
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
	public List<Subject> getSubjectList(Connection connection, String condtion) {
		String sql = "select * from subject where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<Subject> lisetresult = Subject.TransFormModelList(resultSet);
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
	public int insertIntoTable(Connection connection, Subject subject) {
		String sql = " insert into subject(mainsubjectid,subjectname,datacycle,emailtype,DelayTime,DataDateTime,subjectlevel,isforbidden,isdelete,createtime) values(?,?,?,?"
				+ ",?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, subject.getMainsubjectid());
			preparedStatement.setString(2, subject.getSubjectname());
			preparedStatement.setInt(3, subject.getDatacycle());
			preparedStatement.setInt(4, subject.getEmailtype());
			preparedStatement.setDate(5, (java.sql.Date) subject.getDelayTime());
			preparedStatement.setDate(6, (java.sql.Date) subject.getDataDateTime());
			preparedStatement.setInt(7, subject.getSubjectlevel());
			preparedStatement.setInt(8, subject.getIsforbidden());
			preparedStatement.setInt(9, subject.getIsdelete());
			preparedStatement.setDate(10, (java.sql.Date) subject.getCreateTime());
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
	public int insetIntoTbableList(Connection connection, List<Subject> listsubject) {
		String sql = " insert into subject(mainsubjectid,subjectname,datacycle,emailtype,DelayTime,DataDateTime,subjectlevel,isforbidden,isdelete,createtime) values(?,?,?,?"
				+ ",?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			for (Subject subject : listsubject) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, subject.getMainsubjectid());
				preparedStatement.setString(2, subject.getSubjectname());
				preparedStatement.setInt(3, subject.getDatacycle());
				preparedStatement.setInt(4, subject.getEmailtype());
				preparedStatement.setDate(5, (java.sql.Date) subject.getDelayTime());
				preparedStatement.setDate(6, (java.sql.Date) subject.getDataDateTime());
				preparedStatement.setInt(7, subject.getSubjectlevel());
				preparedStatement.setInt(8, subject.getIsforbidden());
				preparedStatement.setInt(9, subject.getIsdelete());
				preparedStatement.setDate(10, (java.sql.Date) subject.getCreateTime());
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
	public int updateSubject(Connection connection, Subject subject) {
		String sql = " update subject set mainsubjectid=?,subjectname=?,datacycle=?,emailtype=?,DelayTime=?,DataDateTime=?,subjectlevel=?,isforbidden=?,isdelete=?,createtime=?,modifyuser=? where keyid=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, subject.getMainsubjectid());
			preparedStatement.setString(2, subject.getSubjectname());
			preparedStatement.setInt(3, subject.getDatacycle());
			preparedStatement.setInt(4, subject.getEmailtype());
			preparedStatement.setDate(5, (java.sql.Date) subject.getDelayTime());
			preparedStatement.setDate(6, (java.sql.Date) subject.getDataDateTime());
			preparedStatement.setInt(7, subject.getSubjectlevel());
			preparedStatement.setInt(8, subject.getIsforbidden());
			preparedStatement.setInt(9, subject.getIsdelete());
			preparedStatement.setDate(10, (java.sql.Date) subject.getCreateTime());
			preparedStatement.setString(11, subject.getModifyUser());
			preparedStatement.setInt(12, subject.getKeyId());
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
