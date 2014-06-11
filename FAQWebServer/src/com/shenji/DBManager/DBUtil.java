package com.shenji.DBManager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.shenji.common.Common;
import com.shenji.log.WriteLog;

public class DBUtil {

	private String drivename="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://"+Common.dbIP+"/"+Common.dbName+"?autoReconnect=true&characterEncoding=utf8";
	private String user=Common.user;
	private String password=Common.password; 
	Connection connection=null;
	
	public DBUtil(){
		try {
			Class.forName(drivename);
			connection=DriverManager.getConnection(url, user, password);
			if(!connection.isClosed()){
				System.out.println("Successed connecting to the Database!");
			}
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBUtil.class.getName());
		} 		
	}
		
	public void close(){
		try {
			if(connection!=null){
				connection.close();
				System.out.println("Successed close the Database!");
			}
				
		} catch (SQLException e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBUtil.class.getName());
		}
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return connection;
	}
	
}
