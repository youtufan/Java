package com.zhj.model;

import java.sql.Date;

/**
 * ͼ��ʵ��
 * @author ZHJ
 *
 */
public class Book {
	
	private int id;//ͼ����
	private String bookName;//ͼ������
	private String author;//ͼ������
	private String sex;//�����Ա�
	private Integer bookTypeId;//�����
	private String bookTypeName;//�������
	private String state;//����״̬
	private java.sql.Date borrowTime;//����ʱ��
	private Float fine=(float) 0;//����
	private int readerId;//���߱��
	
	
	
	
	public Book(int id, String bookName, String author, String sex, Integer bookTypeId, String state, Date borrowTime,
			Float fine, int readerId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.state = state;
		this.borrowTime = borrowTime;
		this.fine = fine;
		this.readerId = readerId;
	}


	public Book(int id, String bookName, String state, Date borrowTime, Float fine) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.state = state;
		this.borrowTime = borrowTime;
		this.fine = fine;
	}


	public Book(int id, Date borrowTime, Float fine) {
		super();
		this.id = id;
		this.borrowTime = borrowTime;
		this.fine = fine;
	}
	
	
	public Book(int id, String bookName, String state, Date borrowTime, int readerId) {
		super();
		this.id = id;
		this.bookName=bookName;
		this.state = state;
		this.borrowTime = borrowTime;
		this.readerId = readerId;
	}
	
	
	public Book(int readerId) {
		super();
		this.readerId = readerId;
	}


	public Book(int id, Float fine) {
		super();
		this.id = id;
		this.fine = fine;
	}


	public Float getFine() {
		return fine;
	}


	public void setFine(Float fine) {
		this.fine = fine;
	}


	public Book(int id, String bookName, String state, Date borrowTime) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.state = state;
		this.borrowTime = borrowTime;
	}


	public Book(int id, String bookName, String author, String sex, Integer bookTypeId, String state, Float fine,Date borrowTime) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.state = state;
		this.fine = fine;
		this.borrowTime=borrowTime;
	}


	public Book(int id, String bookName, String author, String sex, Integer bookTypeId, String state,Float fine) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.state = state;
		this.fine=fine;
	}


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}


	public Book(String bookName, String author, String sex, Integer bookTypeId, String state) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeTd(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public java.sql.Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(java.sql.Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
}
