package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Small_Add extends JFrame{
	
	JComboBox  largeBox, MediumBox;
	JTextField SmallText, SmallidText;
	JButton    add;  

	public Small_Add() {
		init();
	
		setTitle("소분류추가");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
	}
	private void init() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
