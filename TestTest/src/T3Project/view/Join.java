package T3Project.view;
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

public class Join extends JFrame implements ActionListener{

	GridBagLayout gbl;
	GridBagConstraints gbc;
	JTextField idTxt, nameTxt, emailTxt;
	JPasswordField pwTxt, pwcfTxt;
	JButton cfBtn, joinBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, pwcfLbl, nameLbl, emailLbl; 
	Font f1, f2;
	
	public Join() {
		
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
		
		// 제목
		title = new JLabel("회원가입");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 아이디
		JPanel pId = new JPanel();
		idLbl = new JLabel("아이디 :");
		idLbl.setFont(f2);
		idTxt = new JTextField(15);
		cfBtn = new JButton("중복확인");
		
		pId = new JPanel();
		pId.add(idLbl);
		pId.add(idTxt);
		pId.add(cfBtn);
		
		gblAdd(pId,0,1,4,1);
		
		// 비밀번호
		JPanel pPw = new JPanel();
		pwLbl = new JLabel("비밀번호 :");
		pwLbl.setFont(f2);
		pwTxt = new JPasswordField(20);
		
		pPw.add(pwLbl);
		pPw.add(pwTxt);
		
		gblAdd(pPw, 0, 2, 4, 1);
		
		// 비밀번호 확인
		JPanel pCF = new JPanel();
		pwcfLbl = new JLabel("비밀번호 확인:");
		pwcfLbl.setFont(f2);
		pwcfTxt = new JPasswordField(20);
		
		pCF.add(pwcfLbl);
		pCF.add(pwcfTxt);
		
		gblAdd(pCF, 0, 3, 4, 1);
		
		// 이름
		JPanel pName = new JPanel();
		nameLbl = new JLabel("이름 :");
		nameLbl.setFont(f2);
		nameTxt = new JTextField(20);
		
		pName.add(nameLbl);
		pName.add(nameTxt);
		
		gblAdd(pName, 0, 4, 4, 1);
		
		// 이메일
		JPanel pMail = new JPanel();
		emailLbl = new JLabel("이메일 :");
		emailLbl.setFont(f2);
		emailTxt = new JTextField(20);
		
		pMail.add(emailLbl);
		pMail.add(emailTxt);
		
		gblAdd(pMail, 0, 5, 4, 1);
		
		// 버튼
		JPanel pButton = new JPanel();
		joinBtn = new JButton("회원가입");
		cancelBtn = new JButton("입력취소");
		
		pButton.add(joinBtn);
		pButton.add(cancelBtn);
		
		gblAdd(pButton, 0, 6, 4, 1);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	

//	public static void main(String[] args) {
//		new Join();
//	}

}