package com.sds.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sds.vo.CartVO;

public abstract class Service<T,V> {
	private String id = "db";
	private String password = "db";
	private String url = "jdbc:oracle:thin:@70.12.110.173:1521:XE";
	
	public Service() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConn() throws SQLException{
		Connection con = null;
		con = DriverManager.getConnection(url, id, password);
		con.setAutoCommit(false);
		return con;
	}
	
	public void close(Connection con) throws SQLException {
		if(con != null) {
			con.close();
		}
	}
	
	public abstract void register(V v) throws Exception;
	public abstract void remove(T t) throws Exception;
	public abstract void modify(V v) throws Exception;
	public abstract V get(T t) throws Exception;
	public abstract ArrayList<V> get() throws Exception;
}
