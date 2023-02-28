package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.F_Dao;
import model.G_Dao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Small_Add extends JFrame{
	
	JComboBox  largeBox, MediumBox;
	JLabel     largeLbl, mediumLbl, smallLbl; 
	JTextField SmallText;
	JButton    add, cancle;  
	private JTextField textField;

	public Small_Add() {
		init();
		setTitle("소분류추가");
		
		setSize(400,300);
	
	}
	private void init() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		largeLbl = new JLabel("\uB300\uBD84\uB958 \uC120\uD0DD : ");
		largeLbl.setFont(new Font("굴림", Font.PLAIN, 14));
		largeLbl.setBounds(60, 49, 99, 39);
		getContentPane().add(largeLbl);
		
		mediumLbl = new JLabel("\uC911\uBD84\uB958 \uC120\uD0DD : ");
		mediumLbl.setFont(new Font("굴림", Font.PLAIN, 14));
		mediumLbl.setBounds(60, 98, 99, 39);
		getContentPane().add(mediumLbl);
		
		smallLbl = new JLabel("\uC18C\uBD84\uB958 \uC785\uB825 : ");
		smallLbl.setFont(new Font("굴림", Font.PLAIN, 14));
		smallLbl.setBounds(60, 147, 99, 39);
		getContentPane().add(smallLbl);
		
		F_Dao fao = new F_Dao();
		Vector<String> large = fao.getLarge();
		
		largeBox = new JComboBox(large);
		largeBox.setBounds(171, 52, 163, 32);
		getContentPane().add(largeBox);
		
		MediumBox = new JComboBox();
		MediumBox.setBounds(171, 101, 163, 32);
		getContentPane().add(MediumBox);
		
		SmallText = new JTextField();
		SmallText.setBounds(171, 151, 163, 32);
		getContentPane().add(SmallText);
		SmallText.setColumns(10);
		
		add = new JButton("추가하기");
		add.setBounds(73, 209, 97, 23);
		getContentPane().add(add);
		
		cancle = new JButton("새로고침");
		cancle.setBounds(207, 209, 97, 23);
		getContentPane().add(cancle);
		
		largeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) largeBox.getSelectedItem();
				Vector<String> mList1 = new Vector<String>();
				
				if(selectedItem != null) {
					mList1 = fao.getMiddle(selectedItem);
					System.out.println(mList1);
					MediumBox.setModel(new DefaultComboBoxModel<>(mList1));
				}
				
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				G_Dao dao = new G_Dao();
				String Mediumbox = (String) MediumBox.getSelectedItem();
				String Smalltext = SmallText.getText();
				
				int aftcnt = dao.insertSmall( Mediumbox, Smalltext);
				SmallText.setText("");
				
			}
		});
		
		   cancle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("새로고침클릭");
					SmallText.setText("");
					
				}
			});
	}
	public static void main(String[] args) {
		new Small_Add();

	}
}
