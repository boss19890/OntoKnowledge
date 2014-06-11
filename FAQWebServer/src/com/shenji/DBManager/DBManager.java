package com.shenji.DBManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shenji.log.WriteLog;
import com.shenji.search.SearchLogic;
//import com.sun.crypto.provider.RSACipher;

public class DBManager {
	  String driver = "com.mysql.jdbc.Driver";
      String url = "";
      String user = "";
      String password = "";
      public DBManager(){
    	  String dbName = "";
    	  String dbIP = "";
    	  Map map = new HashMap();
    	  try {
    		  BufferedReader bufReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("").toURI().getPath()+"/system.ini"));
    		  String line = null;
    	  		while((line = bufReader.readLine())!=null){
    	  			line = line.trim();
    	  			if(line.equals("[dbconfig]")){
    	  				while((line = bufReader.readLine())!=null){
    	  					if(line.matches("\\[.*\\]"))
    	  						break;
    	  					String [] s = line.split("=");
    	  					if(s.length==2){
    	  						map.put(s[0], s[1]);
    	  					}
    	  				}
    	  				break;
    	  			}
    	  		}
    	  		bufReader.close();
		} catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBManager.class.getName());
		}
  		if(map.get("user")!=null)
  			user = map.get("user").toString();
  		if(map.get("password")!=null)
  			password = map.get("password").toString();
  		if(map.get("dbName")!=null)
  			dbName = map.get("dbName").toString();
  		if(map.get("dbIP")!=null)
  			dbIP = map.get("dbIP").toString();
  		url = "jdbc:mysql://"+dbIP+"/"+dbName+"?useUnicode=true&characterEncoding=utf8";
      }
      //获取回答
      public String getAnswer(String Question){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  String Answer = null;
    	  ResultSet rs = null;
    	  try {
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "select * from tb_faq where Question='"+Question+"'";
    		  rs = statement.executeQuery(sql);
    		  if(rs.next()){
    			  Answer = rs.getString("Answer");
    		  }
    	  }  catch (Exception e) {
			WriteLog writeLog = new WriteLog();
			writeLog.Write(e.getMessage(),DBManager.class.getName());
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(statement!=null)
					statement.close();
				if(connection!=null)
					connectionPool.setConnection(connection);
				} catch (SQLException e) {
					WriteLog writeLog = new WriteLog();
					try {
						writeLog.Write(e.getMessage(),DBManager.class.getName());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
    	  return Answer;
      }
      
/*      //增加常用语
      public int addQA(String Question,String Answer){
    	  int state = 0;
    	  Connection connection = null;
    	  ResultSet rs = null;
    	  Statement statement = null;
    	  try{
    		  Class.forName(driver);
    		  connection = DriverManager.getConnection(url, user, password);
    		  statement = connection.createStatement();
    		  String sql = "select * from tb_faq where Question='"+Question+"'";
    		  rs = statement.executeQuery(sql);
    		  //如果常用语已经存在，返回0
    		  if(rs.next()){
    			  state = 0;
    		  }else{
    			  sql = "insert into tb_faq values('"+Question+"','"+Answer+"')";
    			  statement.execute(sql);
    			  state = 1;
    		  }
    		  
    	  }catch (Exception e) {
  			WriteLog writeLog = new WriteLog();
  			try {
  				writeLog.Write(e.getMessage(),DBManager.class.getName());
  			} catch (Exception e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
  			state = -1;
		}
    	  finally{
				try {
					if(rs!=null)
						rs.close();
					if(statement!=null)
						statement.close();
					if(connection!=null)
						connection.close();
  				} catch (SQLException e) {
  					WriteLog writeLog = new WriteLog();
  					try {
  						writeLog.Write(e.getMessage(),DBManager.class.getName());
  					} catch (Exception e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
  				}
  		}
    	  return state;
      }*/
      
      //增加常用语
      public int addQA(String Question,String Answer){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  int state = 0;
    	  ResultSet rs = null;
    	  try{
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "select * from tb_faq where Question='"+Question+"'";
    		  rs = statement.executeQuery(sql);
    		  //如果常用语已经存在，返回0
    		  if(rs.next()){
    			  state = 0;
    		  }else{
    			  sql = "insert into tb_faq values('"+Question+"','"+Answer+"')";
    			  statement.execute(sql);
    			  state = 1;
    		  }
    		  
    	  }catch (Exception e) {
  			WriteLog writeLog = new WriteLog();
  			writeLog.Write(e.getMessage(),DBManager.class.getName());
  			state = -1;
		}
    	  finally{
				try {
					if(rs!=null)
						rs.close();
					if(statement!=null)
						statement.close();
					if(connection!=null)
						connectionPool.setConnection(connection);
  				} catch (SQLException e) {
  					WriteLog writeLog = new WriteLog();
  					writeLog.Write(e.getMessage(),DBManager.class.getName());
  				}
  		}
    	  return state;
      }
      
      
      //删除常用语
      public int delQA(String Question){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  int state = 0;
    	  try{
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "delete from tb_faq where Question='"+Question+"'";
    		  if(statement.executeUpdate(sql)==1)
    			  state = 1;
    		  else
    			  state = 0;
    	  }catch (Exception e) {
    		  WriteLog writeLog = new WriteLog();
    		  writeLog.Write(e.getMessage(),DBManager.class.getName());
    			state = -1;
		}finally{
			try {
				if(statement!=null)
					statement.close();
				if(connection!=null)
					connectionPool.setConnection(connection);
				}
			catch (SQLException e) {
  					WriteLog writeLog = new WriteLog();
  					try {
  						writeLog.Write(e.getMessage(),DBManager.class.getName());
  					} catch (Exception e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
  				}
  		}
    	  return state;
    	  
    	  
      }
      
      //修改常用语
      public int modifyQA(String Question,String Answer){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  int state = 0;
    	  try{
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "update tb_faq set Answer='"+Answer+"' where Question='"+Question+"'";
    		  if(statement.executeUpdate(sql)==1)
    			  state = 1;
    		  else
    			  state = 0;
    	  }catch (Exception e) {
    		  WriteLog writeLog = new WriteLog();
    		  writeLog.Write(e.getMessage(),DBManager.class.getName());
  			state = -1;
		}finally{
			try {
				if(statement!=null)
					statement.close();
				if(connection!=null)
					connectionPool.setConnection(connection);
				} 
			catch (SQLException e) {
  					WriteLog writeLog = new WriteLog();
  					writeLog.Write(e.getMessage(),DBManager.class.getName());
  				}
  		}
    	  return state;	    	  
      }
      
      public HashMap<String,String> getAllQA(){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  ResultSet resultSet=null;
    	  HashMap<String,String> map=new HashMap<String,String>();
    	  try{
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "select * from tb_faq";
    		  resultSet=statement.executeQuery(sql);
    		  while(resultSet.next()){
    			  map.put(resultSet.getString("Question"),resultSet.getString("Answer"));		  
    		  }  	
    		  System.err.println("");
    	  }catch (Exception e) {
    		  WriteLog writeLog = new WriteLog();
    		  writeLog.Write(e.getMessage(),DBManager.class.getName());
		}finally{
			try {
				if(resultSet!=null)
					resultSet.close();
				if(statement!=null)
					statement.close();		
	  			if(connection!=null)
	  				connectionPool.setConnection(connection);
  					
  			} catch (SQLException e) {
  				WriteLog writeLog = new WriteLog();
  				writeLog.Write(e.getMessage(),DBManager.class.getName());
  			}
  		}
    	return map;	
      }
      
      //修改信息日志
      public void ModifyLog(String operation,String parameter){
    	  ConnectionPool connectionPool = null;
    	  Connection connection = null;
    	  Statement statement = null;
    	  try{
    		  connectionPool = ConnectionPool.getInstance();
    		  connection = connectionPool.getConnection();
    		  statement = connection.createStatement();
    		  String sql = "insert into tb_log (Operation,Parameter) values('"+operation+"','"+parameter+"')";
    		  statement.execute(sql);
    	  }catch (Exception e) {
    		  WriteLog writeLog = new WriteLog();
    		  writeLog.Write(e.getMessage(),DBManager.class.getName());
		}finally{
			try {
				if(statement!=null)
					statement.close();
				if(connection!=null)
					connectionPool.setConnection(connection);
				} 
			catch (SQLException e) {
  					WriteLog writeLog = new WriteLog();
  					writeLog.Write(e.getMessage(),DBManager.class.getName());
  				}
  		}
      }
      
}
