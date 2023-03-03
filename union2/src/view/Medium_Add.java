package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.G_Dao;
import java.awt.Color;

public class Medium_Add extends JFrame {

	JComboBox  largeBox;
	JLabel     large, medium ;
	JTextField MediumText, MediumidText;
	JButton    add, cancle;  
	
	
	public Medium_Add() {
		getContentPane().setBackground(new Color(255, 255, 255));
		init();
		setTitle("중분류추가");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	private void init() {
		getContentPane().setLayout(null);
		
		G_Dao dao = new G_Dao();
		Vector<String> largecategory = dao.getLargeCategory();
		
		largeBox = new JComboBox(largecategory);
		largeBox.setBackground(new Color(250, 250, 250));
		largeBox.setBounds(164, 39, 172, 36);
		getContentPane().add(largeBox);
		
		large =new JLabel("\uB300\uBD84\uB958\uC120\uD0DD");
		large.setFont(new Font("굴림", Font.PLAIN, 15));
		large.setBounds(51, 34, 86, 46);
		getContentPane().add(large);
		
		
		medium = new JLabel("중분류 입력 :");
		medium.setFont(new Font("굴림", Font.PLAIN, 14));
		medium.setBounds(51, 110, 102, 36);
		getContentPane().add(medium);
		
		MediumText = new JTextField();
		MediumText.setBounds(164, 111, 172, 36);
		getContentPane().add(MediumText);
		MediumText.setColumns(10);
	
		
		add = new JButton("\uCD94\uAC00\uD558\uAE30");
		add.setBackground(new Color(238, 251, 255));
		add.setBounds(77, 208, 97, 23);
		getContentPane().add(add);
		
		cancle = new JButton("새로고침");
		cancle.setBackground(new Color(238, 251, 255));
		cancle.setBounds(206, 208, 97, 23);
		getContentPane().add(cancle);
		
	
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               G_Dao dao = new G_Dao();
               String large1 = (String) largeBox.getSelectedItem();
               String medium1 = MediumText.getText();
               
               System.out.println("라지" + large1);
               System.out.println("미디움" + medium1);
               
               int aftcnt = dao.insertMedium(large1, medium1);
               MediumText.setText("");
			}
		});
		
	   cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("새로고침클릭");
				MediumText.setText("");
				
			}

		});
		
	}
	public static void main(String[] args) {
		new Medium_Add();

	}
}
