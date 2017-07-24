package com.flying.email.factory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

import com.flying.email.util.Encrypt;

/**
 * auth:flying date:2017年7月14日
 **/
public class ConnectionFactory {
	private Connection connection = null;

	/**
	 * 构造函数,初始化数据库连接
	 * 
	 * @throws Exception
	 */
	public ConnectionFactory() throws Exception {
		this.connection = this.getEamilConnection();
	}

	/**
	 * 创建数据库链接，获取链接
	 * 
	 * @author flying
	 * @return 返回数据库链接
	 * @throws Exception
	 *             链接获取错误，文件读取错误
	 */
	private Connection getEamilConnection() throws Exception {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String username = properties.getProperty("user").trim();
		String password = Encrypt.aesDecrypt(properties.getProperty("password").trim());
		String jdbcurl = properties.getProperty("jdbcUrl").trim();
		String drivercalss = properties.getProperty("driver").trim();
		Driver driver = (Driver) Class.forName(drivercalss).newInstance();
		Properties dbinfo = new Properties();
		dbinfo.setProperty("user", username);
		dbinfo.setProperty("password", password);
		Connection connection = driver.connect(jdbcurl, properties);
		return connection;
	}

	/**
	 * Get
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		return connection;
	}

}
