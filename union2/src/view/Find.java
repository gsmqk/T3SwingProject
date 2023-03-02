package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;



import model.U_Dao;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		
		JLabel title = new JLabel("아이디/비밀번호 찾기");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 29));
		title.setBounds(44, 10, 297, 63);
		getContentPane().add(title);
		
		//아이디 찾기
		JLabel findIdLbl = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		findIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		findIdLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 18));
		findIdLbl.setBounds(107, 93, 175, 31);
		getContentPane().add(findIdLbl);
		
		//사용한 이메일
		JLabel emailLbl = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 18));
		emailLbl.setBounds(107, 257, 175, 31);
		getContentPane().add(emailLbl);
		
		//비밀번호 찾기
		JLabel pwFindLbl = new JLabel("\uAC00\uC785\uC2DC \uC0AC\uC6A9\uD55C \uC774\uBA54\uC77C");
		pwFindLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		pwFindLbl.setBounds(12, 141, 131, 38);
		getContentPane().add(pwFindLbl);
		
		//비밀번호찾을때 아이디 입력
		JLabel idLbl = new JLabel("\uC544\uC774\uB514");
		idLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		idLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		idLbl.setBounds(12, 308, 116, 38);
		getContentPane().add(idLbl);
		//이메일입력
		JLabel emailLbl2 = new JLabel("\uAC00\uC785\uC2DC \uC0AC\uC6A9\uD55C \uC774\uBA54\uC77C");
		emailLbl2.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		emailLbl2.setBounds(12, 364, 131, 38);
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
		
		JButton idFindBtn = new JButton("아이디 찾기");
		idFindBtn.setBackground(new Color(238, 254, 255));
		idFindBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		idFindBtn.setBounds(75, 206, 109, 23);
		getContentPane().add(idFindBtn);
		
		JButton cancelBtn1 = new JButton("취소");
		cancelBtn1.setBackground(new Color(238, 254, 255));
		cancelBtn1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		cancelBtn1.setBounds(209, 206, 109, 23);
		getContentPane().add(cancelBtn1);
		
		JButton pwFindBtn = new JButton("비밀번호 찾기");
		pwFindBtn.setBackground(new Color(238, 254, 255));
		pwFindBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		pwFindBtn.setBounds(75, 425, 109, 23);
		getContentPane().add(pwFindBtn);
		
		JButton cancelBtn2 = new JButton("취소");
		cancelBtn2.setBackground(new Color(238, 254, 255));
		cancelBtn2.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		cancelBtn2.setBounds(209, 425, 109, 23);
		getContentPane().add(cancelBtn2);
		
		// 기능
		cancelBtn1.addActionListener(this);
		cancelBtn2.addActionListener(this);
		idFindBtn.addActionListener(this);
		pwFindBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Find();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "아이디 찾기" :
			System.out.println("아이디 찾기 클릭");
			idFind();
			break;
		case "비밀번호 찾기" :
			System.out.println("비밀번호 찾기 클릭");
			pwFind();
			break;
		case "취소" :
			this.dispose();
			break;
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