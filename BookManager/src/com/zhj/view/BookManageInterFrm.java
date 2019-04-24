package com.zhj.view;

import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.zhj.dao.BookDao;
import com.zhj.dao.BookTypeDao;
import com.zhj.model.Book;
import com.zhj.model.BookType;
import com.zhj.util.DbUtil;
import com.zhj.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JComboBox s_bookTypeJcb;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JComboBox bookTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField authorTxt;
	private JTextField stateTxt;
	private JTextField fineTxt;
	private JTextField borrowTimeTxt;
	private JTextField readerIdTxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setClosable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 980, 517);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u5904\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B");
		
		manJrb = new JRadioButton("\u7537");
		manJrb.setSelected(true);
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_5 = new JLabel("\u501F\u9605\u72B6\u6001");
		
		stateTxt = new JTextField();
		stateTxt.setEditable(false);
		stateTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionPerformed(e);
			}
		});
		
		JLabel label_6 = new JLabel("\u7F5A\u6B3E");
		
		fineTxt = new JTextField();
		fineTxt.setEditable(false);
		fineTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u501F\u9605\u65E5\u671F");
		
		borrowTimeTxt = new JTextField();
		borrowTimeTxt.setEditable(false);
		borrowTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		
		readerIdTxt = new JTextField();
		readerIdTxt.setEditable(false);
		readerIdTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stateTxt, 105, 105, 105))))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(femaleJrb, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(127))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(femaleJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(manJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(13)
							.addComponent(label_2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(4)
										.addComponent(lblNewLabel_4))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(1)
										.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4)
										.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5)
										.addComponent(stateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_1)
										.addComponent(btnNewButton_2)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(fineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6))))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(btnNewButton))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				bookTableMousePressed(me);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u7C7B\u522B", "\u501F\u9605\u72B6\u6001", "\u501F\u9605\u65E5\u671F", "\u7F5A\u6B3E", "\u8BFB\u8005\u7F16\u53F7"
			}
		));
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(39);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(84);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(68);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(59);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(74);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(65);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(82);
		bookTable.getColumnModel().getColumn(7).setPreferredWidth(45);
		bookTable.getColumnModel().getColumn(8).setPreferredWidth(61);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);

		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	}
	/**
	 * ͼ����Ϣɾ���¼�����
	 * @param e
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ����¼��");
			return;
		}
		String state=this.stateTxt.getText();
		if(state.equals("�ѽ�")) {
			JOptionPane.showMessageDialog(null, "��ͼ���ѱ����������ɾ����");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��","",JOptionPane.YES_NO_OPTION);
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=bookDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					this.resetValue();
					this.fillTable(new Book());
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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

	/**
	 * ͼ���޸��¼�����
	 * @param evt
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
			return;
		}
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String state=this.stateTxt.getText();
		//�Զ��жϽ���ʱ���Ƿ񳬳�30�죬���Զ��޸ķ���
		String fine=this.fineTxt.getText();
		float newFine=Float.parseFloat(fine);
		String borrowTime=this.borrowTimeTxt.getText();
		java.util.Date date = null;
		
		if(borrowTime.equals("��")) {
			
		}else {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(borrowTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(date!=null) {
			Date currentDate= new Date();
			if((currentDate.getMonth()-date.getMonth())==1&&currentDate.getDate()>date.getDate()) {
				newFine=(float) ((currentDate.getMonth()-date.getMonth())*1);
			}else if((currentDate.getMonth()-date.getMonth())>1) {
				newFine=(float) ((currentDate.getMonth()-date.getMonth())*1);
			}else if(state.equals("�ѽ�")) {
				JOptionPane.showMessageDialog(null, "��ͼ���ѱ������δ�����������ޣ������޸ģ�");
				return;
			}
		}
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ�գ�");
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "���߲���Ϊ�գ�");
		}
		
		String sex="";
		if(manJrb.isSelected()) {
			sex="��";
		}else {
			sex="Ů";
		}
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		String readerId=this.readerIdTxt.getText();
		Book book=new Book();
		if(date!=null) {
			java.sql.Date dateSql = new java.sql.Date(date.getTime());
			book=new Book(Integer.parseInt(id),bookName,author,sex,bookTypeId,state,dateSql,newFine,Integer.parseInt(readerId));
		}else {
			book=new Book(Integer.parseInt(id),bookName,author,sex,bookTypeId,state,newFine);
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addNum=bookDao.update(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "ͼ���޸ĳɹ���");
				resetValue();
				this.fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ�ܣ�");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ�ܣ�");
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
	 * ���ñ�
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.manJrb.setSelected(true);
		this.stateTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
		this.fineTxt.setText("");
		this.readerIdTxt.setText("");
	}

	/**
	 * ͼ�������¼�����
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row,0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex=(String)bookTable.getValueAt(row, 3);
		if("��".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if("Ů".equals(sex)) {
			this.femaleJrb.setSelected(true);
		}
		this.stateTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 4);
		int n=this.bookTypeJcb.getItemCount();
		for(int i=0;i<n;i++) {
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
		if(bookTable.getValueAt(row, 6)==null) {
			this.borrowTimeTxt.setText("��");
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String borrowTime = sdf.format(bookTable.getValueAt(row, 6));
			this.borrowTimeTxt.setText(borrowTime);
		}
		this.fineTxt.setText((float)bookTable.getValueAt(row, 7)+"");
		this.readerIdTxt.setText(bookTable.getValueAt(row, 8).toString());
	}

	/**
	 * ͼ���ѯ�¼�����
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	/**
	 * ��ʼ��������
	 * @param type ����������
	 */
	private void fillBookType(String type) {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			if("search".equals(type)) {
				bookType=new BookType();
				bookType.setBookTypeName("��ѡ��...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while(rs.next()) {
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				}else if("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
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
	/**
	 * ��ʼ���������
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//����0��
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con, book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("state"));
				v.add(rs.getDate("borrowTime"));
				v.add(rs.getFloat("fine"));
				v.add(rs.getInt("readerId"));
				dtm.addRow(v);
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
