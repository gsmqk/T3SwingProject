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
import javax.swing.ImageIcon;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ExitCf.class.getResource("/image/storageList/bye (1).png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 38));
		lblNewLabel.setBounds(12, 58, 360, 70);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ExitCf.class.getResource("/image/storageList/bye (2).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(12, 121, 360, 73);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ExitCf.class.getResource("/image/storageList/bye (3).png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 193, 360, 82);
		getContentPane().add(lblNewLabel_2);
		
		JButton yes = new JButton("");
		yes.setIcon(new ImageIcon(ExitCf.class.getResource("/image/storageList/bye (4).png")));
		yes.setBackground(new Color(73, 153, 221));
		yes.setBounds(75, 317, 100, 40);
		getContentPane().add(yes);
		
		JButton no = new JButton("");
		no.setIcon(new ImageIcon(ExitCf.class.getResource("/image/storageList/bye (5).png")));
		no.setBackground(new Color(73, 153, 221));
		no.setBounds(206, 317, 100, 40);
		getContentPane().add(no);
		setVisible(true);
		
		yes.addActionListener(this);
		no.addActionListener(this);
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("탈퇴 확인");
				deleteUser();
				JOptionPane.showMessageDialog(null, "탈퇴되었습니다. 이용해주셔서 감사합니다.");
				System.exit(1);;
				
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "취소하셨습니다.");
				setVisible(false);
				
			}
		});
		
		
	}
//	public static void main(String[] args) {
//	  
//
//	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
//		case "취소하기" : 
//			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
//			this.dispose();
//			break;
//		case "탈퇴하기" :
//			System.out.println("탈퇴 확인");
//			deleteUser();
//			JOptionPane.showMessageDialog(null, "탈퇴되었습니다. 이용해주셔서 감사합니다.");
//			System.exit(1);;
//			break;
		}
		
	}



	private void deleteUser() {
		U_Dao uao = new U_Dao();
		int aftcnt = 0;
		String id = this.id; 
		aftcnt = uao.removeUser(id);
	}
}
