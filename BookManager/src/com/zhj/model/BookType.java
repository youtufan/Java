package com.zhj.model;
/**
 * 图书类别
 * @author ZHJ
 *
 */
public class BookType {
	private int id;//编号
	private String bookTypeName;//图书类别
	private String bookTypeDesc;//类别注释
	
	
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
		
	}


	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	
	public String toString() {
		return bookTypeName;
	}
}
