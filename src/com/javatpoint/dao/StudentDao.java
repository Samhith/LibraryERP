package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.StudentBean;



public class StudentDao {

	public static int save(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_student values(std_seq.nextval,?,?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setLong(3,bean.getMobile());
			ps.setString(4,bean.getUName());
			ps.setString(5,bean.getPassword());
		
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_student set name=?,email=?,mobile=?,uname=?,password=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setLong(3,bean.getMobile());
			ps.setString(1,bean.getUName());
			ps.setString(5,bean.getPassword());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<StudentBean> view(){
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setId(rs.getInt(1));
				System.out.println(rs.getInt(1));
				bean.setName(rs.getString(2));
				System.out.println(rs.getString(2));				
				bean.setEmail(rs.getString(3));
				bean.setMobile(rs.getLong(4));
				bean.setUName(rs.getString(5));
				bean.setPassword(rs.getString(6));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static StudentBean viewById(int id){
		StudentBean bean=new StudentBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_librarian where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setMobile(rs.getLong(4));
				bean.setName(rs.getString(5));
				bean.setPassword(rs.getString(6));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(String mail){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from e_student where student_mail=?");
			ps.setString(1,mail);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_student where student_mail=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
