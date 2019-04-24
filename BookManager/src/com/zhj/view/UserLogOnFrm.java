package com.zhj.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zhj.dao.UserDao;
import com.zhj.model.User;
import com.zhj.util.DbUtil;
import com.zhj.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class UserLogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogOnFrm frame = new UserLogOnFrm();
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
	public UserLogOnFrm() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(169, 66, 324, 142);
		label.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/book_.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458 \uFF1A");
		label_1.setBounds(169, 243, 114, 29);
		label_1.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/user.png")));
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("华文中宋", Font.BOLD, 16));
		
		JLabel label_2 = new JLabel("  \u5BC6\u7801 \uFF1A");
		label_2.setBounds(169, 313, 102, 25);
		label_2.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/key.png")));
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("华文中宋", Font.BOLD, 16));
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(312, 245, 181, 25);
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(312, 314, 181, 23);
		passwordTxt.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(169, 387, 101, 39);
		button.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/right.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		button.setFont(new Font("华文彩云", Font.BOLD, 16));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(388, 388, 105, 37);
		button_1.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setFont(new Font("华文彩云", Font.BOLD, 16));
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(passwordTxt);
		contentPane.add(userNameTxt);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 652, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 666, 550);
		lblNewLabel.setIcon(new ImageIcon(UserLogOnFrm.class.getResource("/images/library+.jpg")));
		panel.add(lblNewLabel);
		//设置登录界面居中
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getText());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con,user);
			if(currentUser!=null) {
				dispose();
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
