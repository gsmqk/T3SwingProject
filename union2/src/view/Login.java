package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.U_Dao;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame implements ActionListener, KeyListener {
	Join           j    = null;
	Find           f    = null;
	MainTable01    mt01 = null;
	JLabel            idLbl, pwLbl;
	public JTextField idTxt;
	JPasswordField    pwTxt;
	JButton           loginBtn;
	
	
	public Login() {
		getContentPane().setBackground(new Color(255, 255, 255));

		getContentPane().setLayout(null);

		setTitle("Grocerlist");
		init();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(360,640);
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/image/title.png")));
		logo.setBounds(30, 30, 280, 260);
		getContentPane().add(logo);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	private void init() {	
		
		JLabel idLbl = new JLabel("아이디");
		idLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		idLbl.setBounds(30, 300, 60, 20);
		getContentPane().add(idLbl);

		idTxt = new JTextField();
		idTxt.setBounds(30, 320, 280, 40);
		getContentPane().add(idTxt);
		idTxt.setColumns(10);
		
		JLabel pwLbl = new JLabel("비밀번호");
		pwLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 14));
		pwLbl.setBounds(30, 365, 60, 20);
		getContentPane().add(pwLbl);

		pwTxt = new JPasswordField();
		pwTxt.setBounds(30, 385, 280, 40);
		getContentPane().add(pwTxt);

		loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon(Login.class.getResource("/image/storageList/12.png")));
		loginBtn.setBackground(new Color(73, 153, 221));
		loginBtn.setForeground(new Color(0, 0, 0));
		loginBtn.setFont(new Font("D2Coding", Font.PLAIN, 18));
		loginBtn.setBounds(30, 440, 280, 40);
		getContentPane().add(loginBtn);

		JButton joinBtn = new JButton("");
		joinBtn.setIcon(new ImageIcon(Login.class.getResource("/image/storageList/13.png")));
		joinBtn.setBackground(new Color(73, 153, 221));
		joinBtn.setFont(new Font("D2Coding", Font.PLAIN, 18));
		joinBtn.setBounds(30, 490, 280, 40);
		getContentPane().add(joinBtn);

		JButton findBtn = new JButton("");
		findBtn.setIcon(new ImageIcon(Login.class.getResource("/image/storageList/14.png")));
		findBtn.setBackground(new Color(73, 153, 221));
		findBtn.setFont(new Font("D2Coding", Font.PLAIN, 18));
		findBtn.setBounds(30, 540, 280, 40);
		getContentPane().add(findBtn);


		// 기능 넣기
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로그인 클릭");
				String aid = idTxt.getText();
				
				if(aid.equals("admin")) {
					adminLogin();
				} else {
					login();
				}
				
			}
		});
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입 클릭");
				
				j = new Join();
				
			}
		});
		findBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("아이디/비밀번호찾기 클릭");
				if(f != null)
					f.dispose();
				f = new Find();
				
			}
		});

		idTxt.addKeyListener(this);
		pwTxt.addKeyListener(this);
	}

	public static void main(String[] args) {
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//		case "로    그    인" : 
//			System.out.println("로그인 클릭");
//			String aid = idTxt.getText();
//			if(aid.equals("admin")) {
//				adminLogin();
//			} else {
//				login();
//			}
//
//			break;
//		case "회  원  가  입" : 
//			System.out.println("회원가입 클릭");
//			if(j != null)
//				j.dispose();
//			j = new Join();
//			break;
//		case "아이디/비밀번호 찾기" :
//			System.out.println("아이디/비밀번호찾기 클릭");
//			if(f != null)
//				f.dispose();
//			f = new Find();
//			break;
//		}

	}

	private void adminLogin() {
		String pw = pwTxt.getText();
		U_Dao uao = new U_Dao();
		boolean flag = uao.adminLogin(pw);

		if (flag == true) {
			JOptionPane.showMessageDialog(null, "관리자로 로그인하셨습니다.");
			Admin ad = new Admin();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "잘못된 정보입니다. 다시 확인해주세요.");
		}

	}

	private void login() {
		String id = idTxt.getText();
		String pw = pwTxt.getText();
		U_Dao uao = new U_Dao();
		
		if (id.equals("") && pw.equals("")) {
			JOptionPane.showMessageDialog(null, "정보를 입력해주세요", "확인", JOptionPane.OK_OPTION);
		} else {
			System.out.println("login:" + pw);
			boolean flag = uao.login(id, pw);

			if (flag == true) {
				this.dispose();
				MainTable01 mt1 = new MainTable01(this);
			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			loginBtn.doClick();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
