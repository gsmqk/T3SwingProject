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

	JLabel     large;
	JTextField largeText, largeidText;
	JButton    add, cancle;  
	
	
	
	public Large_Add() {
		init();
		
		
	}
	private void init() {
		
		setTitle("대분류추가");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
/*		largeText = new JTextField(20);
		largeText.setBounds(142, 52, 176, 40);
		getContentPane().add(largeText);
		largeText.setColumns(10); */
		
		large = new JLabel(" 대분류 입력 :");
		large.setFont(new Font("굴림", Font.PLAIN, 15));
		large.setBounds(39, 80, 91, 40);
		getContentPane().add(large);
		
		largeText = new JTextField(20);
		largeText.setBounds(142, 80, 176, 41);
		getContentPane().add(largeText);
		largeText.setColumns(10);
		
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
		
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소하기클릭");
				largeidText.setText("");
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Large_Add();

	}
	
	private void addGrocery() {
		G_Dao gdao = new G_Dao();
		String search = largeText.getText();
		
		int   aftcnt = gdao.insertGrocery(search);
	}
}
