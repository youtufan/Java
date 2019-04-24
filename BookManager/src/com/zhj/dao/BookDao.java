package com.zhj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zhj.model.Book;
import com.zhj.model.Student;
import com.zhj.util.StringUtil;

/**
 * 图书Dao类
 * @author ZHJ
 *
 */
public class BookDao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql="insert into t_book values(null,?,?,?,?,?,?,?,0)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5, book.getState());
		pstmt.setDate(6, book.getBorrowTime());
		pstmt.setFloat(7, book.getFine());
		return pstmt.executeUpdate();
	}
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 已借图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet listBorrowBook(Connection con,Book book)throws Exception{
		String sql="select * from t_book where readerId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, book.getReaderId());
		return pstmt.executeQuery();
	}
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * 图书信息更新
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql="update t_book set bookName=?,author=?,sex=?,bookTypeId=?,state=?,borrowTime=?,fine=?,readerId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5, book.getState());
		pstmt.setDate(6, book.getBorrowTime());
		pstmt.setFloat(7, book.getFine());
		pstmt.setInt(8, book.getReaderId());
		pstmt.setInt(9, book.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 借阅图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int borrow(Connection con,Book book)throws Exception{
		String sql="update t_book set state=?,borrowTime=?,readerId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getState());
		pstmt.setDate(2, book.getBorrowTime());
		pstmt.setInt(3, book.getReaderId());
		pstmt.setInt(4, book.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 交罚款
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int payfine(Connection con,Book book)throws Exception{
		String sql="update t_book set state=?,borrowTime=?,fine=?,readerId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getState());
		pstmt.setDate(2, book.getBorrowTime());
		pstmt.setFloat(3, book.getFine());
		pstmt.setInt(4, book.getReaderId());
		pstmt.setInt(5, book.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 未交罚款
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int notPayfine(Connection con,Book book)throws Exception{
		String sql="update t_book set fine=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setFloat(1, book.getFine());
		pstmt.setInt(2, book.getId());
		return pstmt.executeUpdate();
	}
}
