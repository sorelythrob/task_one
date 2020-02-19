package com.task.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.task.util.JDBCutils;
public class BaseDao<T> {
	
	private QueryRunner queryRunner=new QueryRunner();
	private Class<T> type;
	public BaseDao() {
		Class clazz = this.getClass();
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		this.type = (Class<T>) types[0];
	}
	
	
	public int update(String sql,Object... params) {
		Connection connection = JDBCutils.getConnection();
		int count = 0;
		try {
			count = queryRunner.update(connection, sql, params);
		} catch (Exception e) {
			//e.printStackTrace();
		}finally {
			JDBCutils.close(connection);
		}
		
		return count;	
	}
	
	public T getBean(String sql,Object... params) {
		Connection connection = JDBCutils.getConnection();
		T query =null;
		try {
			query = queryRunner.query(connection, sql, new BeanHandler<T>(type),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutils.close(connection);
		}
		return query;
		
	}
	

	
	public List<T> getBeanList(String sql,Object... params) {
		
		Connection connection = JDBCutils.getConnection();
		List<T> query =null;
		try {
			query = queryRunner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutils.close(connection);
		}
		return query;
		
	}
	
	

}
