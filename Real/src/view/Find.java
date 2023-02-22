package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.U_Dao;

public class Find extends JFrame implements ActionListener {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2, f3, f4;
	JTextField emailTxt, idTxt, emailTxt2;
	
	public Find() {
		setTitle("회원가입");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
	}
	
	private void init() {

		gbl = new GridBagLayout();
		this.setLayout(gbl);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		f1 = new Font("HY견고딕", Font.BOLD, 40);
		f2 = new Font("HY견고딕", Font.BOLD, 20);
		f3 = new Font("HY견고딕", Font.PLAIN, 15);
		f4 = new Font("HY견고딕", Font.BOLD, 15);
		
		// 제목
		JLabel title = new JLabel("아이디/비밀번호 찾기");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 아이디 찾기
		JLabel findIdLbl = new JLabel("아이디 찾기");
		findIdLbl.setFont(f2);
		findIdLbl.setHorizontalAlignment(JLabel.LEFT);
		gblAdd(findIdLbl, 0, 1, 4, 1);
		
		// 아이디찾기 입력칸
		JLabel emailLbl = new JLabel("가입시 사용한 이메일");
		emailLbl.setFont(f3);
		emailTxt = new JTextField(20);
		
		gblAdd(emailLbl, 0, 2, 1, 1);
		gblAdd(emailTxt, 1, 2, 3, 1);
		
		// 버튼
		JPanel pBtn = new JPanel();
		JButton idFindBtn = new JButton("아이디 찾기");
		JButton cancelBtn1 = new JButton("취소");
		idFindBtn.setFont(f4);
		cancelBtn1.setFont(f4);
		
		pBtn.add(idFindBtn);
		pBtn.add(cancelBtn1);
		
		gblAdd(pBtn, 0, 3, 10, 1);
		
		// 비밀번호 찾기
		JLabel pwFindLbl = new JLabel("비밀번호 찾기");
		pwFindLbl.setFont(f2);
		findIdLbl.setHorizontalAlignment(JLabel.LEFT);
		gblAdd(pwFindLbl, 0, 4, 10, 1);
		
		// 비밀번호 입력창
		JLabel idLbl = new JLabel("아이디");
		idTxt = new JTextField();
		idLbl.setFont(f3);
		gblAdd(idLbl, 0, 5, 2, 1);
		gblAdd(idTxt, 1, 5, 8, 1);
		
		JLabel emailLbl2 = new JLabel("가입시 사용한 이메일");
		emailTxt2 = new JTextField();
		emailLbl2.setFont(f3);
		gblAdd(emailLbl2, 0, 6, 2, 1);
		gblAdd(emailTxt2, 1, 6, 8, 1);
		
		// 비밀번호 버튼
		JPanel  pBtn2 = new JPanel();
		JButton pwFindBtn = new JButton("비밀번호 찾기");
		JButton cancelBtn2 = new JButton("취소");
		pwFindBtn.setFont(f4);
		cancelBtn2.setFont(f4);
		pBtn2.add(pwFindBtn);
		pBtn2.add(cancelBtn2);
		gblAdd(pBtn2, 0, 7, 10, 1);
		
		// 기능
		cancelBtn1.addActionListener(this);
		cancelBtn2.addActionListener(this);
		idFindBtn.addActionListener(this);
		pwFindBtn.addActionListener(this);
		
	}
	
	public void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets = new Insets(5,5,5,5);
		this.add(c,gbc);
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
