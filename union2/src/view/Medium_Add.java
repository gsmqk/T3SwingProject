package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Medium_Add extends JFrame {

	JComboBox  largeBox;
	JLabel     large, medium, mediumId;
	JTextField MediumText, MediumidText;
	JButton    add, cancle;  
	private JTextField textField;
	private JTextField textField_1;
	
	public Medium_Add() {
		init();
		setTitle("중분류추가");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	private void init() {
		getContentPane().setLayout(null);
		
		largeBox = new JComboBox();
		largeBox.setBounds(139, 34, 172, 36);
		getContentPane().add(largeBox);
		
		large =new JLabel("\uB300\uBD84\uB958\uC120\uD0DD");
		large.setFont(new Font("굴림", Font.PLAIN, 15));
		large.setBounds(35, 34, 86, 46);
		getContentPane().add(large);
		
		medium = new JLabel("\uC911\uBD84\uB958id\uC785\uB825 :");
		medium.setFont(new Font("굴림", Font.PLAIN, 14));
		medium.setBounds(25, 90, 102, 45);
		getContentPane().add(medium);
		
		mediumId = new JLabel("\uC911\uBD84\uB958 \uC785\uB825 :");
		mediumId.setFont(new Font("굴림", Font.PLAIN, 14));
		mediumId.setBounds(35, 145, 102, 36);
		getContentPane().add(mediumId);
		
		MediumText = new JTextField();
		MediumText.setBounds(139, 91, 172, 36);
		getContentPane().add(MediumText);
		MediumText.setColumns(10);
		
		MediumidText = new JTextField();
		MediumidText.setColumns(10);
		MediumidText.setBounds(139, 145, 172, 36);
		getContentPane().add(MediumidText);
		
		add = new JButton("\uCD94\uAC00\uD558\uAE30");
		add.setBounds(77, 208, 97, 23);
		getContentPane().add(add);
		
		cancle = new JButton("\uCDE8\uC18C\uD558\uAE30");
		cancle.setBounds(206, 208, 97, 23);
		getContentPane().add(cancle);
		
		
	}
	public static void main(String[] args) {
		new Medium_Add();

	}
}
