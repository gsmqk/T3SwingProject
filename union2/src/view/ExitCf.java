package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.U_DTO;
import model.U_Dao;

import javax.swing.JButton;

public class ExitCf extends JFrame implements ActionListener {
	
	
	String id;
	
	public ExitCf() {
		getContentPane().setBackground(new Color(255, 255, 255));

		
		
		setTitle("회원탈퇴 확인");
	
		init();
		
	}
	

	
	public ExitCf(String id) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		this.id = id;
		
		setTitle("회원탈퇴 확인");
		
		init();
		
	
		
	}
	
	
	private void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC815\uB9D0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 38));
		lblNewLabel.setBounds(12, 67, 360, 73);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD0C8\uD1F4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(12, 123, 360, 73);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD0C8\uD1F4\uC804 \uC8FC\uC758\uC0AC\uD56D\uC744 \uBAA8\uB450 \uC219\uC9C0\uD558\uC168\uB2E4\uBA74 ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 193, 360, 82);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uD0C8\uD1F4\uD558\uAE30 \uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(12, 225, 360, 82);
		getContentPane().add(lblNewLabel_2_1);
		
		JButton yes = new JButton("탈퇴하기");
		yes.setBounds(75, 317, 97, 23);
		getContentPane().add(yes);
		
		JButton no = new JButton("취소하기");
		no.setBounds(206, 317, 97, 23);
		getContentPane().add(no);
		setVisible(true);
		
		yes.addActionListener(this);
		no.addActionListener(this);
		
		
	}
//	public static void main(String[] args) {
//	  
//
//	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "취소하기" : 
			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
			this.dispose();
			break;
		case "탈퇴하기" :
			System.out.println("탈퇴 확인");
			deleteUser();
			JOptionPane.showMessageDialog(null, "탈퇴되었습니다. 이용해주셔서 감사합니다.");
			System.exit(1);;
			break;
		}
		
	}



	private void deleteUser() {
		U_Dao uao = new U_Dao();
		int aftcnt = 0;
		String id = this.id; 
		aftcnt = uao.removeUser(id);
	}
}
