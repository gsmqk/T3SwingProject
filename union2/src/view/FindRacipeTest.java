package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FindRacipeTest {

	private JFrame frame;
	private RecipeConn jwtest;
	private JTextField food;
	static JTextField foodList; 
	StringBuffer b1 = new StringBuffer();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindRacipeTest window = new FindRacipeTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FindRacipeTest(RecipeConn jwtest) {
		this();
		this.jwtest = jwtest;
	}

	
	public FindRacipeTest() {
		initialize();
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("레시피 검색");
		frame.setBounds(100, 100, 400, 600);
		frame.getContentPane().setLayout(null);
		frame.setSize(500,700); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon(FindRacipeTest.class.getResource("/image/storageList/24.png")));
		lbl.setBounds(32, 77, 300, 40);
		panel.add(lbl);
		
		food = new JTextField();
		food.setBounds(32, 127, 307, 100);
		panel.add(food);
		food.setColumns(10);
		
		JButton btnAdd = new JButton("");
		btnAdd.setBackground(new Color(73, 153, 221));
		btnAdd.setIcon(new ImageIcon(FindRacipeTest.class.getResource("/image/storageList/21.png")));
		btnAdd.setBounds(351, 127, 100, 100);
		panel.add(btnAdd);
		
		JLabel lbl_1 = new JLabel("");
		lbl_1.setIcon(new ImageIcon(FindRacipeTest.class.getResource("/image/storageList/25.png")));
		lbl_1.setBounds(-21, 320, 283, 40);
		panel.add(lbl_1);
		
		
		foodList = new JTextField();
		foodList.setColumns(10);
		foodList.setBounds(32, 360, 419, 125);
		panel.add(foodList);
		
		JButton btnFind = new JButton("");
		btnFind.setBackground(new Color(73, 153, 221));
		btnFind.setIcon(new ImageIcon(FindRacipeTest.class.getResource("/image/storageList/22.png")));
		btnFind.setBounds(106, 556, 100, 50);
		panel.add(btnFind);
		
		JButton btnCancel = new JButton("");
		btnCancel.setBackground(new Color(73, 153, 221));
		btnCancel.setIcon(new ImageIcon(FindRacipeTest.class.getResource("/image/storageList/23.png")));
		btnCancel.setBounds(275, 556, 100, 50);
		panel.add(btnCancel);
		frame.setVisible(true);
		
		food.addKeyListener(new KeyListener() {
	  		
	  		@Override
	  		public void keyTyped(KeyEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  		}
	  		
	  		@Override
	  		public void keyReleased(KeyEvent e) {
	  			if(e.getKeyCode() == 10) {
	  				btnAdd.doClick();
	  			}
	  			
	  		}
	  		
	  		@Override
	  		public void keyPressed(KeyEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  		}
	  	});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.append(food.getText() + " ");
				foodList.setText(b1.toString());
				food.setText("");
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RecipeConn.findrecipe();
				frame.setVisible(false);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		
		
	}
}
