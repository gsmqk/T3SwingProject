package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.G_Dao;
import model.G_Vo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Large_Add extends JFrame {

	JLabel     large, largeid;
	JTextField largeText, largeidText;
	JButton    add, cancle;  
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public Large_Add() {
		init();
		
		
	}
	private void init() {
		
		setTitle("대분류추가");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		large = new JLabel("\uB300\uBD84\uB958id\uC785\uB825 :");
		large.setFont(new Font("굴림", Font.PLAIN, 15));
		large.setBounds(39, 52, 91, 45);
		getContentPane().add(large);
		
/*		largeText = new JTextField(20);
		largeText.setBounds(142, 52, 176, 40);
		getContentPane().add(largeText);
		largeText.setColumns(10); */
		
		largeid = new JLabel(" \uB300\uBD84\uB958 \uC785\uB825 :");
		largeid.setFont(new Font("굴림", Font.PLAIN, 15));
		largeid.setBounds(39, 106, 91, 40);
		getContentPane().add(largeid);
		
		largeidText = new JTextField(20);
		largeidText.setBounds(142, 106, 176, 40);
		getContentPane().add(largeidText);
		largeidText.setColumns(10);
		
		add = new JButton("추가하기");
		add.setBounds(70, 200, 97, 23);
		getContentPane().add(add);
		
		cancle = new JButton("취소하기");
		cancle.setBounds(202, 200, 97, 23);
		getContentPane().add(cancle);
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("추가하기클릭");
				addGrocery();	
				largeidText.setText("");
			}

	
			
		});
		
	}
	
	public static void main(String[] args) {
		new Large_Add();

	}
	
	private void addGrocery() {
		G_Dao gdao = new G_Dao();
		String search = largeidText.getText();
		
		int   aftcnt = gdao.insertGrocery(search);
	}
}
