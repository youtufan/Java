package com.zhj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhj.model.Book;
import com.zhj.model.Student;

/**
 * 学生Dao类
 * @author ZHJ
 *
 */
public class StudentDao {
	/**
	 * 登陆验证
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student login(Connection con,Student student)throws Exception{
		Student resultStudent=null;
		String sql="select * from t_student where studentName=? and password=? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStudentName());
		pstmt.setString(2, student.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultStudent=new Student();
			resultStudent.setId(rs.getInt("id"));
			resultStudent.setStudentName(rs.getString("studentName"));
			resultStudent.setPassword(rs.getString("password"));
		}
		return resultStudent;
	}
	/**
	 * 获取读者编号
	 * @param con
	 * @param studentName
	 * @return
	 * @throws Exception
	 */
	public int getStudentId(Connection con,String studentName)throws Exception{
		String sql="select id from t_student where studentName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentName);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		return 0;
	}
}
