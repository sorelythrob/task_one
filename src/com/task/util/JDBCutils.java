package com.task.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JDBCutils {
	
private static DataSource dataSource;


static {
	try {
	Properties properties = new Properties();
	InputStream is = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
		properties.load(is);
		dataSource = DruidDataSourceFactory.createDataSource(properties);
		
	}  catch (Exception e) {
		e.printStackTrace();
	}
}

public static Connection getConnection() {
	Connection connection =null;
	try {
	 connection = dataSource.getConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connection;
	
}

public static void close(Connection connection) {
	try {
		if(connection!=null) {
		connection.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}


	
}
