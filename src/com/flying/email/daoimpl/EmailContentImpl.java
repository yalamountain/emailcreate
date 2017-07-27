package com.flying.email.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.flying.email.bean.EmailContent;
import com.flying.email.dao.IEmailContent;

/**
 * auth:flying date:2017年7月18日
 **/
public class EmailContentImpl implements IEmailContent {

	@Override
	public EmailContent getEailContent(Connection connection, String condtion) {
		String sql = "select * from emailcontent where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			List<EmailContent> lisetresult = EmailContent.TransFormModelList(resultSet);
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
	public List<EmailContent> getEailContentList(Connection connection, String condtion) {
		String sql = "select * from emailcontent where isdelete=0 ";
		if (condtion.isEmpty() || condtion == null) {

		} else {
			sql = sql + " and " + condtion;
		}

		PreparedStatement prep = null;
		ResultSet resultSet = null;
		try {
			prep = connection.prepareStatement(sql);
			resultSet = prep.executeQuery();
			return EmailContent.TransFormModelList(resultSet);
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
	public int insertIntoTable(Connection connection, EmailContent emailContent) {
		String sql = " insert into emailcontent(emailto,ccto,emailsubject,emailtype,attachemt,subjectlevel,issend,islock,locktime,isdelete,createtime) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, emailContent.getEmailto());
			preparedStatement.setString(2, emailContent.getCcto());
			preparedStatement.setString(3, emailContent.getEmailsubject());
			preparedStatement.setInt(4, emailContent.getEmailtype());
			preparedStatement.setString(5, emailContent.getAttachment());
			preparedStatement.setInt(6, emailContent.getSubjectlevel());
			preparedStatement.setInt(7, emailContent.getIssened());
			preparedStatement.setInt(8, emailContent.getIslock());
			preparedStatement.setTimestamp(9, (Timestamp) emailContent.getLocktime());
			preparedStatement.setInt(10, emailContent.getIsdelete());
			preparedStatement.setTimestamp(11, (Timestamp) emailContent.getCreateTime());
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
	public int insetIntoTbableList(Connection connection, List<EmailContent> listemailcontent) {
		String sql = " insert into emailcontent(emailto,ccto,emailsubject,emailtype,attachemt,subjectlevel,issend,islock,locktime,isdelete,createtime) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			for (EmailContent emailContent : listemailcontent) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, emailContent.getEmailto());
				preparedStatement.setString(2, emailContent.getCcto());
				preparedStatement.setString(3, emailContent.getEmailsubject());
				preparedStatement.setInt(4, emailContent.getEmailtype());
				preparedStatement.setString(5, emailContent.getAttachment());
				preparedStatement.setInt(6, emailContent.getSubjectlevel());
				preparedStatement.setInt(7, emailContent.getIssened());
				preparedStatement.setInt(8, emailContent.getIslock());
				preparedStatement.setTimestamp(9, (Timestamp) emailContent.getLocktime());
				preparedStatement.setInt(10, emailContent.getIsdelete());
				preparedStatement.setTimestamp(11, (Timestamp) emailContent.getCreateTime());
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
	public int updateEmailContent(Connection connection, EmailContent emailContent) {
		String sql = " update emailcontent set emailto=?,ccto=?,emailsubject=?,emailtype=?,attachment=?,subjectlevel=?,issend=?,islock=?,locktime=?,isdelete=?,createTime=?,modifyuser=? where keyid=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, emailContent.getEmailto());
			preparedStatement.setString(2, emailContent.getCcto());
			preparedStatement.setString(3, emailContent.getEmailsubject());
			preparedStatement.setInt(4, emailContent.getEmailtype());
			preparedStatement.setString(5, emailContent.getAttachment());
			preparedStatement.setInt(6, emailContent.getSubjectlevel());
			preparedStatement.setInt(7, emailContent.getIssened());
			preparedStatement.setInt(8, emailContent.getIslock());
			preparedStatement.setTimestamp(9, (Timestamp) emailContent.getLocktime());
			preparedStatement.setInt(10, emailContent.getIsdelete());
			preparedStatement.setTimestamp(11, (Timestamp) emailContent.getCreateTime());
			preparedStatement.setInt(12, emailContent.getKeyId());
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
