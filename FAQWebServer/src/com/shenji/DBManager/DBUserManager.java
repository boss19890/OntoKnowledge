package com.shenji.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shenji.log.WriteLog;
import com.shenji.util.MD5Util;


public class DBUserManager {
	private java.sql.Connection connection;
	private DBUtil dbUtil;
	
	public DBUserManager(){
		this.dbUtil=new DBUtil();
		this.connection=dbUtil.getConnection();	
	}
	
	public void close(){
		if(dbUtil!=null)
			dbUtil.close();
	}
	public boolean isExistUserName(String userName){
		PreparedStatement preparedStatement=null;
		String sql="select * from tb_user where name=?";
		ResultSet resultSet=null;
		try {
			preparedStatement=this.connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);	
			resultSet=preparedStatement.executeQuery();
			System.err.println(resultSet.getRow());
			resultSet.last();
			if(resultSet.getRow()>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBUserManager.class.getName());
		}
		finally{		
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();		
			} catch (SQLException e) {
				WriteLog writeLog = new WriteLog();
				writeLog.Write(e.getMessage(),DBUserManager.class.getName());
			}			
		}
		//出错了!
		return true;
		
	}
	//1成功，-1用户名不存在，-2密码错误,-3该用户已经登陆
	public int Login(String userName,String passWord){
		int reFlag=-4;
		PreparedStatement preparedStatement=null;
		String sql="select * from tb_user where name=?";
		ResultSet resultSet=null;
		try {
			preparedStatement=this.connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);	
			resultSet=preparedStatement.executeQuery();
			resultSet.last();
			if(resultSet.getRow()>0){
				resultSet.first();
				String passWordDB=null;
				passWordDB=resultSet.getString("password");
				if(passWordDB!=null){
					String md5PassWord=MD5Util.string2MD5(passWord);
					if(md5PassWord.equals(passWordDB))
						return 1;
					else
						return -2;			
				}
			}
			else{
				return -1;
			}
		} catch (SQLException e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBUserManager.class.getName());
		}
		finally{		
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();		
			} catch (SQLException e) {
				WriteLog writeLog = new WriteLog();
				writeLog.Write(e.getMessage(),DBUserManager.class.getName());
			}			
		}
		return reFlag;
		
	}
	
	
	/*public int register(UserBean bean){		
		String sql="insert into table_user(name,password,email,level) values(?,?,?,?)";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=this.connection.prepareStatement(sql);
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setString(2, bean.getPassWord());
			preparedStatement.setString(3, bean.getEmail());
			preparedStatement.setInt(4, 1);
			int row=preparedStatement.executeUpdate();
			if(row>0){
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}
		finally{		
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return -1;
	}*/
	
	
}