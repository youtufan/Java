package com.zhj.model;
 
/**
 * ����Աʵ��
 * @author ZHJ
 *
 */
public class User {
	
	public User(int id, String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;//���
	private String userName;//�û���
	private String password;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
