package com.zhj.model;
 
/**
 * ѧ���û�ʵ��
 * @author ZHJ
 *
 */
public class Student {
	
	public Student(int id, String studentName, String password) {
		super();
		this.studentName = studentName;
		this.password = password;
	}
	public Student(String studentName, String password) {
		super();
		this.studentName = studentName;
		this.password = password;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//���
	private String studentName;//�ǳ�
	private String password;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
