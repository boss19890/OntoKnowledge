package com.shenji.words;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.shenji.DBManager.DBUtil;
import com.shenji.search.IniEditor;

public class SimilarWordDict {
	private static SimilarWordDict instance=new SimilarWordDict();
	private SimilarWordDict(){	
		try {
			IniEditor editor=new IniEditor();
			String path=editor.getClass().getClassLoader().getResource("").toURI().getPath();;
			initCodeDB(path);
			initWordDB(path);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SimilarWordDict getInstance(){
		return instance;
	}
	
	public int TreeBranchNum(String ch,int count){
		//List list=SimilarWordDict.getCodeList();
		int num=0;
		String sql="select * from words_code where code like ?";
		DBUtil dbUtil=new DBUtil();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			statement=dbUtil.getConnection().prepareStatement(sql);
			if(count==1)
				statement.setString(1, ch+"_");
			else
				statement.setString(1, ch+"__");
			
			resultSet=statement.executeQuery();
			resultSet.last();
			num = resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(resultSet!=null)
					resultSet.close();		
				if(statement!=null)
					statement.close();
				if(dbUtil!=null)
					dbUtil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}
	
	public String getWordCode(String word){
		String code=null;
		String sql="select code from words_word where word=?";
		DBUtil dbUtil=new DBUtil();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			statement=dbUtil.getConnection().prepareStatement(sql);
			statement.setString(1, word);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				code=resultSet.getString("code");
				return code;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(resultSet!=null)
					resultSet.close();		
				if(statement!=null)
					statement.close();
				if(dbUtil!=null)
					dbUtil.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return code;
	}
	
	
	private void initCodeDB(String path){
		String sql_create="create table words_code (id int not null auto_increment ,code VARCHAR(10) not null unique, primary key(id))engine=innodb default charset=utf8;";
		String sql_insert="insert into words_code(code) values(?)";
		File file=new File(path+"同义词编码.txt");
		DBUtil dbUtil = null;
		Connection con;
		PreparedStatement statement_create = null;
		PreparedStatement statement_insert = null;
		try {
			List<String> codeList=FileUtils.readLines(file);
		    dbUtil=new DBUtil();
			con=dbUtil.getConnection();
			statement_create=con.prepareStatement(sql_create);
			try{
				statement_create.execute();
			}
			//这个异常不写日志，如果表存在，后面不做了
			catch (com.mysql.jdbc.exceptions.MySQLSyntaxErrorException e) {
				System.err.println("words_code重复表不创建！");
				return;
			}
			statement_insert=con.prepareStatement(sql_insert);
			
			int end=0;
			for(int i=0;i<5;i++){
				end=end+1;
				if(i==2||i==4)
					end++;
				for(String str:codeList){
					String temp=str.substring(0, end);
					statement_insert.clearParameters();					
					statement_insert.setString(1,temp);	
					try{
						statement_insert.executeUpdate();	
						System.out.println(temp);
					}
					//这个异常不写日志，如果重复数据，不插入
					catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
					}						
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				if(statement_create!=null)
					statement_create.close();
				if(statement_insert!=null)
					statement_insert.close();
				if(dbUtil!=null)
					dbUtil.close();			
			}catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
	
	private void initWordDB(String path){
		String sql_create="create table words_word (id int not null auto_increment ,word VARCHAR(20) not null unique,codeNum int not null,code VARCHAR(200), primary key(id))engine=innodb default charset=utf8;";
		String sql_insert="insert into words_word(word,codeNum,code) values(?,?,?)";
		File file=new File(path+"同义词词林.txt");
		DBUtil dbUtil = null;
		Connection con;
		PreparedStatement statement_create = null;
		PreparedStatement statement_insert = null;
		try {
			List<String> codeList=FileUtils.readLines(file);
		    dbUtil=new DBUtil();
			con=dbUtil.getConnection();
			statement_create=con.prepareStatement(sql_create);
			try{
				statement_create.execute();
			}
			//这个异常不写日志，如果表存在，后面不做了
			catch (com.mysql.jdbc.exceptions.MySQLSyntaxErrorException e) {
				System.err.println("words_word重复表不创建！");
				return;
			}
			statement_insert=con.prepareStatement(sql_insert);
			
			int end=0;
			for(String str:codeList){
				String[] temp=str.split(" ");
				statement_insert.clearParameters();					
				statement_insert.setString(1,temp[0]);	
				statement_insert.setString(2,temp[1]);
				String code="";
				for(int i=2;i<Integer.parseInt(temp[1])+2;i++){
					code=code+temp[i]+";";
				}
				statement_insert.setString(3,code);
				try{
					statement_insert.executeUpdate();	
					System.out.println(temp[0]+":"+code);
				}
				//这个异常不写日志，如果重复数据，不插入
				catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e) {
				}						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				if(statement_create!=null)
					statement_create.close();
				if(statement_insert!=null)
					statement_insert.close();
				if(dbUtil!=null)
					dbUtil.close();			
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new SimilarWordDict();
		System.err.println("");
	}

}
