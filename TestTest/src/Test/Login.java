package Test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	
	
	GridBagConstraints gbc;
	GridBagLayout gbl;
	Font f1, f2;
	Join j = null; // 회원가입전역변수
	
	public Login() {
		setTitle("냉장고를 부탁해");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,400);
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
		
		JLabel title = new JLabel("냉장고를 부탁해");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0,0,4,1);
		
		JPanel pId = new JPanel();
		JLabel idLbl = new JLabel(" 아이디   ");
		idLbl.setFont(f2);
		JTextField idTxt = new JTextField(20);
		pId.add(idLbl);
		pId.add(idTxt);
		
		gblAdd(pId, 0,1,4,1);
		
		JPanel pPw = new JPanel();
		JLabel pwLbl = new JLabel("비밀번호 ");
		pwLbl.setFont(f2);
		JPasswordField pwTxt = new JPasswordField(20);
		pPw.add(pwLbl);
		pPw.add(pwTxt);
		
		gblAdd(pPw, 0, 2, 4, 1);
		
		// 버튼
//		JPanel pButton = new JPanel();
		JButton loginBtn = new JButton("로그인");
		loginBtn.setFont(f2);
		JButton joinBtn = new JButton("회원가입");
		joinBtn.setFont(f2);
		JButton findBtn = new JButton("아이디/비밀번호찾기");
		findBtn.setFont(f2);
		
		gblAdd(loginBtn, 0, 3, 4, 1);
		gblAdd(joinBtn,  0, 4, 4, 1);
		gblAdd(findBtn,  0, 5, 4, 1);
		
		
		
//		pButton.add(loginBtn);
//		pButton.add(joinBtn);
//		gblAdd(pButton, 0, 3, 4, 1);
		
		// 기능 넣기
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		
	}

	private void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx      = x;
		gbc.gridy      = y;
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets     = new Insets(5, 5, 5, 5);
		this.add(c, gbc);
		
	}

	public static void main(String[] args) {
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "로그인" : break;
		case "회원가입" : 
			System.out.println("회원가입 클릭");
			if(j != null)
				j.dispose();
			j = new Join();
			break;
		}
		
	}

}