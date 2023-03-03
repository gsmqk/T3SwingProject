package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.U_Dao;

public class Find extends JFrame implements ActionListener {

	
	
	
	
	JTextField emailTxt, idTxt, emailTxt2;

	public Find() {
		getContentPane().setBackground(new Color(255, 255, 255));
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,560);
		setVisible(true);
	}

	private void init() {
		setTitle("아이디/비밀번호 찾기");
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (8).png")));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 29));
		title.setBounds(44, 10, 300, 60);
		getContentPane().add(title);
		
		//아이디 찾기
		JLabel findIdLbl = new JLabel("");
		findIdLbl.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (4).png")));
		findIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		findIdLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 18));
		findIdLbl.setBounds(107, 93, 175, 32);
		getContentPane().add(findIdLbl);
		
		//사용한 이메일
		JLabel emailLbl = new JLabel("");
		emailLbl.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (5).png")));
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 18));
		emailLbl.setBounds(107, 257, 175, 32);
		getContentPane().add(emailLbl);
		
		//비밀번호 찾기
		JLabel pwFindLbl = new JLabel("");
		pwFindLbl.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (6).png")));
		pwFindLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		pwFindLbl.setBounds(12, 141, 130, 40);
		getContentPane().add(pwFindLbl);
		
		//비밀번호찾을때 아이디 입력
		JLabel idLbl = new JLabel("");
		idLbl.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (7).png")));
		idLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		idLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		idLbl.setBounds(12, 308, 130, 40);
		getContentPane().add(idLbl);
		//이메일입력
		JLabel emailLbl2 = new JLabel("");
		emailLbl2.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (6).png")));
		emailLbl2.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		emailLbl2.setBounds(12, 364, 130, 40);
		getContentPane().add(emailLbl2);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		emailTxt.setBounds(155, 141, 208, 38);
		getContentPane().add(emailTxt);
		emailTxt.setColumns(10);
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		idTxt.setColumns(10);
		idTxt.setBounds(155, 310, 208, 38);
		getContentPane().add(idTxt);
		
		emailTxt2 = new JTextField();
		emailTxt2.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		emailTxt2.setColumns(10);
		emailTxt2.setBounds(155, 364, 208, 38);
		getContentPane().add(emailTxt2);
		
		JButton idFindBtn = new JButton("");
		idFindBtn.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (1).png")));
		idFindBtn.setBackground(new Color(73, 153, 221));
		idFindBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		idFindBtn.setBounds(75, 206, 110, 32);
		getContentPane().add(idFindBtn);
		
		JButton cancelBtn1 = new JButton("");
		cancelBtn1.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (3).png")));
		cancelBtn1.setBackground(new Color(73, 153, 221));
		cancelBtn1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		cancelBtn1.setBounds(209, 206, 110, 32);
		getContentPane().add(cancelBtn1);
		
		JButton pwFindBtn = new JButton("");
		pwFindBtn.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (2).png")));
		pwFindBtn.setBackground(new Color(73, 153, 221));
		pwFindBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		pwFindBtn.setBounds(75, 425, 110, 32);
		getContentPane().add(pwFindBtn);
		
		JButton cancelBtn2 = new JButton("");
		cancelBtn2.setIcon(new ImageIcon(Find.class.getResource("/image/storageList/id (3).png")));
		cancelBtn2.setBackground(new Color(73, 153, 221));
		cancelBtn2.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		cancelBtn2.setBounds(209, 425, 110, 32);
		getContentPane().add(cancelBtn2);
		
		
		cancelBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		cancelBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		idFindBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("아이디 찾기 클릭");
				idFind();
				
			}
		});
		pwFindBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("비밀번호 찾기 클릭");
				pwFind();
				
			}
		});
		
		// 기능
		
//		cancelBtn1.addActionListener(this);
//		cancelBtn2.addActionListener(this);
//		idFindBtn.addActionListener(this);
//		pwFindBtn.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new Find();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
//		case "아이디 찾기" :
//			System.out.println("아이디 찾기 클릭");
//			idFind();
//			break;
//		case "비밀번호 찾기" :
//			System.out.println("비밀번호 찾기 클릭");
//			pwFind();
//			break;
//		case "닫기" :
//			this.dispose();
//			break;
		}
		
	}

	private void pwFind() {
		String id = idTxt.getText();
		String email = emailTxt2.getText();
		U_Dao uao = new U_Dao();
		uao.findPw(id,email);
	}

	private void idFind() {
		String email = emailTxt.getText();
		U_Dao uao = new U_Dao();
		uao.findId(email);
		
	}

}