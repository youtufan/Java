package com.zhj.view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhj.dao.BookDao;
import com.zhj.dao.BookTypeDao;
import com.zhj.dao.StudentDao;
import com.zhj.model.Book;
import com.zhj.model.Student;
import com.zhj.util.DbUtil;
import com.zhj.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class BookSendInterFrm extends JInternalFrame {
	private JTable personalTable;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private StudentDao studentDao=new StudentDao();
	private JTextField studentNameTxt;
	private JButton btnNewButton;
	private JLabel label_1;
	private JTextField idTxt;
	private JLabel label_2;
	private JTextField bookNameTxt;
	private JLabel label_3;
	private JTextField stateTxt;
	private JLabel label_4;
	private JTextField fineTxt;
	private JButton button;
	private JLabel label_5;
	private JPasswordField passwordTxt;
	private JLabel label_6;
	private JTextField borrowTimeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSendInterFrm frame = new BookSendInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookSendInterFrm() {
		setTitle("\u5DF2\u501F\u56FE\u4E66\u67E5\u8BE2");
		setClosable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 950, 556);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		
		studentNameTxt = new JTextField();
		studentNameTxt.setColumns(10);
		
		btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBookSearchActionPerformed(e);
			}
		});
		
		label_1 = new JLabel("\u7F16\u53F7");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setEditable(false);
		bookNameTxt.setColumns(10);
		
		label_3 = new JLabel("\u501F\u9605\u72B6\u6001");
		
		stateTxt = new JTextField();
		stateTxt.setEditable(false);
		stateTxt.setColumns(10);
		
		label_4 = new JLabel("\u5E94\u7F34\u7EB3\u7F5A\u6B3E");
		
		fineTxt = new JTextField();
		fineTxt.setEditable(false);
		fineTxt.setColumns(10);
		
		button = new JButton("\u5F52\u8FD8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSendActionPerformed(e);
			}
		});
		
		label_5 = new JLabel("\u8F93\u5165\u5BC6\u7801");
		
		passwordTxt = new JPasswordField();
		
		label_6 = new JLabel("\u501F\u9605\u65E5\u671F");
		
		borrowTimeTxt = new JTextField();
		borrowTimeTxt.setEditable(false);
		borrowTimeTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(stateTxt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(fineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(stateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(fineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
		personalTable = new JTable();
		personalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				bookTableMousePressed(me);
			}
		});
		personalTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u501F\u9605\u72B6\u6001", "\u501F\u9605\u65E5\u671F", "\u7F5A\u6B3E"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(personalTable);
		getContentPane().setLayout(groupLayout);
		
	}

	/**
	 * 图书归还事件处理
	 * @param e
	 */
	private void bookSendActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要归还的图书！");
			return;
		}
		String bookName=this.bookNameTxt.getText();
		String state=this.stateTxt.getText();
		if(state.equals("已借")) {
			state="未借";
		}
		//自动判断借书时间是否超出30天，并自动修改罚款
		float newFine=0;
		String borrowTime=this.borrowTimeTxt.getText();
		java.util.Date date = null;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(borrowTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date currentDate= new Date();
		if((currentDate.getMonth()-date.getMonth())==1&&currentDate.getDate()>date.getDate()) {
			newFine=(float) ((currentDate.getMonth()-date.getMonth())*1);
		}else if((currentDate.getMonth()-date.getMonth())>1) {
			newFine=(float) ((currentDate.getMonth()-date.getMonth())*1);
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			if(newFine==0) {
				date= null;
				Book book=new Book(Integer.parseInt(id),bookName,state,(java.sql.Date) date);
				int addNum=bookDao.borrow(con, book);
				if(addNum==1) {
					JOptionPane.showMessageDialog(null, "图书归还成功，重新查询以刷新信息！");
				}else {
					JOptionPane.showMessageDialog(null, "图书归还失败！");
				}
			}else {
				int n = JOptionPane.showConfirmDialog(null, "是否缴纳罚款"+newFine+"元并归还图书？", "",JOptionPane.YES_NO_OPTION);
				if(n==0) {
					newFine=0;
					date=null;
					Book book=new Book(Integer.parseInt(id),bookName,state,(java.sql.Date) date,newFine);
					int addNum=bookDao.payfine(con, book);
					if(addNum==1) {
						JOptionPane.showMessageDialog(null, "归还图书成功，重新查询以刷新信息！");
					}else {
						JOptionPane.showMessageDialog(null, "缴纳罚款失败！");
					}
				}else {
					Book book=new Book(Integer.parseInt(id),newFine);
					int addNum=bookDao.notPayfine(con, book);
					if(addNum==1) {
						JOptionPane.showMessageDialog(null, "罚款信息刷新成功，重新查询以刷新信息！");
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书归还失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 图书表单点击事件处理
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		int row=this.personalTable.getSelectedRow();
		this.idTxt.setText((String)personalTable.getValueAt(row,0));
		this.bookNameTxt.setText((String)personalTable.getValueAt(row, 1));
		this.stateTxt.setText((String)personalTable.getValueAt(row, 4));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String borrowTime = sdf.format(personalTable.getValueAt(row, 5));
		this.borrowTimeTxt.setText(borrowTime);
		this.fineTxt.setText((float)personalTable.getValueAt(row, 6)+"");
	}

	/**
	 * 借阅图书查询事件处理
	 * @param e
	 */
	private void borrowBookSearchActionPerformed(ActionEvent e) {
		this.fillTable();
	}
	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable() {
		DefaultTableModel dtm=(DefaultTableModel) personalTable.getModel();
		dtm.setRowCount(0);//设置0行
		Connection con=null;
		String studentName=this.studentNameTxt.getText();
		String password=this.passwordTxt.getText();
		Student student=new Student(studentName,password);
		try {
			con=dbUtil.getCon();
			Student currentStudent=studentDao.login(con, student);
			if(currentStudent!=null) {
				int readerId=studentDao.getStudentId(con, studentName);
				if(readerId!=0) {
					Book book=new Book(readerId);
					ResultSet rs=bookDao.listBorrowBook(con, book);
					while(rs.next()) {
						Vector v=new Vector();
						v.add(rs.getString("id"));
						v.add(rs.getString("bookName"));
						v.add(rs.getString("author"));
						v.add(rs.getString("sex"));
						v.add(rs.getString("state"));
						v.add(rs.getDate("borrowTime"));
						v.add(rs.getFloat("fine"));
						dtm.addRow(v);
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
